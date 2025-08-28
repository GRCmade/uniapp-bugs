// 页面路径：main.js
import App from './App'
import store from './store'
import {createSSRApp} from 'vue'
// import Vuex from "vuex";
export function createApp() {
	const app = createSSRApp(App)
	app.use(store)
	return {
		app,
		// Vuex // 注意，如果 nvue 使用 vuex 的各种map工具方法时，必须 return Vuex
	}
}
