<template>
	<div>
		<div style="width: 100%; text-align: center;">
			<h1>{{$store.state.article.title}}</h1>
			<p style="float: right;margin-right: 300px;">{{$store.state.article.createdtime}}</p>
		</div>
		<div style="width: 100%;">
			<el-col :span="20" :offset="2">
				<p v-html="alltext"></p>
			</el-col>
			
		</div>
	</div>
</template>

<script>
	export default{
		computed: {
		  alltext() {
		    return this.$store.state.article.alltext
		  },
		}
	}
</script>

<style>
</style>
