<template>
	<div style="background-color: #f0f0f0;width: 100%;height: 100%;">
		<el-col :span="24">
			<el-col :span="8" class="common-padding">
				<el-col :span="24">
					<BigDormInfo :dormInfo='$globalMsg.viewDormID'></BigDormInfo>
				</el-col>
				<el-col style="margin-top: 10px;">
					<LittleScore icon="el-icon-s-flag" color="#ff5500" title="卫生检查" :score="dormInfo.rewardTimes"></LittleScore>
				</el-col>
				<el-col :span="24">
					<div class="common-padding">
						<el-col :span="8">
							<el-button @click="changeVuex" type="primary">详细信息</el-button>		  
						</el-col>
						<el-col :span="8">
							<el-button @click="delState" type="danger">奖罚添加</el-button>
						</el-col>
						<el-col :span="8">
							<el-button type="success">卫生检查记录</el-button>
						</el-col>
					</div>
				</el-col>
				<el-col :span="24">
					<Numbers></Numbers>
				</el-col>
			</el-col>
			<el-col :span="16" class="common-padding">
				<el-row :gutter="20">
				    <el-col :span="8">
						<LittleScore icon="el-icon-circle-check" color="#409EFF" title="表扬" :score="dormInfo.rewardTimes"></LittleScore>
				    </el-col>
				    <el-col :span="8">
						<LittleScore icon="el-icon-circle-close" color="#ffaa00" title="批评" :score="dormInfo.criticismTimes"></LittleScore>
				    </el-col>
				    <el-col :span="8">
						<LittleScore icon="el-icon-stopwatch" color="#00da00" title="总分" :score="dormInfo.score"></LittleScore>
				    </el-col>
				</el-row>
				<el-col :span="24" style="margin-top: 20px;">
					<el-table
					  :data="tableData"
					  style="width: 100%"
					  :row-class-name="tableRowClassName">
					  <el-table-column
						prop="date"
						label="日期"
						width="180">
					  </el-table-column>
					  <el-table-column
						prop="name"
						label="奖罚原因"
						width="320">
					  </el-table-column>
					  <el-table-column
						prop="address"
						label="加减分">
					  </el-table-column>
					</el-table>
				</el-col>
			</el-col>
	
		</el-col>
		
	</div>
</template>

<script>
	import BigDormInfo from '../components/dorminfo_part/big_dormInfo.vue'
	import LittleScore from '../components/userinfo_part/little_score.vue'
	import Numbers from '../components/dorminfo_part/numbers.vue'
	export default{
		components:{
			BigDormInfo,
			LittleScore,
			Numbers
		},
		data(){
			return{
				dormInfo:'',
				tableData: [
					{
						date: '2020-05-04',
						name: '卫生优秀',
						address: 2
					},{
					date: '2020-05-02',
					name: '卫生打扫不及时',
					address: -2
				  }, {
					date: '2020-05-04',
					name: '卫生优秀',
					address: 2
				  },{
					date: '2020-05-04',
					name: '注意打扫卫生',
					address: 6
				  }, {
					date: '2020-05-01',
					name: '使用违规电器',
					address: -5
				  }, {
					date: '2020-05-01',
					name: '宿舍长请到值班室来一趟',
					address: 0
				  }, {
					date: '2020-05-01',
					name: '帮助摆放宿舍门口违停自行车',
					address: 5
				  }, {
					date: '2020-05-03',
					name: '卫生优秀表扬',
					address: 2
				  }]
				
			}
		},
		methods:{
			tableRowClassName({row, rowIndex}) {
			        if (row.address < 0) {
			          return 'warning-row';
			        } else if (row.address > 0) {
			          return 'success-row';
			        }
			        return '';
			      },
			changeVuex(){
				this.$store.commit('edit','11111')
			},
			delState(){
				Vue.delete(state,'name')
			},
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
	.el-table .warning-row {
	    background: #F56C6C;
    }

    .el-table .success-row {
	    background: #0cc20c;
    }
</style>
