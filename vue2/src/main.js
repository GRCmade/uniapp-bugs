import App from './App'

import Vue from 'vue'

Vue.config.productionTip = false

App.mpType = 'app'

// 引入全局uView
import uView from '@/uni_modules/uview-ui'
Vue.use(uView);

import $utils from 'utils/common.js'
Vue.prototype.$utils = $utils

// 引入store
import store from '@/store';

// 引入uView提供的对vuex的简写法文件
let vuexStore = require('@/store/$u.mixin.js');
Vue.mixin(vuexStore);

const app = new Vue({
	store,
    ...App
})

// 引入请求封装，将app参数传递到配置中
require('@/config/request.js')(app)


// http接口API集中管理引入部分
import httpApi from '@/config/http.api.js'
Vue.use(httpApi, app)

// 公共方法挂载
import { isLogin } from '@/utils/publicMethod'
Vue.prototype.$isLogin = isLogin;

import './style/public.scss'

// 公共组件
import NavbarComponent from '@/common/navbar2.vue'
import TabBar  from '@/common/tab_bar.vue'
Vue.component('NavbarComponent', NavbarComponent)
Vue.component('TabBar', TabBar)

app.$mount()

