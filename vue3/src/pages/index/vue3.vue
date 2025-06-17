<template>
  <view>
    <button @click="click">button</button>
    <rich-text :nodes="richTextContent" @itemclick="itemClick"></rich-text>
  </view>
</template>

<script lang="ts" setup>
const richTextContent = [
  {
    name: 'p',
    children: [
      {
        type: 'text',
        text: '这是一个段落。'
      },
      {
        name: 'a',
        attrs: {
          href: 'https://www.baidu.com/'
        },
        children: [
          {
            name: 'img',
            attrs: {
              src: 'https://p0.ssl.qhimgs1.com/sdr/400__/t01a06471535d2a6fca.jpg'
            }
          }
        ]
      }
    ]
  }
]
const click = () => {
  console.log(richTextContent)
}
const itemClick = (e: any) => {
  console.log(e)
}
</script>

<style></style>
