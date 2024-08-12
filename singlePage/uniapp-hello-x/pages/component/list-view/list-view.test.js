describe('component-native-list-view', () => {
  let page
  beforeAll(async () => {
    //打开list-view测试页
    page = await program.reLaunch('/pages/component/list-view/list-view')
    await page.waitFor(600)
  })

  //检测竖向scrolltop属性赋值
  it('check_scroll_top', async () => {
    await page.callMethod('confirm_scroll_top_input', 600)
    await page.waitFor(600)
    const listElement = await page.$('#listview')
    const scrollTop = await listElement.attribute("scrollTop")
    console.log("check_scroll_top---"+scrollTop)
    expect(scrollTop-600).toBeGreaterThanOrEqual(0)
  })


  //检测横向scrollLeft属性赋值 备注：iOS不支持list-view横向滚动
  it('check_scroll_left', async () => {
    if(await page.data('scroll_x_boolean') === false) {
        await page.callMethod('change_scroll_x_boolean', true)
        await page.callMethod('change_scroll_y_boolean', false)
        await page.waitFor(600)
    }
    await page.callMethod('confirm_scroll_left_input', 600)
    await page.waitFor(600)
    const listElement = await page.$('#listview')
    const scrollLeft = await listElement.attribute("scrollLeft")
    console.log("check_scroll_left---"+scrollLeft)
    expect(scrollLeft-600).toBeGreaterThanOrEqual(0)
  })

  it('Event check_scroll', async () => {
    await page.callMethod('change_scroll_y_boolean', true)
    await page.callMethod('change_scroll_x_boolean', false)
    await page.waitFor(600)
    await page.callMethod('confirm_scroll_top_input', 300)
    await page.waitFor(600)
    // 在web端scroll事件event参数中detail类型报错，先忽略测试
    if(!process.env.UNI_UTS_PLATFORM.startsWith('web')){
      const scrollDetail = await page.data('scrollDetailTest')
      console.log('scrollDetailTest:', scrollDetail)
      expect(scrollDetail.scrollLeft).toBe(0)
      // 在安卓端差异 299.8095
      expect([300, 299.8095]).toContain(scrollDetail.scrollTop);
      expect(scrollDetail.scrollHeight).toBeGreaterThan(0)
      // 在安卓端 "scrollWidth":0
      if(!process.env.UNI_UTS_PLATFORM.startsWith('app-android')){
        expect(scrollDetail.scrollWidth).toBeGreaterThan(0)
      }
      expect(scrollDetail.deltaX).toBe(0)
      // 在安卓端差异 299.8095
      expect([300, 299.8095]).toContain(scrollDetail.deltaY);
    }
    expect(await page.data('isScrollTest')).toBe('scroll:Success')
  })

  it('Event scrolltolower-滚动到底部/右边',async()=>{
    // 滚动到底部,是否触发scrolltolower事件
    await page.callMethod('confirm_scroll_top_input', 2500)
    await page.waitFor(600)
    expect(await page.data('isScrolltolowerTest')).toBe('scrolltolower:Success-bottom')
  })

  it('Event scrolltoupper-滚动到顶部/左边',async()=>{
    // 滚动到顶部50,是否触发scrolltoupper事件
    await page.callMethod('confirm_scroll_top_input', 50)
    await page.waitFor(2000)
    expect(await page.data('isScrolltoupperTest')).toBe('scrolltoupper:Success-top')
  })

  if (process.env.uniTestPlatformInfo.indexOf('web') > -1) {
    return
  }

  if(process.env.uniTestPlatformInfo.toLowerCase().startsWith('ios')) {
    return
  }

  it('Event scrollend-滚动结束时触发',async()=>{
    // 仅App端支持,向上滑动页面
    await program.swipe({
      startPoint: { x: 100, y: 300 },
      endPoint: { x: 100, y: 100 },
      duration: 100
    })
    await page.waitFor(600)
    const endDetail = await page.data('scrollEndDetailTest')
    console.log('scrollEndDetailTest:', endDetail)
    expect(endDetail.deltaY).toBe(0)
    expect(endDetail.deltaX).toBe(0)
    expect(endDetail.scrollLeft).toBe(0)
    expect(endDetail.scrollTop).toBeGreaterThan(0)
    expect(endDetail.scrollHeight).toBeGreaterThan(0)
    // 在安卓端 "scrollWidth":0
    // expect(endDetail.scrollWidth).toBeGreaterThan(0)
  })

  //检测竖向可滚动区域
  it('check_scroll_height', async () => {
    await page.callMethod('change_scroll_y_boolean', true)
    await page.callMethod('change_scroll_x_boolean', false)
    await page.waitFor(600)
    const value = await page.callMethod('check_scroll_height')
    expect(value).toBe(true)
  })

  //检测横向可滚动区域 备注：iOS不支持list-view横向滚动
  it('check_scroll_width', async () => {
    if(await page.data('scroll_x_boolean') === false) {
        await page.callMethod('change_scroll_x_boolean', true)
        await page.callMethod('change_scroll_y_boolean', false)
        await page.waitFor(600)
    }
    await page.callMethod('change_scroll_y_boolean', false)
    await page.callMethod('change_scroll_x_boolean', true)
    await page.waitFor(600)
    const value = await page.callMethod('check_scroll_width')
    expect(value).toBe(true)
  })

  //检测下拉刷新 备注：iOS本地测试结果正确，但是自动化测试结果错误
  it('check_refresher', async () => {
    if(await page.data('scroll_y_boolean') === false) {
        await page.callMethod('change_scroll_y_boolean', true)
        await page.callMethod('change_scroll_x_boolean', false)
        await page.waitFor(600)
    }
    await page.setData({
        refresher_enabled_boolean: true,
        refresher_triggered_boolean: true
    })
    await page.waitFor(2000)
    expect(await page.data('refresherrefresh')).toBe(true)
  })

  //检测竖向scroll_into_view属性赋值 备注：iOS本地测试结果正确，但是自动化测试结果错误
  it('check_scroll_into_view_top', async () => {
    if(await page.data('scroll_y_boolean') === false) {
        await page.callMethod('change_scroll_y_boolean', true)
        await page.callMethod('change_scroll_x_boolean', false)
        await page.waitFor(600)
    }
    await page.callMethod('item_change_size_enum', 3)
    await page.waitFor(600)
    const listElement = await page.$('#listview')
    const scrollTop = await listElement.attribute("scrollTop")
    console.log("check_scroll_into_view_top--"+scrollTop)
    await page.callMethod('item_change_size_enum', 0)
    expect(scrollTop-690).toBeGreaterThanOrEqual(0)
  })

  //检测横向scroll_into_view属性赋值 备注：iOS不支持list-view横向滚动
  it('check_scroll_into_view_left', async () => {
    if(await page.data('scroll_x_boolean') === false) {
        await page.callMethod('change_scroll_x_boolean', true)
        await page.callMethod('change_scroll_y_boolean', false)
        await page.waitFor(600)
    }
    await page.callMethod('item_change_size_enum', 3)
    await page.waitFor(600)
    const listElement = await page.$('#listview')
    const scrollLeft = await listElement.attribute("scrollLeft")
    console.log("check_scroll_into_view_left--"+scrollLeft)
    await page.callMethod('item_change_size_enum', 0)
    expect(scrollLeft-1080).toBeGreaterThanOrEqual(0)
  })
})
