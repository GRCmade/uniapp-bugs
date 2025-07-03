======== README.md ========

# 鸿蒙 renderjs 的 html2canvas 跨域问题

在 html2canvas 调用的时候,会触发createElement,创建一个 iframe
创建iframe之后,调用 Document.open的时候,会触发跨域问题

需要理解一下跨域,跨域是

只要 iframe.src 的 URL 与当前页面的 protocol、host、port 任一不一致，就是“非同源”，浏览器就会阻止你访问 iframe.contentDocument 或调用其方法（如 .open()、.write()）

在这里调用的时候
======== END ========
