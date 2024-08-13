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
import io.dcloud.uniapp.extapi.startPullDownRefresh as uni_startPullDownRefresh;
import io.dcloud.uniapp.extapi.stopPullDownRefresh as uni_stopPullDownRefresh;
open class GenPagesAPIGetCurrentPagesGetCurrentPages : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLoad(fun(_: OnLoadOptions) {
            this.getPageStyle();
        }
        , __ins);
        onPullDownRefresh(fun() {
            setTimeout(fun(){
                uni_stopPullDownRefresh();
            }
            , 2000);
        }
        , __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass);
        val _component_switch = resolveComponent("switch");
        val _component_slider = resolveComponent("slider");
        val _component_radio = resolveComponent("radio");
        val _component_radio_group = resolveComponent("radio-group");
        return createElementVNode("scroll-view", utsMapOf("class" to "page-scroll-view"), utsArrayOf(
            createVNode(_component_page_head, utsMapOf("title" to "getCurrentPages")),
            createElementVNode("view", utsMapOf("class" to "uni-padding-wrap"), utsArrayOf(
                createElementVNode("button", utsMapOf("onClick" to _ctx._getCurrentPages), "getCurrentPages", 8, utsArrayOf(
                    "onClick"
                )),
                if (isTrue(_ctx.pages.length)) {
                    createElementVNode("view", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("padding" to "15px 0px"))), utsArrayOf(
                        createElementVNode("text", null, "当前页面栈中 " + toDisplayString(_ctx.pages.length) + " 个页面，列表如下：", 1),
                        createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.pages, fun(page, index, __index, _cached): Any {
                            return createElementVNode("text", utsMapOf("key" to page.route, "style" to normalizeStyle(utsMapOf("margin-top" to "5px"))), "index: " + toDisplayString(index) + ", route: " + toDisplayString(page.route), 5);
                        }), 128)
                    ), 4);
                } else {
                    createCommentVNode("v-if", true);
                }
            )),
            createVNode(_component_page_head, utsMapOf("title" to "currentPageStyle")),
            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.PageStyleArray, fun(item, index, __index, _cached): Any {
                return createElementVNode(Fragment, null, utsArrayOf(
                    if (_ctx.currentPageStyle[item.key] != null) {
                        createElementVNode("view", utsMapOf("class" to "page-style-item", "key" to index), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "item-text"), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "item-text-key"), toDisplayString(item.key) + ":", 1),
                                createElementVNode("text", utsMapOf("class" to "item-text-value"), toDisplayString(_ctx.currentPageStyle[item.key]), 1)
                            )),
                            if (item.type == "boolean") {
                                createElementVNode("view", utsMapOf("key" to 0, "class" to "set-value"), utsArrayOf(
                                    createVNode(_component_switch, utsMapOf("checked" to _ctx.currentPageStyle.getBoolean(item.key), "onChange" to fun(`$event`: Any){
                                        _ctx.switchChange(item.key, `$event` as UniSwitchChangeEvent);
                                    }), null, 8, utsArrayOf(
                                        "checked",
                                        "onChange"
                                    ))
                                ));
                            } else {
                                if (item.type == "number") {
                                    createElementVNode("view", utsMapOf("key" to 1, "class" to "set-value"), utsArrayOf(
                                        createVNode(_component_slider, utsMapOf("value" to _ctx.currentPageStyle.getNumber(item.key), "show-value" to true, "onChange" to fun(`$event`: Any){
                                            _ctx.sliderChange(item.key, `$event` as UniSliderChangeEvent);
                                        }), null, 8, utsArrayOf(
                                            "value",
                                            "onChange"
                                        ))
                                    ));
                                } else {
                                    if (item.type == "string") {
                                        createElementVNode("view", utsMapOf("key" to 2, "class" to "set-value"), utsArrayOf(
                                            createVNode(_component_radio_group, utsMapOf("class" to "radio-set-value", "onChange" to fun(`$event`: Any){
                                                _ctx.radioChange(item.key, `$event` as RadioGroupChangeEvent);
                                            }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode(Fragment, null, RenderHelpers.renderList(item.value, fun(item2, index2, __index, _cached): Any {
                                                        return createVNode(_component_radio, utsMapOf("class" to "radio-value", "key" to index2, "value" to item2), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return utsArrayOf(
                                                                toDisplayString(item2)
                                                            );
                                                        }), "_" to 2), 1032, utsArrayOf(
                                                            "value"
                                                        ));
                                                    }), 128)
                                                );
                                            }), "_" to 2), 1032, utsArrayOf(
                                                "onChange"
                                            ))
                                        ));
                                    } else {
                                        createCommentVNode("v-if", true);
                                    };
                                };
                            }
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                ), 64);
            }
            ), 256)
        ));
    }
    open var checked: Boolean by `$data`;
    open var pages: UTSArray<Page2> by `$data`;
    open var PageStyleArray: UTSArray<PageStyleItem> by `$data`;
    open var currentPageStyle: UTSJSONObject by `$data`;
    open var pageStyleText: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("checked" to false, "pages" to utsArrayOf<Page2>(), "PageStyleArray" to uni.UNI174BAC2.PageStyleArray as UTSArray<PageStyleItem>, "currentPageStyle" to UTSJSONObject(), "pageStyleText" to computed<String>(fun(): String {
            return JSON.stringify(this.currentPageStyle);
        }
        ));
    }
    override fun `$initMethods`() {
        this.startPullDownRefresh = fun() {
            uni_startPullDownRefresh(null);
        }
        ;
        this._getCurrentPages = fun() {
            this.pages.length = 0;
            val pages = getCurrentPages();
            this.pages.push(Page2(pages[0].route));
            if (this.pages[0].route.includes("/tabBar/")) {
                this.checked = true;
            }
            run {
                var i: Number = 1;
                while(i < pages.length){
                    this.pages.push(Page2(pages[i].route));
                    if (pages[i].route.includes("/tabBar/")) {
                        this.checked = false;
                    }
                    i++;
                }
            }
        }
        ;
        this.radioChange = fun(key: String, e: RadioGroupChangeEvent) {
            this.setStyleValue(key, e.detail.value);
        }
        ;
        this.sliderChange = fun(key: String, e: UniSliderChangeEvent) {
            this.setStyleValue(key, e.detail.value);
        }
        ;
        this.switchChange = fun(key: String, e: UniSwitchChangeEvent) {
            this.setStyleValue(key, e.detail.value);
        }
        ;
        this.setStyleValue = fun(key: String, value: Any) {
            val style = object : UTSJSONObject(UTSSourceMapPosition("style", "pages/API/get-current-pages/get-current-pages.uvue", 103, 15)) {
            };
            style[key] = value;
            this.setPageStyle(style);
            this.getPageStyle();
        }
        ;
        this.getPageStyle = fun(): UTSJSONObject {
            val pages = getCurrentPages();
            val currentPage = pages[pages.length - 1];
            this.currentPageStyle = currentPage.`$getPageStyle`();
            return this.currentPageStyle;
        }
        ;
        this.setPageStyle = fun(style: UTSJSONObject) {
            console.log("setPageStyle:", style, " at pages/API/get-current-pages/get-current-pages.uvue:115");
            val pages = getCurrentPages();
            val currentPage = pages[pages.length - 1];
            currentPage.`$setPageStyle`(style);
        }
        ;
    }
    open lateinit var startPullDownRefresh: () -> Unit;
    open lateinit var _getCurrentPages: () -> Unit;
    open lateinit var radioChange: (key: String, e: RadioGroupChangeEvent) -> Unit;
    open lateinit var sliderChange: (key: String, e: UniSliderChangeEvent) -> Unit;
    open lateinit var switchChange: (key: String, e: UniSwitchChangeEvent) -> Unit;
    open lateinit var setStyleValue: (key: String, value: Any) -> Unit;
    open lateinit var getPageStyle: () -> UTSJSONObject;
    open lateinit var setPageStyle: (style: UTSJSONObject) -> Unit;
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
                return utsMapOf("page" to padStyleMapOf(utsMapOf("flex" to 1, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "page-style" to padStyleMapOf(utsMapOf("marginTop" to 15)), "page-style-item" to padStyleMapOf(utsMapOf("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "marginTop" to 10, "backgroundColor" to "#ffffff", "borderRadius" to 5)), "item-text" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "item-text-key" to padStyleMapOf(utsMapOf("fontWeight" to "bold")), "item-text-value" to padStyleMapOf(utsMapOf("marginLeft" to 5)), "set-value" to padStyleMapOf(utsMapOf("marginTop" to 10)), "radio-set-value" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "radio-value" to padStyleMapOf(utsMapOf("marginLeft" to 10)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
