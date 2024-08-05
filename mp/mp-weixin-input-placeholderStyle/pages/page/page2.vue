<template></template>
<script></script>
<!-- <template> 
 <view class="">
 	<view class="backgroundArea">
 	    <view v-for="(pattern, index) in patternsList"   
 	    class="backgroundPattern"  
 	    :style="getStyle(index)">  
 	    </view>  
 	</view>  
 </view>
  
</template>  

<script>  
    class Pattern {  
        constructor(num) {  
            this.num = num,  
            this.width = '',  
            this.opacity = '',  
            this.left = '',  
            this.bottom = '',  
            this.top = '',  
            this.moveTime = '',  
            this.delay = '',  
            this.windowHeight = '',  
            this.timer = null,  
            this.animation = {}  
        }  

        reRandom() {  
            uni.getSystemInfo({  
                success: (res) => {  
                    this.windowHeight = res.windowHeight  
                    var maxWidth = 0.25 * res.windowWidth  
                    var minWidth = 0.1 * res.windowWidth  
                    this.width = Math.random() * (maxWidth - minWidth) + minWidth  
                    var speed = ((this.windowHeight + 2 * 1.3 * this.width) / 5000) * this.width * 0.005  
                    this.moveTime = (this.windowHeight + 2 * 1.3 * this.width) / speed  
                    var maxLeft = res.windowWidth + 2 * this.width  
                    this.opacity = Math.sin(0.01 * this.width)  
                    this.left = Math.random() * maxLeft - this.width  
                    this.bottom = -1.3 * this.width  
                    this.top = res.windowHeight + 2 * this.width * 1.3  
                    this.delay = 100000 * 1 / this.width  
                }  
            })  
        }  
    }  

    export default {  
        name: 'activeBackground',  
        data() {  
            return {  
                patternsList: []  
            }  
        },  
        created() {  
			console.log("created")
            for (let i = 0; i < 20; i++) {  
                var pattern = new Pattern(i)  
                pattern.reRandom()  
                this.patternsList.push(pattern)  
            }  
        },  
        methods: {  
            getStyle(index) {  
                return {  
                    width: this.patternsList[index].width + 'px',  
                    height: 1.3 * this.patternsList[index].width + 'px',  
                    opacity: this.patternsList[index].opacity,  
                    left: this.patternsList[index].left + 'px',  
                    bottom: this.patternsList[index].bottom + 'px',  
                    animation: 'move ' + this.patternsList[index].moveTime + 'ms infinite linear',  
                }  
            }  
        }  
    }  
</script>  

<style>  
    .backgroundArea {  
        width: 100%;  
        height: 100%;  
    }  

    @keyframes move {  
        0% {  
            bottom: calc(25vw * -1.3 - 100px);  
        }  
        100% {  
            bottom: calc(100% + 25vw * 1.3);  
        }  
    }  

    .backgroundPattern {  
        position: absolute;  
        background-color: white;  
        border-radius: 20%;  
    }  
</style> -->