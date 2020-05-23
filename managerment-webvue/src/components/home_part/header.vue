<template>
	<div style="height: 100%;background-color: #2c3348;">
		<el-col :span="24" style="margin-top: 13px;">
			<el-col :span="1">
				<div @click="changeMenu" style="color: white;">
					<i v-if="!isMenuClose" class="el-icon-s-fold" style="font-size: 30px;line-height: 45px;position: absolute;left: 20px;"></i>
					<i v-else class="el-icon-s-unfold" style="font-size: 30px;line-height: 45px;position: absolute;left: 20px;"></i>
				</div>
			</el-col>
			<el-col :span="8" :offset="1">
				<img src="../../assets/image/school.png" />
			</el-col>
			<el-col :span="1" :offset="11">
				<div class="btn-bell">
				    <el-tooltip
				        effect="dark"
				        :content="message?`有${message}条未读消息`:`消息中心`"
				        placement="bottom"
				    >
				        <div>
				            <i class="el-icon-chat-line-round" @click="openChat" style="color: white;"></i>
				        </div>
				    </el-tooltip>
				    <span class="btn-bell-badge" v-if="message"></span>
				</div>
			</el-col>
			<el-col :span="1" >
				<div>
					<router-link to="/userinfo">
						<el-avatar  :src="userImage"></el-avatar>
					</router-link>
				</div>
			</el-col>
			<el-col :span="1" style="margin-top: 8px;">
			  <div>
				  <el-dropdown @command="handleCommand">	
					<span class="el-dropdown-link">
					  {{user.name}}<i class="el-icon-arrow-down el-icon--right"></i>
					</span>
					<el-dropdown-menu slot="dropdown">
						<el-dropdown-item icon="el-icon-s-home" command="a">主页</el-dropdown-item>
						<el-dropdown-item icon="el-icon-chat-dot-round" command="b">寝室信息</el-dropdown-item>
						<el-dropdown-item icon="el-icon-close" command="=z">退出</el-dropdown-item>
					</el-dropdown-menu>
				  </el-dropdown>
			  </div>
			</el-col>
		</el-col>	
	</div>
</template>

<script>
	import bus from './bus.js'
	export default {
	    data() {
	        return {
				isMenuClose:false,
				message:2,
				user:JSON.parse(localStorage.getItem('user')),
				userInfo:JSON.parse(localStorage.getItem('userInfo')),
				userImage:this.$globalMsg.sverHost+JSON.parse(localStorage.getItem('userInfo')).image
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
				this.isMenuClose = !this.isMenuClose;
				bus.$emit('changeMenu',this.isMenuClose);
			},
			openChat(){
				this.$emit("openChat",null);
			},
			handleCommand(command) {
				switch(command){
					case 'a':
						this.$router.push('index');
						break;
					case 'b':
						this.$router.push('dorminfo');
						break;
					case 'z':{
						this.$axios.post('logout',null);
						window.localStorage.removeItem('user');
						this.$router.push('login');
						break;
					}
						
				}
			},
		},
	};
</script>

<style>
	.btn-bell{
		position: relative;
		top: 7px;
		width: 40px;
		height: 40px;
		text-align: center;
		border-radius: 15px;
		cursor: pointer;
		font-size: 25px;
	}
	.btn-bell-badge {
	    position: absolute;
	    right: 0;
	    top: 2px;
	    width: 8px;
	    height: 8px;
	    border-radius: 4px;
	    background: #f56c6c;
	    color: #fff;
	}
</style>
