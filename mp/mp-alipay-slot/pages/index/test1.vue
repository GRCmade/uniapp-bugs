<template>
    <div>
        我是子组件1
        <slot name="default" :listData="listData"></slot>
        <div>
            其他插槽:
            <slot name="other">
                <div style="color: red">后备内容</div>
            </slot>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            listData: []
        };
    }
};
</script>
<style lang="scss" scoped></style>
