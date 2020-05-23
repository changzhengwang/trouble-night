import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/login.vue"
import Home from "../views/home.vue"
import Index from "../views/index.vue"
import Editer from '../views/editer.vue'
import UserInfo from '../views/user_info.vue'
import DormInfo from '../views/dorm_info.vue'
import NewsInfo from '../views/news_info.vue'
import StudengManage from '../views/student_manage.vue'
import DormManage from '../views/dorm_manage.vue'

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
				},
				{
					path:'/dorminfo',
					component:DormInfo,
					meta: { title: '寝室信息' }
				},
				{
					path:'/newsinfo',
					component:NewsInfo,
					meta: { title: '新闻详情' }
				},
				{
					path:'/dormmanage',
					component:DormManage,
					meta: { title: '寝室管理' }
				},
				{
					path:'/studentmanage',
					component:StudengManage,
					meta: { title: '学生管理' }
				}
			]
		}
	]
})
export default router;
