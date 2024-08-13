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
open class GenPagesComponentRichTextRichText : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _cache = this.`$`.renderCache;
        val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass);
        val _component_navigator = resolveComponent("navigator");
        return createElementVNode("view", null, utsArrayOf(
            createVNode(_component_page_head, utsMapOf("title" to "rich-text")),
            createElementVNode("view", utsMapOf("class" to "uni-padding-wrap uni-common-mt"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "uni-btn-v"), utsArrayOf(
                    createVNode(_component_navigator, utsMapOf("url" to "/pages/component/rich-text/rich-text-tags"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("button", utsMapOf("type" to "primary"), "rich-text渲染单个HTML标签示例")
                        );
                    }
                    ), "_" to 1))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-btn-v"), utsArrayOf(
                    createVNode(_component_navigator, utsMapOf("url" to "/pages/component/rich-text/rich-text-complex"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("button", utsMapOf("type" to "primary"), "rich-text渲染复杂HTML示例")
                        );
                    }
                    ), "_" to 1))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-title"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "uni-subtitle-text"), "selectable")
                )),
                createElementVNode("view", utsMapOf("class" to "text-box"), utsArrayOf(
                    createElementVNode("rich-text", utsMapOf("selectable" to true, "nodes" to "<span>hello uni-app x!</span><br/><span>uni-app x，终极跨平台方案</span>"))
                ))
            ))
        ));
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
                return utsMapOf("text-box" to padStyleMapOf(utsMapOf("paddingTop" to 20, "paddingRight" to 0, "paddingBottom" to 20, "paddingLeft" to 0, "backgroundColor" to "#FFFFFF")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
