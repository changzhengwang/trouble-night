<template>
	<div class="common-padding">
		<el-col :span="24">
			<el-col :span="24">
				<el-col :span="16">
					<h2>寝室查询</h2>
				</el-col>
				<el-col :span="8">
					<el-col :span="12">
						<el-input
						  placeholder="寝室名"
						  v-model="dormName"
						  clearable>
						</el-input>
					</el-col>
					<el-col :span="8">
						<el-button @click="getDorms(dormName)" type="primary">查询</el-button>
					</el-col>
				</el-col>
			</el-col>
			<el-col :span="24">
				<el-table
				    :data="dorms"
				    style="width: 100%">
				    <el-table-column
				      label="Date"
				      prop="id">
				    </el-table-column>
				    <el-table-column
				      label="寝室名"
				      prop="name">
				    </el-table-column>
					<el-table-column
					  label="所属楼"
					  prop="dormitoryId">
					</el-table-column>
					<el-table-column
					  label="成员数"
					  prop="member">
					</el-table-column>
					<el-table-column
					  label="管理分数"
					  prop="name">
					</el-table-column>
				    <el-table-column
					  label="操作"
				      align="left">
				      <template slot-scope="scope">
				        <el-button
				          size="mini"
						  type="success"
				          @click="viewDorm(scope.row)">查看</el-button>
					  </template>
				    </el-table-column>
				  </el-table>
			</el-col>
			<el-col :span="24">
				
			</el-col>
		</el-col>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				dormName:'',
				dorms:[]
			  }
			},
		methods: {
		  viewDorm(row){
			  this.$globalMsg.viewDormID=row.id;
			  this.$router.push('dorminfo');
		  },
		  getDorms: async function(data){
			const result = await this.$axios.get('getDorm?&dormitoryId=乾园五号楼&name='+data,null);
			this.dorms = result.data;
		  }
		},
		created(){
			this.getDorms('');
		}
	}
</script>
