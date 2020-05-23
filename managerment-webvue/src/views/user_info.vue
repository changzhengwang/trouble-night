<template>
	<div style="background-color: #f0f0f0;width: 100%;height: 100%;">
		
		<el-col :span="24">
			<el-col :span="8" class="common-padding">
				<el-col :span="24">
					<BigUserInfo></BigUserInfo>
				</el-col>
				<el-col :span="24">
					<div class="common-padding">
						<el-col :span="8">
							<el-button type="primary">详细信息</el-button>		  
						</el-col>
						<el-col :span="8">
							<el-button type="danger">奖罚添加</el-button>
						</el-col>
						<el-col :span="8">
							<el-button type="success">数据统计</el-button>
						</el-col>
					</div>
				</el-col>
				<el-col :span="24">
					柱状图
				</el-col>
			</el-col>
			
			<el-col :span="16" class="common-padding">
				<el-row :gutter="20">
				    <el-col :span="8">
						<LittleScore icon="el-icon-circle-check" color="#409EFF" title="表扬" :score="12"></LittleScore>
				    </el-col>
				    <el-col :span="8">
						<LittleScore icon="el-icon-circle-close" color="#ffaa00" title="批评" :score="80"></LittleScore>
				    </el-col>
				    <el-col :span="8">
						<LittleScore icon="el-icon-stopwatch" color="#00da00" title="总分" :score="180"></LittleScore>
				    </el-col>
				</el-row>
			</el-col>

		</el-col>
		
	</div>
</template>

<script>
	import BigUserInfo from '../components/userinfo_part/big_userinfo.vue'
	import LittleScore from '../components/userinfo_part/little_score.vue'
	export default{
		components:{
			BigUserInfo,
			LittleScore
		},
		data(){
			return{
			}
		}
	}
	
</script>

<style>
	
</style>
