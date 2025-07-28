import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'

const app = createApp(App)
app.mixin({
  mounted() {
    console.log('全局mounted执行')
  }
})
app.mount('#app')
