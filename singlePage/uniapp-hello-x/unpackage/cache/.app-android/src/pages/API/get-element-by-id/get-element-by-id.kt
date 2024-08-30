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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
open class GenPagesAPIGetElementByIdGetElementById : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_page_head, utsMapOf("id" to "page-head", "title" to "getElementById")),
            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("margin" to "0 15px"))), utsArrayOf(
                createElementVNode("text", utsMapOf("id" to "text"), "this is text"),
                createElementVNode("view", utsMapOf("id" to "view", "class" to "uni-common-mt", "style" to normalizeStyle(utsMapOf("border" to "1px solid red"))), "this is view", 4),
                createElementVNode("button", utsMapOf("class" to "uni-btn", "onClick" to _ctx.changePageHeadBackgroundColor), " 修改 page-head 背景色 ", 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("button", utsMapOf("class" to "uni-btn", "onClick" to _ctx.changeTextColor), " 修改 text 字体颜色 ", 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("button", utsMapOf("class" to "uni-btn", "onClick" to _ctx.changeViewStyle), " 修改 view 宽高及背景色 ", 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("button", utsMapOf("class" to "uni-btn", "onClick" to _ctx.goMultipleRootNode), " 跳转多根节点示例 ", 8, utsArrayOf(
                    "onClick"
                ))
            ), 4)
        ), 64);
    }
    open var checked: Boolean by `$data`;
    open var homePagePath: String by `$data`;
    open var launchOptionsPath: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("checked" to false, "homePagePath" to "/pages/tabBar/component", "launchOptionsPath" to "");
    }
    override fun `$initMethods`() {
        this.getElementByNotExistId = fun(): Element? {
            return uni_getElementById("not-exist-id");
        }
        ;
        this.changePageHeadBackgroundColor = fun() {
            val pageHead = uni_getElementById("page-head")!!;
            pageHead.style.setProperty("background-color", "red");
        }
        ;
        this.changeTextColor = fun() {
            val text = uni_getElementById("text")!!;
            text.style.setProperty("color", "red");
        }
        ;
        this.changeViewStyle = fun() {
            val view = uni_getElementById<UniViewElement>("view");
            if (view !== null) {
                view.style.setProperty("width", "90%");
                view.style.setProperty("height", "50px");
                view.style.setProperty("background-color", "#007AFF");
            }
        }
        ;
        this.goMultipleRootNode = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/API/get-element-by-id/get-element-by-id-multiple-root-node"));
        }
        ;
        this.getTextOffsetLeft = fun(): Number {
            val text = uni_getElementById("text")!!;
            return text.offsetLeft;
        }
        ;
    }
    open lateinit var getElementByNotExistId: () -> Element?;
    open lateinit var changePageHeadBackgroundColor: () -> Unit;
    open lateinit var changeTextColor: () -> Unit;
    open lateinit var changeViewStyle: () -> Unit;
    open lateinit var goMultipleRootNode: () -> Unit;
    open lateinit var getTextOffsetLeft: () -> Number;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(), utsArrayOf(
                    GenApp.styles
                ));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}