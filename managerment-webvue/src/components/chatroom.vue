<template>
	<div style="height: 88vh;position:relative;">
		<div style="width: 100%;" class="infinite-list-wrapper">
			<ul style="height:75vh;overflow-y:scroll;white-space: nowrap;padding: 0;">
				<li class="sessionlist" v-for="item in messages" :key="item.index">
					<div style="width: 100%;" v-if="item.name==user.name">
						<div class="mylist-left" >
							<el-avatar :size="30" style="font-size: 5px;"> {{item.name}} </el-avatar>
						</div>
						<div class="mylist-right">
							<p class="mylastmsg" v-scroll>{{item.message}}</p>
						</div>
					</div>
					<div style="width: 100%;" v-else>
						<div class="list-left">
							<el-avatar :size="30" style="font-size: 5px;"> {{item.name}} </el-avatar>
						</div>
						<div class="list-right">
							<p class="lastmsg" v-scroll>{{item.message}}</p>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div >
			<el-row :gutter="15">
				<el-col :span="18" :offset="1">
					<el-input
						type="textarea"
					    v-model="newMsg">
					</el-input>
				</el-col>
				<el-col :span="4">
					<el-button
						@click="sendMsg"
						type="primary"
						circle
						icon="el-icon-s-promotion">
					</el-button>
				</el-col>
			</el-row>
		</div>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				user:JSON.parse(localStorage.getItem('user')),
				messages:[],
				chatText:null,
				websocket: null,
				newMsg:null
			}
		},
		mounted () {
		    if ('WebSocket' in window) {
		        this.websocket = new WebSocket('ws://localhost:8890/chat-room/' + this.user.name)
		        this.initWebSocket()
		    } else {
		        alert('当前浏览器 Not support websocket')
		    }
		},
		beforeDestroy () {
		    this.onbeforeunload()
		},
		methods:{
			sendMsg(){
				this.websocket.send(this.newMsg)
				this.newMsg=null
			},
			initWebSocket () {
			    this.websocket.onerror = this.setErrorMessage
			    this.websocket.onopen = this.setOnopenMessage
			    this.websocket.onmessage = this.setOnmessageMessage
			    this.websocket.onclose = this.setOncloseMessage
			    window.onbeforeunload = this.onbeforeunload
			},
			setErrorMessage () {
			    console.log('WebSocket连接发生错误   状态码：' + this.websocket.readyState)
			},
			setOnopenMessage () {
			    console.log('WebSocket连接成功    状态码：' + this.websocket.readyState)
			},
			setOnmessageMessage (event) {
				var chatText1 = JSON.parse(event.data)
				this.messages.push(chatText1)
			    console.log(this.messages)
			},
			setOncloseMessage () {
			    console.log('WebSocket连接关闭    状态码：' + this.websocket.readyState)
			},
			onbeforeunload () {
			    this.closeWebSocket()
			},
			closeWebSocket () {
			    this.websocket.close()
			},
		},
		directives: {
		    scroll: {
		        inserted(el) {
		            el.scrollIntoView()
		        }
		    }
		}
	}
</script>

<style>
	::-webkit-scrollbar {
	     width: 0 !important;
	   }
	   ::-webkit-scrollbar {
	     width: 0 !important;height: 0;
	   }
	.msglist{
	  height: 540px;
	  overflow-y: auto;
	}
	.name{
		margin-top: 0px;
		margin-left: 5px;
		margin-bottom: 2px;
		font-size: 10px;
	}
	.list-right{
		border-radius: 8px;
		max-width: 350px;
		min-height: 25px;
		background-color: #E9EEF3;
		display:inline-block;
		float: left;
	}
	.list-left{
		display:inline-block;
		margin-top: 4px;
		float: left;
	}
	.mylist-right{
		border-radius: 8px;
		max-width: 350px;
		min-height: 25px;
		background-color: cornsilk;
		display:inline-block;
		float: right;
	}
	.mylist-left{
		display:inline-block;
		margin-top: 4px;
		float: right;
	}
	.mylastmsg{
		margin-right: 10px;
		margin-left: 10px;
		margin-top: 8px;
		margin-bottom: 10px;
		font-size: 15px;
		line-height: 20px;
		color: #999;
		bottom: 4px;
		white-space: pre-line;
		word-break:normal;
		white-space:pre-warp; 
		word-wrap:break-word;
	}
	.lastmsg{
		margin-right: 10px;
		margin-left: 10px;
		margin-top: 8px;
		margin-bottom: 10px;
		font-size: 15px;
		line-height: 20px;
		color: #999;
		bottom: 4px;
		white-space: pre-line;
		word-break:normal;
		white-space:pre-warp; 
		word-wrap:break-word;
	}
	.sessionlist{
		list-style-type:none;
		margin-top:5px;
	    display: flex;
	    padding: 1px;
	    font-size: 0;
	}
</style>
