import Vue from 'vue'
import Vuex from 'vuex'

//挂载Vuex
Vue.use(Vuex)

//创建VueX对象
const store = new Vuex.Store({
    state:{
        //存放的键值对就是所要管理的状态
        name:'helloVueX',
		article:{
			alltext:'',		
			createdps: '',
			createdtime: '',
			frontcut: '',
			id: 15,
			texttype: 0,
			title: ''
		},
		viewDorm:{
			id:'',
			name:'',
			dormtoryId:'',
			members:0,
			rewardTimes:0,
			criticismTimes:0,
			score:0
		}
    },
	mutations:{
		edit(state,data){
			state.name = 'jack'+data;
		},
		changeNewsId(state,data){
			state.article=data;
		},
		changeViewDorm(state,data){
			state.viewDorm=data;
		}
	}
})

export default store