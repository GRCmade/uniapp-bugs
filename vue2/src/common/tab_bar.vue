<template>
    <view class="tab-bottom">
        <u-tabbar
            inactiveColor="#666666"
            activeColor="#337DFE"
            :fixed="false" 
            :border="false"
            :placeholder="true"
            :safeAreaInsetBottom="true">
            <u-tabbar-item 
                v-for="(item, index) in showList" 
                :key="index"
                :text="item.text"
                :icon="`${$http_url}${selectValue == item.pagePath ? item.selectedIconPath : item.iconPath}`" 
                @click="(value)=> goTabBar(value, item.pagePath)">
            </u-tabbar-item>
        </u-tabbar>
        <u-gap height="10" bg-color="#fff"></u-gap>
    </view>
</template>
<script>
export default {
    data() {
        return {
            selectValue: 0,
            showList: [],
            list1: [{
                "pagePath": "/pages/home/home",
                "iconPath": "rual-governance/static/tabbar/icon_tab_home.png",
                "selectedIconPath": "rual-governance/static/tabbar/icon_tab_home_active.png",
                "text": "首页"
            },
			// {
   //              "pagePath": "/pages_ai/index",
   //              "iconPath": "rual-governance/static/tabbar/icon_tab_more.png",
   //              "selectedIconPath": "rual-governance/static/tabbar/icon_tab_more_active.png",
   //              "text": "AI问答"
   //          },
			{
                "pagePath": "/pages/my/my",
                "iconPath": "rual-governance/static/tabbar/icon_tab_me.png",
                "selectedIconPath": "rual-governance/static/tabbar/icon_tab_me_active.png",
                "text": "我的"
            }],
            list2: [{
                "pagePath": "/pages/staff_home/staff_home",
                "iconPath": "rual-governance/static/tabbar/icon_tab_home.png",
                "selectedIconPath": "rual-governance/static/tabbar/icon_tab_home_active.png",
                "text": "工作台"
            },{
                "pagePath": "/pages/my/my",
                "iconPath": "rual-governance/static/tabbar/icon_tab_me.png",
                "selectedIconPath": "rual-governance/static/tabbar/icon_tab_me_active.png",
                "text": "我的"
            }]
        }
    },
    created() {
        const curPages =  getCurrentPages();
        switch(curPages[0].route) {
            case 'pages/home/home':
                this.selectValue = '/pages/home/home'
                break;
            case 'pages/more/more':
                this.selectValue = '/pages/more/more'
                break;
            case 'pages/my/my':
                this.selectValue = '/pages/my/my'
                break;
            case 'pages/staff_home/staff_home':
                this.selectValue = '/pages/staff_home/staff_home'
                break;
        }
        uni.getStorage({
            key: 'user',
            success:({data})=>{
                if(data.roleType == 1 || data.roleType == 2) {
                    this.showList = this.list2;
                } else {
                    this.showList = this.list1;
                }
            },
        })
    },
    methods: {
        goTabBar(index, path) {
			if(path === '/pages_ai/index') {
				uni.navigateTo({
					url: path
				})
			} else {
				uni.switchTab({ url: path })
			}
        }
    }
}
</script>
<style lang="scss">
.tab-bottom {
    position: fixed;
    bottom: 0;
    width: 100%;
}
</style>