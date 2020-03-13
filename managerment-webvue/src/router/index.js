import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/login.vue"
import Home from "../views/home.vue"
import Index from "../views/index.vue"
import Editer from '../views/editer.vue'
import UserInfo from '../views/userinfo.vue'


Vue.use(VueRouter);

const router = new VueRouter({
	routes:[
		{
		    path: '/',
		    redirect: '/home'
		},
		{
			path:'/login',
			component:Login,
			meta: { title: '登陆' }
		},
		{
			path:'/home',
			component:Home,
			children:[
				{
					path:'/index',
					component:Index,
					meta: { title: '系统首页' }
				},
				{
					path:'/editer',
					component:Editer,
					meta: { title: '富文本' }
				},
				{
					path:'/userinfo',
					component:UserInfo,
					meta: { title: '我的信息' }
				}
			]
		}
	]
})
export default router;
