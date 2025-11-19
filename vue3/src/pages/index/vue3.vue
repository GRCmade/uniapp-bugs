<template>
  <scroll-view class="scroll-view" scroll-y refresher-enabled="true" :refresher-triggered="triggered" :refresher-threshold="100" refresher-background="lightgreen" @refresherpulling="onPulling" @refresherrefresh="onRefresh" @refresherrestore="onRestore" @refresherabort="onAbort" @scroll="onScroll">
    <view class="content">
      <view :class="isSticky ? 'sticky flash-header' : 'flash-header'"></view>

      <view>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor numquam deleniti quos impedit. Quia, blanditiis? Tempora quam exercitationem deleniti autem suscipit odio veniam ducimus obcaecati possimus laborum! Dolor, similique facere! Lorem ipsum, dolor sit amet consectetur adipisicing elit. Mollitia omnis dolorum deleniti molestiae quibusdam sint possimus! Quia omnis repellendus voluptate veritatis. Repellat quia laudantium asperiores illum optio ipsum? Dolore, voluptas!</view>
      <view>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor numquam deleniti quos impedit. Quia, blanditiis? Tempora quam exercitationem deleniti autem suscipit odio veniam ducimus obcaecati possimus laborum! Dolor, similique facere! Lorem ipsum, dolor sit amet consectetur adipisicing elit. Mollitia omnis dolorum deleniti molestiae quibusdam sint possimus! Quia omnis repellendus voluptate veritatis. Repellat quia laudantium asperiores illum optio ipsum? Dolore, voluptas!</view>

      <view>
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorum quaerat, quos sapiente placeat molestias at aliquam minima consectetur necessitatibus nostrum deleniti recusandae sed, dolores sequi et ex earum illum? Numquam! Lorem ipsum dolor sit amet consectetur adipisicing elit. Id explicabo, dolores eaque ab dolorum cum ratione expedita dignissimos, fugit quidem quisquam? Fugiat suscipit sapiente eveniet architecto! Tempora fugit facilis quaerat? Lorem, ipsum dolor sit amet
        consectetur adipisicing elit. Neque culpa architecto obcaecati, aspernatur eligendi asperiores modi suscipit aliquid eius itaque pariatur fugiat similique atque doloribus repellat eum reprehenderit optio necessitatibus.
      </view>
    </view>
  </scroll-view>
</template>
<script>
const tag = '【scroll-view-page】'
let _pullling = false
export default {
  data() {
    return {
      triggered: true,
      isSticky: false
    }
  },
  onLoad() {},
  methods: {
    onScroll(e) {
      //
      console.log(tag + '滚动...', e.detail.scrollTop)
      // if(this._freshing == true||_pullling){
      // 	this.isSticky = false;
      // 	return
      // }
      // var that = this;
      // if (e.detail.scrollTop > 50) {
      // 	this.isSticky = true;
      // } else {
      // 	this.isSticky = false;
      // }
    },
    onPulling(e) {
      console.log(tag + '下拉刷新...', JSON.stringify(e.detail))
      // console.log("onpulling", e);
      // this.isSticky = false;
      // _pullling=true
    },
    onRefresh() {
      console.log(tag + 'onRefresh...')
      // if (this._freshing) return;
      // this._freshing = true;
      // setTimeout(() => {
      // 	this.triggered = false;
      // 	this._freshing = false;
      // 	_pullling=false
      // }, 500)
    },
    onRestore() {
			console.log(tag + 'onRestore...')
      // this.triggered = 'restore';
    },
    onAbort() {}
  }
}
</script>

<style>
.scroll-view {
  height: calc(100% - 88upx);
  border: 2upx solid red;
  box-sizing: border-box;
}

.content {
  height: 2000px;
  padding: 30upx;
}

.content view {
  margin-bottom: 40upx;
}

.flash-header {
  background-color: burlywood;
  width: 100%;
  height: 80px;
}

.flash-header.sticky {
  position: fixed;
}
</style>
