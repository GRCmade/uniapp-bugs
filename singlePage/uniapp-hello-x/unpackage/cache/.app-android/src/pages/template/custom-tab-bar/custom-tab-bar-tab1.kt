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
open class GenPagesTemplateCustomTabBarCustomTabBarTab1 : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onCreated(fun() {
            this.loadData();
        }
        , __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("scroll-view", utsMapOf("ref" to "listView", "class" to "list", "rebound" to false, "scroll-with-animation" to true, "scroll-y" to true, "onScrolltolower" to fun(){
            _ctx.loadData();
        }
        , "onScroll" to _ctx.onScroll), utsArrayOf(
            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.dataList, fun(item, index, __index, _cached): Any {
                return createElementVNode("view", utsMapOf("class" to "list-item", "key" to index), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "cell-item"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "title"), "内容：" + toDisplayString(item.title), 1),
                        createElementVNode("input", utsMapOf("class" to "title", "style" to normalizeStyle(utsMapOf("margin-top" to "8px")), "placeholder" to "备注:"), null, 4)
                    ))
                ));
            }
            ), 128)
        ), 40, utsArrayOf(
            "onScrolltolower",
            "onScroll"
        ));
    }
    open var dataList: UTSArray<ListItem6> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("dataList" to utsArrayOf<ListItem6>());
    }
    override fun `$initMethods`() {
        this.loadData = fun() {
            var index = this.dataList.length;
            run {
                var i: Number = 0;
                while(i < 20){
                    this.dataList.push(ListItem6(title = index.toString()));
                    index++;
                    i++;
                }
            }
        }
        ;
        this.onScroll = fun(e: ScrollEvent) {
            uni__emit("tabchange", e.detail.scrollTop);
        }
        ;
        this.scrollTop = fun(top: Number) {
            (this.`$refs`["listView"] as UniElement).scrollTop = top;
        }
        ;
    }
    open lateinit var loadData: () -> Unit;
    open lateinit var onScroll: (e: ScrollEvent) -> Unit;
    open lateinit var scrollTop: (top: Number) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("list" to padStyleMapOf(utsMapOf("flex" to 1, "backgroundColor" to "#ffffff")), "list-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "paddingTop" to 30, "paddingRight" to 30, "paddingBottom" to 30, "paddingLeft" to 30, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#dbdbdb")), "title" to padStyleMapOf(utsMapOf("fontSize" to 16, "textAlign" to "left")), "cell-item" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
