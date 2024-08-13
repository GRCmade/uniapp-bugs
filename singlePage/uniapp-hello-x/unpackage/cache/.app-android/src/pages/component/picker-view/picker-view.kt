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
open class GenPagesComponentPickerViewPickerView : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass);
        val _component_picker_view_column = resolveComponent("picker-view-column");
        val _component_picker_view = resolveComponent("picker-view", true);
        return createElementVNode("view", null, utsArrayOf(
            createVNode(_component_page_head, utsMapOf("title" to _ctx.title), null, 8, utsArrayOf(
                "title"
            )),
            createElementVNode("view", utsMapOf("class" to "uni-padding-wrap"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "uni-title"), " 日期：" + toDisplayString(_ctx.year) + "年" + toDisplayString(_ctx.month) + "月" + toDisplayString(_ctx.day) + "日 ", 1)
            )),
            createVNode(_component_picker_view, utsMapOf("class" to "picker-view", "indicator-style" to _ctx.indicatorStyle, "value" to _ctx.value, "onChange" to _ctx.bindChange, "mask-top-style" to _ctx.maskTopStyle, "mask-bottom-style" to _ctx.maskBottomStyle), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createVNode(_component_picker_view_column, utsMapOf("class" to "picker-view-column"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.years, fun(item, index, __index, _cached): Any {
                                return createElementVNode("view", utsMapOf("class" to "item", "key" to index), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "text"), toDisplayString(item) + "年", 1)
                                ));
                            }
                            ), 128)
                        );
                    }
                    ), "_" to 1)),
                    createVNode(_component_picker_view_column, utsMapOf("class" to "picker-view-column"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.months, fun(item, index, __index, _cached): Any {
                                return createElementVNode("view", utsMapOf("class" to "item", "key" to index), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "text"), toDisplayString(item) + "月", 1)
                                ));
                            }
                            ), 128)
                        );
                    }
                    ), "_" to 1)),
                    createVNode(_component_picker_view_column, utsMapOf("class" to "picker-view-column"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.days, fun(item, index, __index, _cached): Any {
                                return createElementVNode("view", utsMapOf("class" to "item", "key" to index), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "text"), toDisplayString(item) + "日", 1)
                                ));
                            }
                            ), 128)
                        );
                    }
                    ), "_" to 1))
                );
            }
            ), "_" to 1), 8, utsArrayOf(
                "indicator-style",
                "value",
                "onChange",
                "mask-top-style",
                "mask-bottom-style"
            ))
        ));
    }
    open var title: String by `$data`;
    open var years: UTSArray<Number> by `$data`;
    open var year: Number by `$data`;
    open var months: UTSArray<Number> by `$data`;
    open var month: Number by `$data`;
    open var days: UTSArray<Number> by `$data`;
    open var day: Number by `$data`;
    open var value: UTSArray<Number> by `$data`;
    open var result: UTSArray<Number> by `$data`;
    open var indicatorStyle: String by `$data`;
    open var maskTopStyle: String by `$data`;
    open var maskBottomStyle: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        val date = Date();
        val _years: UTSArray<Number> = utsArrayOf();
        val _year = date.getFullYear();
        val _months: UTSArray<Number> = utsArrayOf();
        val _month: Number = date.getMonth() + 1;
        val _days: UTSArray<Number> = utsArrayOf();
        val _day = date.getDate();
        run {
            var i: Number = 2000;
            while(i <= _year){
                _years.push(i);
                i++;
            }
        }
        run {
            var i: Number = 1;
            while(i <= 12){
                _months.push(i);
                i++;
            }
        }
        run {
            var i: Number = 1;
            while(i <= 31){
                _days.push(i);
                i++;
            }
        }
        return utsMapOf("title" to "picker-view", "years" to _years as UTSArray<Number>, "year" to _year as Number, "months" to _months as UTSArray<Number>, "month" to _month as Number, "days" to _days as UTSArray<Number>, "day" to _day as Number, "value" to utsArrayOf<Number>(_year - 2000, _month - 1, _day - 1), "result" to utsArrayOf<Number>(), "indicatorStyle" to "height: 50px;", "maskTopStyle" to "", "maskBottomStyle" to "");
    }
    override fun `$initMethods`() {
        this.getEventCallbackNum = fun(): Number {
            return state.eventCallbackNum;
        }
        ;
        this.setEventCallbackNum = fun(num: Number) {
            uni.UNI174BAC2.setEventCallbackNum(num);
        }
        ;
        this.bindChange = fun(e: UniPickerViewChangeEvent) {
            console.log(e.target?.tagName, e.type, " at pages/component/picker-view/picker-view.uvue:71");
            if ((e.target?.tagName ?: "").includes("PICKER-VIEW")) {
                this.setEventCallbackNum(state.eventCallbackNum + 1);
            }
            if (e.type === "change") {
                this.setEventCallbackNum(state.eventCallbackNum + 2);
            }
            val kVal = e.detail.value;
            this.result = kVal;
            this.year = this.years[kVal[0]];
            this.month = this.months[kVal[1]];
            this.day = this.days[kVal[2]];
        }
        ;
        this.setValue = fun() {
            this.value = utsArrayOf<Number>(0, 0, 0);
        }
        ;
        this.setValue1 = fun() {
            this.value = utsArrayOf<Number>(10, 10, 10);
        }
        ;
    }
    open lateinit var getEventCallbackNum: () -> Number;
    open lateinit var setEventCallbackNum: (num: Number) -> Unit;
    open lateinit var bindChange: (e: UniPickerViewChangeEvent) -> Unit;
    open lateinit var setValue: () -> Unit;
    open lateinit var setValue1: () -> Unit;
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
                return utsMapOf("picker-view" to padStyleMapOf(utsMapOf("width" to "100%", "height" to 320, "marginTop" to 10)), "item" to padStyleMapOf(utsMapOf("height" to 50)), "text" to padStyleMapOf(utsMapOf("lineHeight" to "50px", "textAlign" to "center")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
