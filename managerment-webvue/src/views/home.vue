<template>
	<div class="wrapper">
		<Header @openChat="openChat" ></Header>
		<Sidebar ></Sidebar>
		<div  class="content-box" :class="{'content-collapse':collapse}">
			<Tags></Tags>
			<div class="content">
				<el-scrollbar style="height: 100%;">
			    <transition name="move" mode="out-in">
			        <keep-alive :include="tagsList">
			            <router-view></router-view>
			        </keep-alive>
			    </transition>
				</el-scrollbar>
			</div>
			<el-drawer
				title="文明发言,别搞事情"
				:show-close="false"
				:visible.sync="drawer">
				<template>
					<ChatRoom></ChatRoom> 
				</template>
			</el-drawer>
		</div>
	</div>
	</div>

</template>

<script>
	import ChatRoom from '../components/chatroom.vue'
	import Header from '../components/home_part/header.vue'
	import Sidebar from '../components/home_part/sidebar.vue'
	import Tags from '../components/home_part/tags.vue'
	import bus from '../components/home_part/bus.js';
	export default {
		components:{
			ChatRoom,
			Header,
			Sidebar,
			Tags
		},
	    data() {
	        return {
				user:JSON.parse(localStorage.getItem('user')),
				userInfo:JSON.parse(localStorage.getItem('userInfo')),
				text:[],
				item:{item:null},
	            drawer: false,
	            direction: 'rtl',
				websocket: null,
				userImage:this.$globalMsg.sverHost+JSON.parse(localStorage.getItem('userInfo')).image,
				tagsList: [],
				collapse: false
			};
	    },
		computed: {
		    username() {
		        var username = JSON.parse(localStorage.getItem('user')).name;
				console.log(username);
		        return username ? username : this.name;
		    }
		},
		methods: {
			changeMenu(){
				
			},
			openChat(){
				this.drawer=true;
			},
			handleOpen(key, keyPath) {
			    console.log(key, keyPath);
			},
			handleClose(key, keyPath) {
				console.log(key, keyPath);
			}
		},
		created() {
			this.$router.push('index');
			bus.$on('collapse-content', msg => {
			    this.collapse = msg;
			});
			// 只有在标签页列表里的页面才使用keep-alive，即关闭标签之后就不保存到内存中了。
			bus.$on('tags', msg => {
			    let arr = [];
			    for (let i = 0, len = msg.length; i < len; i++) {
			        msg[i].name && arr.push(msg[i].name);
			    }
			    this.tagsList = arr;
			});
		}
	};
</script>

<style>
.el-scrollbar__wrap {
  overflow-x: hidden;
}
</style>
