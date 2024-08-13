@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER")
package uni.UNI174BAC2;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.unicloud.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile;
import io.dcloud.uniapp.extapi.env as uni_env;
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import uts.sdk.modules.testInvokeNetworkApi.testInovkeDownloadFile;
import uts.sdk.modules.testInvokeNetworkApi.testInovkeRequest;
import uts.sdk.modules.testInvokeNetworkApi.CommonOptions;
open class GenPagesAPIDownloadFileDownloadFile : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLoad(fun(_: OnLoadOptions) {}, __ins);
        onUnload(fun() {
            uni_hideLoading();
            this.task?.abort();
        }
        , __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createElementVNode("view", null, utsArrayOf(
                createVNode(_component_page_head, utsMapOf("title" to _ctx.title), null, 8, utsArrayOf(
                    "title"
                )),
                createElementVNode("view", null, utsArrayOf(
                    if (isTrue(_ctx.imageSrc)) {
                        createElementVNode("view", utsMapOf("key" to 0), utsArrayOf(
                            createElementVNode("image", utsMapOf("class" to "img", "src" to _ctx.imageSrc, "mode" to "aspectFit"), null, 8, utsArrayOf(
                                "src"
                            ))
                        ));
                    } else {
                        createElementVNode("view", utsMapOf("key" to 1, "style" to normalizeStyle(utsMapOf("margin" to "10px"))), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "uni-hello-text"), "点击按钮下载服务端示例图片（下载网络文件到本地临时目录）"),
                            createElementVNode("button", utsMapOf("type" to "primary", "onClick" to _ctx.downloadImage), "下载", 8, utsArrayOf(
                                "onClick"
                            ))
                        ), 4);
                    }
                ))
            ))
        ), 4);
    }
    open var title: String by `$data`;
    open var imageSrc: String by `$data`;
    open var task: DownloadTask? by `$data`;
    open var jest_result: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("title" to "downloadFile", "imageSrc" to "", "task" to null as DownloadTask?, "jest_result" to false);
    }
    override fun `$initMethods`() {
        this.downloadImage = fun() {
            uni_showLoading(ShowLoadingOptions(title = "下载中"));
            var self = this;
            this.task = uni_downloadFile(DownloadFileOptions(url = "https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/uni-app.png", success = fun(res){
                console.log("downloadFile success, res is", res.tempFilePath, " at pages/API/download-file/download-file.uvue:56");
                self.imageSrc = res.tempFilePath;
                uni_hideLoading();
            }
            , fail = fun(err){
                console.log("downloadFile fail, err is:", err, " at pages/API/download-file/download-file.uvue:61");
                uni_hideLoading();
            }
            ));
            this.task?.onProgressUpdate(fun(update){
                console.log("progress : ", update.progress, " at pages/API/download-file/download-file.uvue:66");
            }
            );
        }
        ;
        this.jest_downloadFile = fun() {
            uni_downloadFile(DownloadFileOptions(url = "https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/uni-app.png", success = fun(_){
                this.jest_result = true;
            }
            , fail = fun(_){
                this.jest_result = false;
            }
            ));
        }
        ;
        this.jest_downloadFile_with_uni_env = fun() {
            uni_downloadFile(DownloadFileOptions(url = "https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/uni-app.png", filePath = "" + uni_env.CACHE_PATH + "/a/b/", success = fun(_){
                this.jest_result = true;
            }
            , fail = fun(_){
                this.jest_result = false;
            }
            ));
        }
        ;
        this.jest_set_cookie = fun() {
            uni_request<Any>(RequestOptions(url = "https://request.dcloud.net.cn/api/http/header/setCookie", method = "GET", timeout = 6000, sslVerify = false, withCredentials = true, firstIpv4 = false, success = fun(_){
                this.jest_cookie_download(true);
            }
            , fail = fun(_){
                this.jest_result = false;
            }
            ));
        }
        ;
        this.jest_delete_cookie = fun() {
            uni_request<Any>(RequestOptions(url = "https://request.dcloud.net.cn/api/http/header/deleteCookie", method = "GET", timeout = 6000, sslVerify = false, withCredentials = true, firstIpv4 = false, success = fun(_){
                this.jest_cookie_download(false);
            }
            , fail = fun(_){
                this.jest_result = false;
            }
            ));
        }
        ;
        this.jest_cookie_download = fun(needCookie: Boolean) {
            uni_downloadFile(DownloadFileOptions(url = "https://request.dcloud.net.cn/api/http/header/download", success = fun(_){
                this.jest_result = if (needCookie) {
                    true;
                } else {
                    false;
                }
                ;
            }
            , fail = fun(_){
                this.jest_result = if (needCookie) {
                    false;
                } else {
                    true;
                }
                ;
            }
            ));
        }
        ;
        this.jest_uts_module_invoked = fun() {
            testInovkeDownloadFile(CommonOptions(success = fun(res: Any){
                console.log("success :", res, " at pages/API/download-file/download-file.uvue:143");
                this.jest_result = true;
            }
            , fail = fun(err: Any){
                console.log("fail :", err, " at pages/API/download-file/download-file.uvue:147");
                this.jest_result = false;
            }
            ));
        }
        ;
        this.jest_special_characters_download = fun() {
            uni_downloadFile(DownloadFileOptions(url = "https://web-ext-storage.dcloud.net.cn/hello-uni-app-x/1789834995055525889-你好%23你好.png", success = fun(res: DownloadFileSuccess){
                this.jest_result = true;
                console.log("res :", res, " at pages/API/download-file/download-file.uvue:158");
            }
            , fail = fun(_){
                this.jest_result = false;
            }
            ));
        }
        ;
    }
    open lateinit var downloadImage: () -> Unit;
    open lateinit var jest_downloadFile: () -> Unit;
    open lateinit var jest_downloadFile_with_uni_env: () -> Unit;
    open lateinit var jest_set_cookie: () -> Unit;
    open lateinit var jest_delete_cookie: () -> Unit;
    open lateinit var jest_cookie_download: (needCookie: Boolean) -> Unit;
    open lateinit var jest_uts_module_invoked: () -> Unit;
    open lateinit var jest_special_characters_download: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ), utsArrayOf(
                    GenApp.styles
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("img" to padStyleMapOf(utsMapOf("marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
