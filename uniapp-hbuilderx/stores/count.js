import {
	defineStore
} from 'pinia';

export const useCountStore = defineStore('count', {
	state: () => ({
		count: 11,
	}),
	actions: {
		increment() {
			this.count++;
		},
	},
});