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
import io.dcloud.uniapp.extapi.getLocation as uni_getLocation;
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
open class GenPagesAPIGetLocationGetLocation : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass);
        val _component_u_link = resolveEasyComponent("u-link", GenComponentsULinkULinkClass);
        val _component_radio = resolveComponent("radio");
        val _component_radio_group = resolveComponent("radio-group");
        val _component_switch = resolveComponent("switch");
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_page_head, utsMapOf("title" to _ctx.title), null, 8, utsArrayOf(
                "title"
            )),
            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("padding" to "4px"))), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "hello-text"), " 定位功能默认调用操作系统定位API实现。\n 部分手机因gms兼容不好可能导致无法定位。\n gcj国标、逆地理信息等功能需三方sdk定位。如果需要类似能力可以下载腾讯定位插件，打包自定义基座。参考示例："),
                createVNode(_component_u_link, utsMapOf("href" to "https://ext.dcloud.net.cn/plugin?id=14569", "text" to "https://ext.dcloud.net.cn/plugin?id=14569", "inWhiteList" to true), null, 8, utsArrayOf(
                    "href",
                    "text"
                ))
            ), 4),
            createElementVNode("view", utsMapOf("class" to "uni-padding-wrap uni-common-mt"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "uni-list"), utsArrayOf(
                    createVNode(_component_radio_group, utsMapOf("onChange" to _ctx.radioChange), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.items, fun(item, index, __index, _cached): Any {
                                return createVNode(_component_radio, utsMapOf("class" to normalizeClass(utsArrayOf(
                                    "uni-list-cell uni-list-cell-pd",
                                    if (index < _ctx.items.length - 1) {
                                        "uni-list-cell-line";
                                    } else {
                                        "";
                                    }
                                )), "key" to item.value, "value" to item.value, "checked" to (index === _ctx.current)), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        toDisplayString(item.name)
                                    );
                                }
                                ), "_" to 2), 1032, utsArrayOf(
                                    "class",
                                    "value",
                                    "checked"
                                ));
                            }
                            ), 128)
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "onChange"
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-list-cell uni-list-cell-pd"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "uni-list-cell-db"), "高度信息"),
                    createVNode(_component_switch, utsMapOf("checked" to _ctx.altitudeSelect, "onChange" to _ctx.altitudeChange), null, 8, utsArrayOf(
                        "checked",
                        "onChange"
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-list-cell uni-list-cell-pd"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "uni-list-cell-db"), "开启高精度定位"),
                    createVNode(_component_switch, utsMapOf("checked" to _ctx.isHighAccuracySelect, "onChange" to _ctx.highAccuracySelectChange), null, 8, utsArrayOf(
                        "checked",
                        "onChange"
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-list-cell uni-list-cell-pd"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "uni-list-cell-db"), "是否解析地址信息"),
                    createVNode(_component_switch, utsMapOf("checked" to _ctx.geocodeSelect, "onChange" to _ctx.geocodeChange), null, 8, utsArrayOf(
                        "checked",
                        "onChange"
                    ))
                )),
                createElementVNode("text", null, toDisplayString(_ctx.exeRet), 1),
                createElementVNode("view", utsMapOf("class" to "uni-btn-v"), utsArrayOf(
                    createElementVNode("button", utsMapOf("class" to "uni-btn", "type" to "default", "onClick" to _ctx.getLocationTap), "获取定位", 8, utsArrayOf(
                        "onClick"
                    ))
                ))
            ))
        ), 64);
    }
    open var title: String by `$data`;
    open var altitudeSelect: Boolean by `$data`;
    open var isHighAccuracySelect: Boolean by `$data`;
    open var geocodeSelect: Boolean by `$data`;
    open var exeRet: String by `$data`;
    open var items: UTSArray<ItemType7> by `$data`;
    open var current: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("title" to "get-location", "altitudeSelect" to false, "isHighAccuracySelect" to false, "geocodeSelect" to false, "exeRet" to "", "items" to utsArrayOf<ItemType7>(ItemType7(value = "wgs84", name = "wgs84"), ItemType7(value = "gcj02", name = "gcj02")), "current" to 0);
    }
    override fun `$initMethods`() {
        this.altitudeChange = fun(e: UniSwitchChangeEvent) {
            this.altitudeSelect = e.detail.value;
        }
        ;
        this.geocodeChange = fun(e: UniSwitchChangeEvent) {
            this.geocodeSelect = e.detail.value;
        }
        ;
        this.highAccuracySelectChange = fun(e: UniSwitchChangeEvent) {
            this.isHighAccuracySelect = e.detail.value;
        }
        ;
        this.radioChange = fun(e: UniRadioGroupChangeEvent) {
            run {
                var i: Number = 0;
                while(i < this.items.length){
                    if (this.items[i].value === e.detail.value) {
                        this.current = i;
                        break;
                    }
                    i++;
                }
            }
        }
        ;
        this.getLocationTap = fun() {
            uni_showLoading(ShowLoadingOptions(title = "定位中"));
            uni_getLocation(GetLocationOptions(type = this.items[this.current].value, altitude = this.altitudeSelect, isHighAccuracy = this.isHighAccuracySelect, geocode = this.geocodeSelect, success = fun(res: Any){
                uni_hideLoading();
                console.log(res, " at pages/API/get-location/get-location.uvue:94");
                this.exeRet = JSON.stringify(res);
            }
            , fail = fun(res: Any){
                uni_hideLoading();
                console.log(res, " at pages/API/get-location/get-location.uvue:99");
                this.exeRet = JSON.stringify(res);
            }
            , complete = fun(res: Any){
                uni_hideLoading();
                console.log(res, " at pages/API/get-location/get-location.uvue:104");
                this.exeRet = JSON.stringify(res);
            }
            ));
        }
        ;
    }
    open lateinit var altitudeChange: (e: UniSwitchChangeEvent) -> Unit;
    open lateinit var geocodeChange: (e: UniSwitchChangeEvent) -> Unit;
    open lateinit var highAccuracySelectChange: (e: UniSwitchChangeEvent) -> Unit;
    open lateinit var radioChange: (e: UniRadioGroupChangeEvent) -> Unit;
    open lateinit var getLocationTap: () -> Unit;
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
