describe('component-native-list-view-refresh', () => {
  if (process.env.uniTestPlatformInfo.startsWith('web')) {
    it('dummyTest', async () => {
      expect(1).toBe(1)
    })
    return
  }
  let page
  beforeAll(async () => {
    //打开list-view测试页
    page = await program.reLaunch('/pages/component/list-view/list-view-refresh')
    await page.waitFor(600)
  })

  it('check_list_view_refresh', async () => {
    await page.waitFor(async () => {
      return await page.data('refresherTriggered') === false;
    });
    //等待下拉刷新结束
    await page.waitFor(500)
    const image = await program.screenshot({fullPage: true});
    expect(image).toSaveImageSnapshot();
    // 手动设置下拉刷新状态refresher-triggered为true时，在iOS不触发@refresherpulling事件,并且e.detail.dy为0
    if(process.env.UNI_UTS_PLATFORM.startsWith('app-android')){
      expect(await page.data('onRefresherpullingTest')).toBe('refresherpulling:Success')
      expect(await page.data('refresherrefreshTest')).toBe('refresherrefresh:Success')
      await page.waitFor(1000);
      expect(await page.data('onRefresherrestoreTest')).toBe('refresherrestore:Success')
    }
  })

  it('check_refresherabort', async () => {
    // 仅App端支持手势下拉刷新
    await program.swipe({
      startPoint: {x: 100,y: 400},
      endPoint: {x: 100,y: 500},
      duration: 1000
    })
    await page.waitFor(1500)
    // 下拉刷新被中止，在iOS不触发@refresherabort事件
    if(process.env.UNI_UTS_PLATFORM.startsWith('app-android')){
      expect(await page.data('onRefresherabortTest')).toBe('refresherabort:Success')
    }
  });

})