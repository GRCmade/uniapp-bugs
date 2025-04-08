<template>
  <com v-if="false" />
  <com-slot :value="1">
    <com />
  </com-slot>
  <com-slot :value="2">
    <com />
  </com-slot>
  <com-slot :value="3">
    <com />
  </com-slot>
</template>

<script lang="ts" setup>

</script>