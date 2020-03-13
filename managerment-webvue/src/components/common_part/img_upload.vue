<template>
	<el-upload
	  class="avatar-uploader"
	  action=""
	  :show-file-list="false"
	  :on-success="handleAvatarSuccess"
	  :before-upload="beforeAvatarUpload">
	  <el-image
	  v-if="imageUrl"
	        style="width: 150px; height: 180px"
	        :src="imageUrl"
	        :fit="fit">
	  </el-image>
	  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
	</el-upload>
</template>

<script>
  export default {
	props:{
		image:{
			type:String
		},
		imagetype:{
			type:String
		}
	},
    data() {
      return {
		imageUrl:this.image,
		file:'',
		fit:'cover',
		configForm: ''
      }
    },
    methods: {
		upload: async function (data){
			const result = await this.$axios.upload('/imgUpload', data) ;
			this.imageUrl = 'http://localhost:8890/'+result.data.extend.imageUrl;
			this.$emit("imageUrl",result.data.extend.imageUrl)
		},
        handleAvatarSuccess(res, file) {
          this.imageUrl = URL.createObjectURL(file.raw)
        },
        beforeAvatarUpload(image) {
		  var formData = new FormData();
		  formData.append('image', image);
		  formData.append('oldimage', this.imageUrl);
		  formData.append('imagetype', this.imagetype);
          const isJPG = image.type === 'image/jpeg';
          const isLt2M = image.size / 1024 / 1024 < 5;
          if (!isJPG) {
            this.$message.error('上传图片只能是 JPG 格式!');
			return;
          }
          if (!isLt2M) {
            this.$message.error('上传图片大小不能超过 2MB!');
			return;
          }
		  this.upload(formData);
          return isJPG && isLt2M;
      }
    }
  }
</script>

<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
