<template>
	<div class="card">
		<div class="loginDiv">
			<el-col :span="24">

				<div class="login-container" >
					<el-col :span="16" :offset="4">
						<el-form  :model="user" :rules="rules"
						 status-icon
						 ref="user" 
						 label-position="left" 
						 label-width="0px" 
						 class="demo-ruleForm login-page">
							<h3 class="title" style="margin: 20px 10px 20px 10px;">登录平台</h3>
							<el-form-item prop="sid">
								<el-input type="text" 
									v-model="user.sid" 
									auto-complete="off" 
									placeholder="账户"></el-input>
							</el-form-item>
							<el-form-item prop="password">
								<el-input type="password" 
									v-model="user.password" 
									auto-complete="off" 
									placeholder="密码"></el-input>
							</el-form-item>
							<el-form-item style="width:100%;">
								<el-button type="primary" style="width:100%;" @click="handleSubmit" :loading="logining">登录</el-button>
							</el-form-item>
							<el-form-item >
								<el-button type="text" @click="forgetpassword">忘记密码</el-button>
							</el-form-item>
							
						</el-form>
					</el-col>
					
				</div>
			</el-col>
		</div>
	</div>
</template>

<script>
  export default {
    data() {
      return {
        logining: false,
        user: {
        },
        rules: {
          sid: [
            { required: true, message: '请输入账号', trigger: 'blur' },
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
          ]
        },
        checked: true
      };
    },
    methods: {
      handleReset2() {
        this.$refs.user.resetFields();
      },
      handleSubmit(ev) {
        this.$refs.user.validate((valid) => {
          if (valid) {
            //this.logining = true;
			//this.$axios.post("/login",this.user);
			this.login(this.user)
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
	  login:async function (res){
		const result = await this.$axios.post("/login",res);
			if(result.code==100){
				//console.log(result);
				localStorage.setItem('user',JSON.stringify(result.extend.user));
				localStorage.setItem('userInfo',JSON.stringify(result.extend.userInfo));
				this.$router.push("/home");
			}	
			else{this.logining = false;}
			},
      forgetpassword(){
          this.$alert('请联系管理员找回密码', '提示', {
          confirmButtonText: '确定',
          type: 'warning'
        })
      }
    }
  }
</script>

<style scoped>
    label.el-checkbox.rememberme {
        margin: 0px 0px 15px;
        text-align: left;
    }
    label.el-button.forget {
        margin: 0;
        padding: 0;
        border: 1px solid transparent;
        outline: none;
    }
	.card {
		position: absolute;
		width: 100%;
		margin-top: 0px;
	    background-image: url("../assets/image/background1.jpg");
		background-repeat:no-repeat;
		background-size:100% 100%;
		-moz-background-size:100% 100%;
		height: 100%;
	}
	.welcomeLoginDiv2{
	    box-shadow: #666 0px 0px 10px;
	    background-color:rgba(42,171,210,0.3);
	    width:400px;
	    align: center;
	    border: 2px solid white;
	    border-radius: 10px;
	    text-align: center;
	    margin:auto;
	        
	}
	.loginDiv{
		height: 300px;
		width: 400px;
		margin: auto;
		margin-top: 10%;
		box-shadow: #666 0px 0px 10px;
		background-color:rgba(255, 255, 255, 0.3);
		border: 1px solid white;
		border-radius: 10px;
	}
</style>