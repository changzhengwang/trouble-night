<template>
	<el-card shadow="hover" :body-style="{padding: '0px'}">
	    <div class="grid-content">
	        <i :class="icon" :style="{'background-color':color}" class=" icon100"></i>
	        <div class="text-icon">
	            <div :style="{'color':color}" style="font-size: 30px;text-align: center;">{{score}}</div>
	            <div>{{title}}</div>
	        </div>
	    </div>
	</el-card>
</template>

<script>
	export default{
		props:{
				icon:String,
				color:String,
				title:String,
				score:Number
			}	
	}
</script>

<style>
</style>
