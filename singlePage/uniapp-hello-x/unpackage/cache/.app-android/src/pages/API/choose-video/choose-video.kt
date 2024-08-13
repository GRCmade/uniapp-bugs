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
import io.dcloud.uniapp.extapi.chooseVideo as uni_chooseVideo;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
open class GenPagesAPIChooseVideoChooseVideo : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass);
        val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass);
        val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass);
        val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createVNode(_component_page_head, utsMapOf("title" to _ctx.title), null, 8, utsArrayOf(
                "title"
            )),
            createElementVNode("view", utsMapOf("class" to "uni-padding-wrap"), utsArrayOf(
                createElementVNode("video", utsMapOf("class" to "video", "src" to _ctx.src, "controls" to true), null, 8, utsArrayOf(
                    "src"
                )),
                createElementVNode("view", utsMapOf("class" to "uni-title"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "uni-subtitle-text"), "视频信息")
                )),
                createElementVNode("text", null, toDisplayString(_ctx.videoInfo), 1),
                createElementVNode("view", utsMapOf("class" to "uni-btn-v"), utsArrayOf(
                    createElementVNode("button", utsMapOf("type" to "primary", "onClick" to _ctx.chooseVideo), "选取视频", 8, utsArrayOf(
                        "onClick"
                    ))
                )),
                createVNode(_component_enum_data, utsMapOf("title" to "视频来源", "items" to _ctx.sourceTypeItemTypes, "onChange" to _ctx.onSourceTypeChange), null, 8, utsArrayOf(
                    "items",
                    "onChange"
                )),
                createVNode(_component_enum_data, utsMapOf("title" to "摄像头", "items" to _ctx.cameraItemTypes, "onChange" to _ctx.onCameraChange), null, 8, utsArrayOf(
                    "items",
                    "onChange"
                ))
            )),
            createVNode(_component_input_data, utsMapOf("title" to "最长拍摄时间，单位秒", "defaultValue" to "60", "type" to "number", "onConfirm" to _ctx.onMaxDurationConfirm), null, 8, utsArrayOf(
                "onConfirm"
            )),
            createElementVNode("view", utsMapOf("class" to "uni-padding-wrap"), utsArrayOf(
                createVNode(_component_boolean_data, utsMapOf("title" to "是否压缩", "defaultValue" to true, "onChange" to _ctx.onCompressedChange), null, 8, utsArrayOf(
                    "onChange"
                ))
            ))
        ), 4);
    }
    open var title: String by `$data`;
    open var src: String by `$data`;
    open var sourceTypeItemTypes: UTSArray<ItemType1> by `$data`;
    open var sourceTypeItems: UTSArray<UTSArray<String>> by `$data`;
    open var cameraItemTypes: UTSArray<ItemType1> by `$data`;
    open var cameraItems: UTSArray<String> by `$data`;
    open var sourceType: UTSArray<String> by `$data`;
    open var compressed: Boolean by `$data`;
    open var maxDuration: Number by `$data`;
    open var camera: String by `$data`;
    open var videoInfo: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("title" to "chooseVideo", "src" to "", "sourceTypeItemTypes" to utsArrayOf<ItemType1>(ItemType1(value = 0, name = "从相册中选择视频"), ItemType1(value = 1, name = "拍摄视频"), ItemType1(value = 2, name = "从相册中选择视频或拍摄视频")), "sourceTypeItems" to utsArrayOf(
            utsArrayOf(
                "album"
            ),
            utsArrayOf(
                "camera"
            ),
            utsArrayOf(
                "album",
                "camera"
            )
        ), "cameraItemTypes" to utsArrayOf<ItemType1>(ItemType1(value = 0, name = "后置摄像头"), ItemType1(value = 1, name = "前置摄像头")), "cameraItems" to utsArrayOf(
            "back",
            "front"
        ), "sourceType" to utsArrayOf(
            "album",
            "camera"
        ), "compressed" to true, "maxDuration" to 60, "camera" to "back", "videoInfo" to "");
    }
    override fun `$initMethods`() {
        this.chooseVideo = fun() {
            uni_chooseVideo(ChooseVideoOptions(sourceType = this.sourceType, compressed = this.compressed, maxDuration = this.maxDuration, camera = this.camera, success = fun(res){
                console.log("chooseVideo success", JSON.stringify(res), " at pages/API/choose-video/choose-video.uvue:57");
                this.src = res.tempFilePath;
                this.videoInfo = "\u89C6\u9891\u957F\u5EA6: " + res.duration + "s\n\u89C6\u9891\u5927\u5C0F: " + Math.ceil(res.size / 1024) + "KB\n\u89C6\u9891\u5BBD\u5EA6: " + res.width + "\n\u89C6\u9891\u9AD8\u5EA6: " + res.height + "\n";
            }
            , fail = fun(err){
                uni_showModal(ShowModalOptions(title = "选择视频失败", content = JSON.stringify(err), showCancel = false));
            }
            ));
        }
        ;
        this.onSourceTypeChange = fun(value: Number) {
            this.sourceType = this.sourceTypeItems[value];
        }
        ;
        this.onCompressedChange = fun(value: Boolean) {
            this.compressed = value;
        }
        ;
        this.onMaxDurationConfirm = fun(value: Number) {
            this.maxDuration = value;
        }
        ;
        this.onCameraChange = fun(value: Number) {
            this.camera = this.cameraItems[value];
        }
        ;
    }
    open lateinit var chooseVideo: () -> Unit;
    open lateinit var onSourceTypeChange: (value: Number) -> Unit;
    open lateinit var onCompressedChange: (value: Boolean) -> Unit;
    open lateinit var onMaxDurationConfirm: (value: Number) -> Unit;
    open lateinit var onCameraChange: (value: Number) -> Unit;
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
                return utsMapOf("video" to padStyleMapOf(utsMapOf("alignSelf" to "center", "width" to 300, "height" to 225)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
