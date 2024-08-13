@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER")
package uni.UNI174BAC2;
import android.content.Intent;
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
import java.io.File;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesTemplateShareShare : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("id" to "viewshot"), utsArrayOf(
            createElementVNode("button", utsMapOf("class" to "button", "onClick" to fun(){
                _ctx.shareText("https://uniapp.dcloud.io/uni-app-x", "分享到");
            }
            ), "分享文本", 8, utsArrayOf(
                "onClick"
            )),
            createElementVNode("button", utsMapOf("class" to "button", "onClick" to _ctx.shareSnapShot), "指定view截图并分享", 8, utsArrayOf(
                "onClick"
            ))
        ));
    }
    override fun `$initMethods`() {
        this.shareText = fun(text: String, title: String) {
            val context = UTSAndroid.getUniActivity()!!;
            val intent = Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, text);
            context.startActivity(Intent.createChooser(intent, title));
        }
        ;
        this.shareSnapShot = fun() {
            uni_getElementById("viewshot")?.takeSnapshot(TakeSnapshotOptions(success = fun(res) {
                console.log(res.tempFilePath, " at pages/template/share/share.uvue:32");
                val context = UTSAndroid.getUniActivity()!!;
                val intent = Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                var file = File(res.tempFilePath);
                val uri = UTSAndroid.getFileProviderUri(file);
                intent.putExtra(Intent.EXTRA_STREAM, uri);
                context.startActivity(Intent.createChooser(intent, "分享到"));
            }
            , fail = fun(res) {
                console.log(res, " at pages/template/share/share.uvue:42");
                uni_showToast(ShowToastOptions(icon = "error", title = "截图失败"));
            }
            ));
        }
        ;
    }
    open lateinit var shareText: (text: String, title: String) -> Unit;
    open lateinit var shareSnapShot: () -> Unit;
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
                return utsMapOf("button" to padStyleMapOf(utsMapOf("marginTop" to 15, "marginRight" to 15, "marginBottom" to 15, "marginLeft" to 15)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
