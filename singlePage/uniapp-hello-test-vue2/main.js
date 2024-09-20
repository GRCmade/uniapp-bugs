import App from './App'
import store from './store'


import en from './locale/en.json'
import zhHans from './locale/zh-Hans.json'
import ar from './locale/ar.json'
const messages = {
	en,
	'zh-Hans': zhHans,
	'ar': ar
}

let i18nConfig = {
  locale: uni.getLocale(),// 获取已设置的语言
  messages
}

// #ifndef VUE3
import Vue from 'vue'
Vue.config.productionTip = false
Vue.prototype.$store = store
Vue.prototype.$adpid = "1111111111"
Vue.prototype.$backgroundAudioData = {
	playing: false,
	playTime: 0,
	formatedPlayTime: '00:00:00'
}
App.mpType = 'app'
const app = new Vue({
	store,
	...App
})
app.$mount()
// #endif

// #ifdef VUE3
import {
	createSSRApp
} from 'vue'
import CustomTabBar from './components/CustomTabBar/CustomTabBar.vue';  
import { createI18n } from 'vue-i18n'// v9.x
const i18n = createI18n(i18nConfig)
export function createApp() {
	const app = createSSRApp(App)
	app.use(i18n)
	app.use(store)
	app.component('CustomTabBar', CustomTabBar);  
	app.config.globalProperties.$adpid = "1111111111"
	app.config.globalProperties.$backgroundAudioData = {
		playing: false,
		playTime: 0,
		formatedPlayTime: '00:00:00'
	}
	return {
		app
	}
}
// #endif