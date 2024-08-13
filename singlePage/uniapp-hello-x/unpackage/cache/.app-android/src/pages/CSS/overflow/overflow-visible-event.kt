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
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesCSSOverflowOverflowVisibleEvent : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", null, utsArrayOf(
            createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("font-size" to "15px"))), "overflow=visible 父view（绿色），子view（红色），点击超出父view区域的部分也可触发事件。", 4),
            createElementVNode("view", utsMapOf("class" to "backgroundview"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "box-visible-border-radius"), utsArrayOf(
                    createElementVNode("view", utsMapOf("id" to "child", "style" to normalizeStyle(utsMapOf("width" to "50px", "height" to "150px", "background-color" to "red")), "onClick" to _ctx.handleClickOverflowPart, "onTouchmove" to _ctx.handleTouchMoveOverflowPart), null, 44, utsArrayOf(
                        "onClick",
                        "onTouchmove"
                    ))
                ))
            ))
        ));
    }
    open var jest_result: Boolean by `$data`;
    open var jest_click_x: Number by `$data`;
    open var jest_click_y: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("jest_result" to false, "jest_click_x" to -1, "jest_click_y" to -1);
    }
    override fun `$initMethods`() {
        this.handleClickOverflowPart = fun() {
            console.log("click", " at pages/CSS/overflow/overflow-visible-event.uvue:25");
            this.jest_result = true;
            uni_showToast(ShowToastOptions(title = "点击红色区域"));
        }
        ;
        this.handleTouchMoveOverflowPart = fun(e: UniTouchEvent) {
            console.log("touchmove:" + e.touches[0].clientX + "," + e.touches[0].clientY, " at pages/CSS/overflow/overflow-visible-event.uvue:30");
        }
        ;
        this.handleClick = fun(str: String) {
            console.log("\u70B9\u51FB\u4E86 " + str + " view", " at pages/CSS/overflow/overflow-visible-event.uvue:33");
            if (str == "red") {
                this.jest_result = true;
            }
        }
        ;
        this.jest_getRect = fun() {
            val rect = uni_getElementById("child")?.getBoundingClientRect();
            if (rect != null) {
                val ratio = uni_getSystemInfoSync().devicePixelRatio;
                this.jest_click_x = rect.x * ratio + 10;
                this.jest_click_y = rect.bottom * ratio - 10;
            }
        }
        ;
    }
    open lateinit var handleClickOverflowPart: () -> Unit;
    open lateinit var handleTouchMoveOverflowPart: (e: UniTouchEvent) -> Unit;
    open lateinit var handleClick: (str: String) -> Unit;
    open lateinit var jest_getRect: () -> Unit;
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
                return utsMapOf("backgroundview" to padStyleMapOf(utsMapOf("width" to 300, "height" to 300, "marginBottom" to 20, "backgroundColor" to "#FFFFFF", "justifyContent" to "center", "alignItems" to "center")), "box-visible-border-radius" to padStyleMapOf(utsMapOf("width" to 100, "height" to 100, "borderRadius" to 20, "overflow" to "visible", "backgroundColor" to "#008000")), "hover-class" to padStyleMapOf(utsMapOf("backgroundColor" to "#00FFFF")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
