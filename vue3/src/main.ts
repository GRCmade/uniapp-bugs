import { createSSRApp } from 'vue'
import App from './App.vue'
import './uni.promisify.adaptor'

export function createApp() {
  const app = createSSRApp(App)
  app.mixin({
    mounted() {
      console.log('全局mounted')
    }
  })
  return {
    app
  }
}
