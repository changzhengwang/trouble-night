<template>
	<div style="background-color: #e2e2e2;width: 100%;height: 100%;">
		
		<el-col :span="24">
			<el-col :span="8" class="common-padding">
				<BigUserInfo></BigUserInfo>
			</el-col>
			
			<el-col :span="16" class="common-padding">
				<el-row :gutter="20">
				    <el-col :span="8">
				        <el-card shadow="hover" :body-style="{padding: '0px'}">
				            <div class="grid-content">
				                <i class="el-icon-bell icon100" style="background-color: #409EFF;"></i>
				                <div class="text-icon">
				                    <div style="font-size: 30px;color: #409EFF;text-align: center;">1234</div>
				                    <div>我的通知</div>
				                </div>
				            </div>
				        </el-card>
				    </el-col>
				    <el-col :span="8">
				        <el-card shadow="hover" :body-style="{padding: '0px'}">
				            <div class="grid-content">
				                <i class="el-icon-document-copy icon100" style="background-color: #ffaa00;"></i>
				                <div class="text-icon">
				                    <div style="font-size: 30px;color: #ffaa00;;text-align: center;">321</div>
				                    <div>文章历史</div>
				                </div>
				            </div>
				        </el-card>
				    </el-col>
				    <el-col :span="8">
				        <el-card shadow="hover" :body-style="{padding: '0px'}">
				            <div class="grid-content">
				                <i class="el-icon-check icon100" style="background-color: #00da00;"></i>
				                <div class="text-icon">
				                    <div style="font-size: 30px;color: #00da00;text-align: center;">在校</div>
				                    <div>在校状态</div>
				                </div>
				            </div>
				        </el-card>
				    </el-col>
				</el-row>
			</el-col>

		</el-col>
		
	</div>
</template>

<script>
	import BigUserInfo from '../components/userinfo_part/big_userinfo.vue'
	export default{
		components:{
			BigUserInfo
		},
		data(){
			return{
			}
		}
	}
	
</script>

<style>
	
</style>
