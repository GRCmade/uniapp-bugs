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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit;
import io.dcloud.uniapp.extapi.`$off` as uni__off;
import io.dcloud.uniapp.extapi.`$on` as uni__on;
import io.dcloud.uniapp.extapi.`$once` as uni__once;
open class GenPagesAPIEventBusEventBus : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("scroll-view", utsMapOf("class" to "page-scroll-view"), utsArrayOf(
            createElementVNode("view", null, utsArrayOf(
                createElementVNode("button", utsMapOf("onClick" to _ctx.on), "开始监听", 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("button", utsMapOf("onClick" to _ctx.once), "监听一次", 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("button", utsMapOf("onClick" to _ctx.off), "取消监听", 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("button", utsMapOf("onClick" to _ctx.emit), "触发监听", 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("button", utsMapOf("onClick" to _ctx.clear), "清空消息", 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("view", utsMapOf("class" to "box"), utsArrayOf(
                    createElementVNode("view", null, "收到的消息："),
                    createElementVNode("view", null, utsArrayOf(
                        createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.log, fun(item, index, __index, _cached): Any {
                            return createElementVNode("view", utsMapOf("key" to index), toDisplayString(item), 1);
                        }
                        ), 128)
                    ))
                ))
            ))
        ));
    }
    open var log: UTSArray<String> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("log" to utsArrayOf<String>());
    }
    override fun `$initMethods`() {
        this.fn = fun(res: String) {
            this.log.push(res);
        }
        ;
        this.fn2 = fun(res: String) {
            this.log.push(res);
        }
        ;
        this.on = fun() {
            uni__on("test", this.fn);
        }
        ;
        this.on2 = fun() {
            uni__on("test", this.fn2);
        }
        ;
        this.once = fun() {
            uni__once("test", this.fn);
        }
        ;
        this.off = fun() {
            uni__off("test", this.fn);
        }
        ;
        this.offAll = fun() {
            uni__off("test", null);
        }
        ;
        this.emit = fun() {
            uni__emit("test", "msg:" + Date.now());
        }
        ;
        this.clear = fun() {
            this.log.length = 0;
        }
        ;
    }
    open lateinit var fn: (res: String) -> Unit;
    open lateinit var fn2: (res: String) -> Unit;
    open lateinit var on: () -> Unit;
    open lateinit var on2: () -> Unit;
    open lateinit var once: () -> Unit;
    open lateinit var off: () -> Unit;
    open lateinit var offAll: () -> Unit;
    open lateinit var emit: () -> Unit;
    open lateinit var clear: () -> Unit;
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
                return utsMapOf("box" to padStyleMapOf(utsMapOf("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
