<template>
	<div style="margin: auto;width: 100%;">
		<el-col :span="24">
			<div class="common-padding">
				<Notice></Notice>
			</div>
		</el-col>
		
		<el-col :span="24">
			<el-col :span="10">
				<div class="common-padding">
					<Carousel></Carousel>
				</div>
			</el-col>
			<el-col :span="14">
				<div class="common-padding">
					<BlackBoard ></BlackBoard>
				</div>
			</el-col>
			
		</el-col>
		
		<el-col :span="24">
			<el-col :span="12">
				<div class="common-padding">
					<News newstype='学校新闻'></News>
				</div>
			</el-col>
			<el-col :span="12">
				<div class="common-padding">
					<News newstype='宿舍新闻'></News>
				</div>
			</el-col>
			
		</el-col>
		
		
	</div>
  
</template>

<script>
	import BlackBoard from '../components/index_part/blackboard.vue'
	import Carousel from '../components/index_part/carousel.vue'
	import News from '../components/index_part/news.vue'
	import Notice from '../components/index_part/notice.vue'
	export default{
		components:{
			Carousel,
			BlackBoard,
			News,
			Notice
		},
		data() {
			return{
				texts:[]
			}
		},
		methods:{
			getArticles:async function(){
				const result = await this.$axios.get("getArticles",null);
				this.texts = result.extend.list;
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
	    font-size: 14px;
	    opacity: 0.75;
	    line-height: 200px;
	    margin: 0;
	  }
	  
	  .el-carousel__item:nth-child(2n) {
	    background-color: #99a9bf;
	  }
	  
	  .el-carousel__item:nth-child(2n+1) {
	    background-color: #d3dce6;
	  }
</style>
