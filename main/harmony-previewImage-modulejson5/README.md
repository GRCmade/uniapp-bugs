======== README.md ========

# 鸿蒙上修改module.json5导致 previewImage的 saveImageToPhotosAlbum 失效

在本项目vue3下的 harmony-configs下,有一个新的 Module.json5 这个文件加上之后,鸿蒙的saveImageToPhotosAlbum就失效了

失效情况下:
8 file://com.yuhe.template/data/storage/el2/base/cache/HBuilder/uni-download/54a19f76-8b3b-4e67-ae1a-c6aec2c16e70(31).jpg
8 [{"title":"54a19f76-8b3b-4e67-ae1a-c6aec2c16e70(31)","fileNameExtension":"jpg","photoType":1}]
正常情况下:
8 file://com.yuhe.template/data/storage/el2/base/cache/HBuilder/uni-download/54a19f76-8b3b-4e67-ae1a-c6aec2c16e70(25).jpg
8 [{"title":"54a19f76-8b3b-4e67-ae1a-c6aec2c16e70(25)","fileNameExtension":"jpg","photoType":1}]

======== END ========
