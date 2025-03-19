<template>
	<div>
		<h1>setTimeout 测试示例</h1>
		<div>
			<h2>测试结果：</h2>
			<ul>
				<li v-for="(result, index) in testResults" :key="index">{{ result }}</li>
			</ul>
		</div>
		<div>
			<h2>测试方法：</h2>
			<button @click="testFunctionName">函数名</button>
			<button @click="testAnonymousFunction">匿名函数</button>
			<button @click="testArrowFunction">箭头函数</button>
			<button @click="testStringCode">字符串代码</button>
			<button @click="testObjectMethod">对象方法</button>
			<button @click="testExtraArguments">额外参数</button>
			<button @click="testBindArguments">bind 参数</button>
			<button @click="testIIFE">IIFE</button>
			<button @click="testDynamicDelay">动态延迟</button>
			<button @click="testAsyncFunction">异步函数</button>
			<button @click="testNotFunc">参数是num</button>
			<button @click="testThisFunc">参数是this.func</button>
			<button @click="testundefined">参数是 undefined</button>
			<button @click="testnull">参数是 null</button>
			<button @click="testfuncError">函数中抛出错误</button>
		</div>

	</div>
</template>

<script>
	export default {
		data() {
			return {
				testResults: [], // 存储测试结果
			};
		},
		methods: {
			testfuncError(){
				setTimeout(() => {
					console.error("函数中抛出错误")
					throw new Error('函数中抛出错误');
				},100)
			},
			testnull() {
				setTimeout(null, 100);
			},
			testundefined() {
				setTimeout(undefined, 100);
			},
			func() {
				this.testResults.push('func执行');
			},
			testThisFunc() {
				setTimeout(this.func, 1000);
			},
			testNotFunc() {
				const res = 100
				setTimeout(100, 100);
				console.log("testNotFunc")
			},
			// 1. 函数名
			testFunctionName() {
				setTimeout(this.sayHello, 100);
			},

			// 2. 匿名函数
			testAnonymousFunction() {
				setTimeout(function() {
					this.testResults.push('匿名函数执行');
				}.bind(this), 200);
			},

			// 3. 箭头函数
			testArrowFunction() {
				setTimeout(() => {
					this.testResults.push('箭头函数执行');
				}, 300);
			},

			// 4. 字符串代码（不推荐）
			testStringCode() {
				setTimeout("console.log('字符串代码执行')", 400);
			},

			// 5. 对象方法
			testObjectMethod() {
			  const that = this; // 保存 Vue 组件的 this
			  const obj = {
			    name: 'Obj',
			    log() {
			      that.testResults.push(`对象方法执行: ${this.name}`); // 使用外部 that
			    },
			  };
			  setTimeout(obj.log.bind(obj), 500); // 绑定 obj 的 this
			},

			// 6. 额外参数
			testExtraArguments() {
				setTimeout(
					(a, b) => {
						this.testResults.push(`额外参数执行: ${a}, ${b}`);
					},
					600,
					'Alice',
					'Bob'
				);
			},

			// 7. 使用 bind 绑定参数
			testBindArguments() {
				function sum(a, b) {
					this.testResults.push(`bind 参数执行: ${a + b}`);
				}
				setTimeout(sum.bind(this, 1, 2), 700);
			},

			// 8. IIFE（立即执行函数）
			testIIFE() {
				for (let i = 0; i < 3; i++) {
					((i) => {
						setTimeout(() => {
							this.testResults.push(`IIFE 执行: ${i}`);
						}, 800 + i * 100);
					})(i);
				}
			},

			// 9. 动态计算延迟时间
			testDynamicDelay() {
				const delay = 1000; // 1 秒
				setTimeout(() => {
					this.testResults.push(`动态延迟执行: ${delay}ms`);
				}, delay);
			},

			// 10. 异步函数
			testAsyncFunction() {
				setTimeout(async () => {
					await this.mockFetchData();
					this.testResults.push('异步函数执行');
				}, 1200);
			},

			// 辅助方法：模拟异步操作
			mockFetchData() {
				return new Promise((resolve) => {
					setTimeout(() => {
						resolve('数据加载完成');
					}, 300);
				});
			},

			// 辅助方法：输出 Hello
			sayHello() {
				this.testResults.push('函数名执行: Hello');
			},
		},
	};
</script>

<style>
	/* 简单样式 */
</style>