<template>
  <slot v-if="value === 0" />
  <slot v-if="value === 1" name="s1">111</slot>
  <slot v-if="value === 2" name="s2">222</slot>
  <slot v-if="value === 3" name="s3">333</slot>
</template>

<script lang="ts" setup>
interface IProps {
  value?: 0 | 1 | 2 | 3;
}

defineProps<IProps>();
</script>