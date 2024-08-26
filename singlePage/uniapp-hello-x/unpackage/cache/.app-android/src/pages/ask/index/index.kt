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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
open class GenPagesAskIndexIndex : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLoad(fun(_: OnLoadOptions) {}, __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to ""), utsArrayOf(
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.ls, fun(it, i, __index, _cached): Any {
                    return createElementVNode("view", utsMapOf("key" to i), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "title"), toDisplayString(it.day), 1),
                        createElementVNode("view", utsMapOf("class" to "box"), utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(it.list, fun(item, index, __index, _cached): Any {
                                return createElementVNode("view", utsMapOf("key" to index), utsArrayOf(
                                    createElementVNode("button", utsMapOf("onClick" to fun(){
                                        _ctx.click(item);
                                    }
                                    , "size" to "mini", "type" to "primary"), toDisplayString(item), 9, utsArrayOf(
                                        "onClick"
                                    ))
                                ));
                            }
                            ), 128)
                        ))
                    ));
                }
                ), 128)
            ))
        ), 4);
    }
    open var title: String by `$data`;
    open var ls: UTSArray<ItemType> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("title" to "Hello", "ls" to utsArrayOf<ItemType>(ItemType(day = "week 9", list = utsArrayOf(
            197240,
            197219,
            197227,
            197226
        )), ItemType(day = "8.10", list = utsArrayOf(
            196402,
            196484,
            182989
        ))));
    }
    override fun `$initMethods`() {
        this.click = fun(id: Number) {
            val prefixPattern = UTSRegExp("^docisue", "");
            if (prefixPattern.test(JSON.stringify(id))) {
                val str = "/pages/ask/doc/" + id + "/" + id;
                console.log(str, " at pages/ask/index/index.uvue:47");
                uni_navigateTo(NavigateToOptions(url = str));
            } else {
                val str = "/pages/ask/problem/" + id + "/" + id;
                console.log(str, " at pages/ask/index/index.uvue:53");
                uni_navigateTo(NavigateToOptions(url = str));
            }
        }
        ;
    }
    open lateinit var click: (id: Number) -> Unit;
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
                return utsMapOf("box" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "width" to "100%", "flexWrap" to "wrap")), "button" to padStyleMapOf(utsMapOf("marginTop" to "10rpx", "marginRight" to "10rpx", "marginBottom" to "10rpx", "marginLeft" to "10rpx", "fontSize" to "30rpx", "fontWeight" to "700", "paddingTop" to "5rpx", "paddingRight" to "8rpx", "paddingBottom" to "5rpx", "paddingLeft" to "8rpx")), "content" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center")), "logo" to padStyleMapOf(utsMapOf("height" to "200rpx", "width" to "200rpx", "marginTop" to "200rpx", "marginLeft" to "auto", "marginRight" to "auto", "marginBottom" to "50rpx")), "text-area" to padStyleMapOf(utsMapOf("display" to "flex", "justifyContent" to "center")), "title" to padStyleMapOf(utsMapOf("marginLeft" to "20rpx", "fontSize" to "36rpx", "color" to "#8f8f94")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
