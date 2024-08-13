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
open class GenPagesCSSTextFontFamily : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "uni-padding-wrap"), utsArrayOf(
            createElementVNode("text", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("font-family" to "monospace"))), "font-family: monospace", 4),
            createElementVNode("text", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("font-family" to "cursive"))), "font-family: cursive", 4),
            createElementVNode("text", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("font-family" to "AlimamaDaoLiTiTTF"))), "font-family: 阿里妈妈刀隶体-ttf（网络字体下载后生效）", 4),
            createElementVNode("text", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("font-family" to "AlimamaDaoLiTiOTF"))), "font-family: 阿里妈妈刀隶体-otf", 4),
            createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("font-family" to "UniFontFamily"))), "style 加载非 static 目录字体文件：" + toDisplayString(_ctx.uniIcon), 5)
        ));
    }
    open var uniIcon: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("uniIcon" to "\ue100");
    }
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
                return utsMapOf("common" to padStyleMapOf(utsMapOf("fontSize" to 20, "lineHeight" to "40px")), "@FONT-FACE" to utsMapOf("0" to utsMapOf("fontFamily" to "AlimamaDaoLiTiTTF", "src" to "url('https://qiniu-web-assets.dcloud.net.cn/uni-app-x/static/font/AlimamaDaoLiTi.ttf')"), "1" to utsMapOf("fontFamily" to "AlimamaDaoLiTiOTF", "src" to "url('/static/font/AlimamaDaoLiTi.otf')"), "2" to utsMapOf("fontFamily" to "UniFontFamily", "src" to "url('/assets/uni.173d2b94.ttf')")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
