import App from './App'

// #ifndef VUE3
import Vue from 'vue'
import './uni.promisify.adaptor'
Vue.config.productionTip = false
Vue.prototype.$tools = ()=>'tools'
App.mpType = 'app'
const app = new Vue({
  ...App
})
app.$mount()
// #endif

// #ifdef VUE3
import { createSSRApp } from 'vue'
import componentVue from './pages/components/component.vue'
export function createApp() {
  const app = createSSRApp(App)
  app.component('component',componentVue)
  return {
    app
  }
}
// #endif

// import "@/test.scss"