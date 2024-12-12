import App from './App'

// #ifndef VUE3
import Vue from 'vue'
import './uni.promisify.adaptor'

Vue.config.productionTip = false
App.mpType = 'app'
const app = new Vue({
	...App
})
app.$mount()
// #endif

// #ifdef VUE3
import {
	createSSRApp
} from 'vue'
import api from "@/network/api.js"
import base from '@/network/baseUrl.js'
import rule from '@/network/request.js'
export function createApp() {
	const app = createSSRApp(App)
	app.config.globalProperties.$rqt = api;
	app.config.globalProperties.$base = base;
	app.config.globalProperties.$rule = rule;
	return {
		app
	}
}
// #endif