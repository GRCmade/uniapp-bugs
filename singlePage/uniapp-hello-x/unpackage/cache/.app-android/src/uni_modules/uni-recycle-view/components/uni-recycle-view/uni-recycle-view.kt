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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery;
open class GenUniModulesUniRecycleViewComponentsUniRecycleViewUniRecycleView : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        provide("setCachedSize", fun(item: Any, size: Number){
            if (!this.hasDefaultSize) {
                this.defaultItemSize = size;
                this.hasDefaultSize = true;
            }
            this.cachedSize.set(item, size);
        }
        );
        onCreated(fun() {
            this.placeholderHeight = this.list.length * this.defaultItemSize;
        }
        , __ins);
        onMounted(fun() {
            nextTick(fun(){
                uni_createSelectorQuery().`in`(this).select(".uni-recycle-view-main").boundingClientRect().exec(fun(ret){
                    this.scrollElementHeight = (ret[0] as NodeInfo).height!!;
                    this.rearrange(0);
                    this.initialized = true;
                }
                );
            }
            );
        }
        , __ins);
        this.`$watch`(fun(): Any? {
            return this.list;
        }
        , fun(list: UTSArray<Any>) {
            this.cachedSize.forEach(fun(_: Number, key: Any){
                if (!list.includes(key)) {
                    this.cachedSize.`delete`(key);
                }
            }
            );
        }
        , WatchOptions(deep = true));
        this.`$watch`(fun(): Any? {
            return this.defaultItemSize;
        }
        , fun() {
            this.rearrange(this.lastScrollTop);
        }
        );
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("scroll-view", mergeProps(utsMapOf("class" to "uni-recycle-view-main"), _ctx.`$attrs`, utsMapOf("ref" to "scroll", "onScroll" to _ctx.onScroll)), utsArrayOf(
            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to (_ctx.placeholderHeight + "px")))), utsArrayOf(
                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("top" to (_ctx.containerTop + "px")))), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "default", utsMapOf("items" to _ctx.items))
                ), 4)
            ), 4)
        ), 16, utsArrayOf(
            "onScroll"
        ));
    }
    open var list: UTSArray<Any> by `$props`;
    open var items: UTSArray<Any> by `$data`;
    open var containerTop: Number by `$data`;
    open var scrollElementHeight: Number by `$data`;
    open var placeholderHeight: Number by `$data`;
    open var offsetThreshold: UTSArray<Number> by `$data`;
    open var cachedSize: Map<Any, Number> by `$data`;
    open var initialized: Boolean by `$data`;
    open var hasDefaultSize: Boolean by `$data`;
    open var defaultItemSize: Number by `$data`;
    open var lastScrollTop: Number by `$data`;
    open var rearrangeQueue: UTSArray<Number> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("items" to utsArrayOf<Any>(), "containerTop" to 0, "scrollElementHeight" to 0, "placeholderHeight" to 0, "offsetThreshold" to utsArrayOf(
            0,
            0,
            0,
            0
        ), "cachedSize" to Map<Any, Number>(), "initialized" to false, "hasDefaultSize" to false, "defaultItemSize" to 40, "lastScrollTop" to 0, "rearrangeQueue" to utsArrayOf<Number>());
    }
    override fun `$initMethods`() {
        this.onScroll = fun(e: UniScrollEvent) {
            if (!this.initialized) {
                return;
            }
            val scrollTop = e.detail.scrollTop;
            if (scrollTop === this.lastScrollTop || scrollTop < 0) {
                return;
            }
            this.lastScrollTop = scrollTop;
            if (scrollTop < this.offsetThreshold[1] || scrollTop > this.offsetThreshold[2]) {
                this.queue(scrollTop);
            }
        }
        ;
        this.queue = fun(scrollTop: Number) {
            this.rearrangeQueue.push(scrollTop);
            setTimeout(fun(){
                this.flush();
            }
            , 1);
        }
        ;
        this.flush = fun() {
            val queueLength = this.rearrangeQueue.length;
            if (queueLength == 0) {
                return;
            }
            val lastScrollTop = this.rearrangeQueue[queueLength - 1];
            this.rearrange(lastScrollTop);
            this.rearrangeQueue = utsArrayOf<Number>();
        }
        ;
        this.rearrange = fun(scrollTop: Number) {
            this.offsetThreshold[0] = Math.max(scrollTop - this.scrollElementHeight * 5, 0);
            this.offsetThreshold[1] = Math.max(scrollTop - this.scrollElementHeight * 3, 0);
            this.offsetThreshold[2] = Math.min(scrollTop + this.scrollElementHeight * 4, this.placeholderHeight);
            this.offsetThreshold[3] = Math.min(scrollTop + this.scrollElementHeight * 6, this.placeholderHeight);
            val offsetStart = this.offsetThreshold[0];
            val offsetEnd = this.offsetThreshold[3];
            val items = utsArrayOf<Any>();
            val defaultItemSize = this.defaultItemSize;
            val cachedSize = this.cachedSize;
            val list = this.list;
            var tempTotalHeight: Number = 0;
            var containerTop: Number = 0;
            var start = false;
            var end = false;
            run {
                var i: Number = 0;
                while(i < list.length){
                    val item = list[i];
                    var itemSize = defaultItemSize;
                    val cachedItemSize = cachedSize.get(item);
                    if (cachedItemSize != null) {
                        itemSize = cachedItemSize;
                    }
                    tempTotalHeight += itemSize;
                    if (end) {
                        i++;
                        continue;
                    }
                    if (tempTotalHeight < offsetStart) {
                        containerTop = tempTotalHeight;
                    } else if (tempTotalHeight >= offsetStart && tempTotalHeight <= offsetEnd) {
                        if (start == false) {
                            start = true;
                        }
                        items.push(item);
                    } else {
                        if (!end) {
                            end = true;
                        }
                    }
                    i++;
                }
            }
            this.placeholderHeight = tempTotalHeight;
            this.items = items;
            this.containerTop = containerTop;
        }
        ;
    }
    open lateinit var onScroll: (e: UniScrollEvent) -> Unit;
    open lateinit var queue: (scrollTop: Number) -> Unit;
    open lateinit var flush: () -> Unit;
    open lateinit var rearrange: (scrollTop: Number) -> Unit;
    companion object {
        var name = "uni-recycle-view";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf());
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("list" to utsMapOf("type" to "Array", "default" to utsArrayOf<Any>())));
        var propsNeedCastKeys = utsArrayOf(
            "list"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
