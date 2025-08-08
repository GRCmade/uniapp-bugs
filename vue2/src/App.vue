<script>
	export default {
		onLaunch: function() {
			// console.log('App Launch')
		},
		onShow: function() {
			// console.log('App Show')
		},
		onHide: function() {
			// console.log('App Hide')
		},
		methods: {
			
		}
	}
</script>

<style lang="scss">
	@import "@/uni_modules/uview-ui/index.scss";
	/*每个页面公共css */
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }
	image {
		image-rendering:-moz-crisp-edges;
		image-rendering:-o-crisp-edges;
		image-rendering:-webkit-optimize-contrast;
		image-rendering: crisp-edges;
		-ms-interpolation-mode:nearest-neighbor;
	}
	::-webkit-scrollbar {  
		display: none !important;  
		width: 0 !important;  
		height: 0 !important;  
		-webkit-appearance: none;  
		background: transparent;  
	}
</style>
