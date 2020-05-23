<template>
	<div class="common-padding">
		<el-col :span="24">
			<el-col :span="8" v-for="(member,index) in members" :key="index" >
				<div  style="width: 100px; height: 100px;background-color: #aaaa7f;margin-bottom: 10px;">
					<p style="text-align: center;line-height: 100px;font-size: 20px;" @click="viewInfo(member.id)">{{member.name}}</p>
				</div>
				
			</el-col>
		</el-col>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				userImage:this.$globalMsg.sverHost+JSON.parse(localStorage.getItem('userInfo')).image,
				members:[
					
				]
			}
		},
		methods:{
			getUsersByDormId: async function(){
				const val = new Map;
				const result = await this.$axios.get('getUsersByDormId?&dormId='+this.$globalMsg.viewDormID,null);
				this.members = result.data;
			},
			viewInfo(val){
				this.$globalMsg.viewUserId=val;
				this.$router.push('userinfo')
			}
		},
		created(){
			this.getUsersByDormId();
		}
	}
</script>

<style>
</style>
