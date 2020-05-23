<template>
	<el-carousel indicator-position="outside" height="300"  style="width: 100%;">
	    <el-carousel-item v-for="item in texts" :key="item.index">
	      <div class="block" >
				<el-image :fit="'fill'"  :src="$globalMsg.sverHost+item.frontcut" @click="openNews(item)" style="height: 300px;width: 100%;"></el-image>
				<div style="position: absolute;bottom: 0px;">
					<b style="font-size: 30px;color: black;">{{item.title}}</b>
				</div>
	      </div>
	    </el-carousel-item>
	  </el-carousel>
</template>

<script>
	export default{
		data() {
			return{
				texts:[]
			}
		},
		methods:{
			getArticles:async function(){
				const result = await this.$axios.get("getArticles",null);
				console.log(result);
				this.texts = result.extend.list;
			},
			openNews(newsId){
				this.$store.commit('changeNewsId',newsId);
				this.$router.push('/newsinfo')
			}
		},
		created() {
			this.getArticles();
		}
	}
</script>

<style>
	.el-carousel__item h3 {
	    color: #475669;
	    font-size: 18px;
	    opacity: 0.75;
	    line-height: 300px;
	    margin: 0;
	  }
	  
	  .el-carousel__item:nth-child(2n) {
	    background-color: #99a9bf;
	  }
	  
	  .el-carousel__item:nth-child(2n+1) {
	    background-color: #d3dce6;
	  }
</style>
