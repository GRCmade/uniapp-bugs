======== README.md ========

#鸿蒙上 uni 小程序 sdk previewImage 第二次打开不显示

修复了一个版本:

```
let pageId:string
let imagePreviewerController: CustomDialogController
function initImagePreviewerOnce(pageIdIn:string) : CustomDialogController {
  if(imagePreviewerController && (pageId == pageIdIn)) {
    return imagePreviewerController
  }
  // new CustomDialogController所在的作用域的this必须指向Component
  imagePreviewerController = new CustomDialogController({
    builder: ImagePreviewer({
      urls: previewImageUrls,
      state: previewImageState
    }),
    alignment: DialogAlignment.Center,
    // backgroundColor: '#FF000000', // 此属性在customStyle: true时无效果
    customStyle: true
  })
  return imagePreviewerController
}

interface IPreviewImageOptions {
  urls: string[],
  current?: string
  showmenu?: boolean
}

export function previewImage(options: IPreviewImageOptions, page: Object) {
  let id:string = page["id_"]
  // 切页面relaunch到其他页面不影响预览界面显示
  initImagePreviewerOnce.bind(page)(id)
  pageId = id
  imagePreviewerController.close()
  previewImageUrls.splice(0, previewImageUrls.length)
  const urls = options.urls
  const currentUrl = options.current || urls[0] || ''
  previewImageState.currentIndex = Math.max(0, urls.indexOf(currentUrl))
  previewImageState.showmenu = options.showmenu === false ? false : true
  urls.forEach(url => {
    previewImageUrls.push(url)
  })
  imagePreviewerController.open()
}

```

添加了一个`page["id_"]` 来标识页面,通过这样解决

======== END ========
