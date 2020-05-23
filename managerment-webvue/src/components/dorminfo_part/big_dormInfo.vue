<template>
	<div style="background-color: rgba(255,255,255);height: 240px;">
		<div style="float: left;position: relative;top: 25px;left: 40px;bottom: 20px;height: 90px;">
			<h1>{{ dormInfo.dormitoryId }}-{{dormInfo.name}}寝室</h1>
		</div>
		<div style="width:95%;height:2px;margin:0px auto;padding:0px;overflow:hidden;background-color: #919191;position: relative;top: 20px;"></div>
		<div style="position: relative;top: 20px;margin-left: 10px;">
			<div class="common-padding" style="width: 100%;text-align: left;">
				<p class="no-margin" style="color: #99A9BF;">寝室人数：{{dormInfo.member}}</p>
				<p class="no-margin" style="color: #99A9BF;">寝室长&emsp;：王长征</p>
				<p class="no-margin" style="color: #99A9BF;">宿舍楼&emsp;：{{ dormInfo.dormitoryId }}元</p>
				<p class="no-margin" style="color: #99A9BF;">剩余电费：112</p>
			</div>
			<div style="width: 100%;">
				
			</div>
		</div>
	</div>
</template>

<script>
	export default{
		props:{
			dormId:String
		},
		data(){
			return{
				proAndClass:'物联网163',
				dormitory:'乾五',
				dorm:'235',
				dormInfo:''
			}
		},
		methods:{
			getDormById: async function(){
				const val = new Map;
				const result = await this.$axios.get('getDormById?&id='+this.$globalMsg.viewDormID,null);
				this.dormInfo = result.data;
			}
		},
		created(){
			this.getDormById();
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
