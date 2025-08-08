import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

let user = {};

try {
    // 尝试获取本地是否存在user变量，第一次启动APP时是不存在的
    user = uni.getStorageSync('user');
} catch (e) {

}

const store = new Vuex.Store({
    state: {
        
    },
	actions:{
		checkUpdate({state},showHint){
			
		}
	},
    mutations: {
        $uStore(state, payload) {
            
        },
        setOtherPoulationInfoBO(state, { data, index }) {
            
        }
    }
})

export default store