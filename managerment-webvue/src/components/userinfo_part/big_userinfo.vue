<template>
	<div style="background-color: rgba(255,255,255);height: 230px;">
		<div class="userImgDiv" >
			<img :src="userImage" style="border-radius:50%;width: 90px;height:90px;"/>
		</div>
		<div style="float: left;position: relative;top: 5px;left: 40px;">
			<h2>{{user.name}}</h2>
			<h3>{{user.sid}}</h3>
		</div>
		<div style="width:95%;height:2px;margin:0px auto;padding:0px;overflow:hidden;background-color: #919191;position: relative;top: 20px;"></div>
		<div style="position: relative;top: 20px;margin-left: 10px;">
			<div class="common-padding" style="width: 100%;text-align: left;">
				<p class="no-margin" style="color: #99A9BF;">专业班级：{{proAndClass}}</p>
				<p class="no-margin" style="color: #99A9BF;">宿舍信息：{{dormitory}}</p>
			</div>
			<div style="width: 100%;">
				
			</div>
		</div>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				user:JSON.parse(localStorage.getItem('user')),
				userInfo:JSON.parse(localStorage.getItem('userInfo')),
				userImage:this.$globalMsg.sverHost+JSON.parse(localStorage.getItem('userInfo')).image,
				proAndClass:'物联网163',
				dormitory:'乾五-235'
			}
		}
	}
</script>

<style>
	.userImgDiv{
		border-radius:50%;
		background-color: #99A9BF;
		width: 90px;
		height:90px;
		position: relative;
		top: 10px;
		left: 10px;
		float: left;
	}
</style>
