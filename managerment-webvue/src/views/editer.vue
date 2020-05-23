<template lang="html">
	<div>
		<div>
			  <el-dialog
			    title="提示"
			    :visible.sync="dialogVisible"
			    width="30%"
			    :before-close="handleClose">
				<p>输入文章标题</p><el-input v-model="text.title"></el-input>
			    <ImgUpload :imagetype="imagetype" @imageUrl="imageUrl"></ImgUpload>
			    <span slot="footer" class="dialog-footer">
			      <el-button @click="dialogVisible = false">取 消</el-button>
			      <el-button type="primary" @click="saveArticle">确 定</el-button>
			    </span>
			  </el-dialog>
		</div>
		<div class="editor">
			  <div style="width: 100%;">
				  <div ref="toolbar" class="toolbar">
				  </div>
				  <div style="width: 10%;float: left;">
					  <el-button @click="test1" size="mini" type="primary" icon="el-icon-plus"></el-button>
					  <el-button @click="dialogVisible = true" size="mini" type="success" icon="el-icon-check"></el-button>
				  </div>
				  <br/>
			  </div>
			
				<div ref="editor" class="text">
				</div>
			
			
		  
		</div>
		
	</div>
  
</template>

<script>
	import ImgUpload from '../components/common_part/img_upload.vue'
    import E from 'wangeditor'
	
    export default {
        name: 'editoritem',
        data() {
          return {
			imagetype:'article',
			imgUrl:null,
            dialogVisible: false,
            editor: null,
            info_: null,
	    	text: {
					  frontcut:null,
					  title:null,
	    			  alltext:null,
	    			  createdps:null
	    	},
          }
        },
		components:{
			ImgUpload
		},
        model: {
            prop: 'value',
            event: 'change'
        },
        props: {
            value: {
              type: String,
              default: ''
            },
            isClear: {
              type: Boolean,
              default: false
            }
        },
        watch: {
            isClear(val) {
              // 触发清除文本域内容
                if (val) {
                    this.editor.txt.clear()
                    this.info_ = null
                }
            },
            value: function(value) {
                if (value !== this.editor.txt.html()) {
					this.editor.txt.html(this.value)
                }
            }
            //value为编辑框输入的内容，这里我监听了一下值，当父组件调用得时候，如果给value赋值了，子组件将会显示父组件赋给的值
        },
        mounted() {
            this.seteditor()
            this.editor.txt.html(this.value)
        },
        methods: {
			upload:async function (data){
				const result = await this.$axios.upload('/imgUpload', data) ;
				return 'http://localhost:8890/'+result.data.extend.imageUrl;
			},
			imageUrl(value){
				this.imgUrl = value
			},
	    	handleClose(done) {
	    		this.$confirm('确认关闭？')
	    		  .then(_ => {
	    			done();
	    		  })
	    		  .catch(_ => {});
	    	},
	    	test1(){
	    		this.$axios.get("getUsers",null)
	    	},
	    	saveArticle(){
	    		this.text.createdps = this.$globalMsg.user
	    		this.text.alltext = this.info_
				console.log(this.imgUrl)
				this.text.frontcut = this.imgUrl
	    		this.$axios.post('saveArticle',this.text)
	    	},
            seteditor() {
				let _this=this;
                // http://192.168.2.125:8080/admin/storage/create
                this.editor = new E(this.$refs.toolbar, this.$refs.editor)
                this.editor.customConfig.uploadImgShowBase64 = false // base 64 存储图片
                this.editor.customConfig.uploadImgServer = 'http://otp.cdinfotech.top/file/upload_images'// 配置服务器端地址
                this.editor.customConfig.uploadImgHeaders = { }// 自定义 header
                this.editor.customConfig.uploadFileName = 'file' // 后端接受上传文件的参数名
                this.editor.customConfig.uploadImgMaxSize = 2 * 1024 * 1024 // 将图片大小限制为 2M
                this.editor.customConfig.uploadImgMaxLength = 6 // 限制一次最多上传 3 张图片
                this.editor.customConfig.uploadImgTimeout = 3 * 60 * 1000 // 设置超时时间
                // 配置菜单
                this.editor.customConfig.menus = [
                  'head', // 标题
                  'bold', // 粗体
                  'fontSize', // 字号
                  'fontName', // 字体
                  'italic', // 斜体
                  'underline', // 下划线
                  'strikeThrough', // 删除线
                  'foreColor', // 文字颜色
                  'backColor', // 背景颜色
                  'link', // 插入链接
                  'list', // 列表
                  'justify', // 对齐方式
                  'quote', // 引用
                  'emoticon', // 表情
                  'image', // 插入图片
                  'table', // 表格
                  'code', // 插入代码
                  'undo', // 撤销
                  'redo', // 重复
                ]
				this.editor.customConfig.customUploadImg =async function (files, insert) {
				    // files 是 input 中选中的文件列表
				    // insert 是获取图片 url 后，插入到编辑器的方法
					var formData = new FormData();
					formData.append('image', files[0]);
					formData.append('oldimage', null);
					formData.append('imagetype', 'article');
					const result = await _this.$axios.upload('/imgUpload', formData) ;
				    // 上传代码返回结果之后，将图片插入到编辑器中
				    insert('http://localhost:8890/'+result.data.extend.imageUrl)
				}
			    
               
                this.editor.customConfig.onchange = (html) => {
                  this.info_ = html // 绑定当前逐渐地值
                  this.$emit('change', this.info_) // 将内容同步到父组件中
                }
                // 创建富文本编辑器
                this.editor.create()
          }
        }
    }
</script>
<style lang="css">
  .editor {
    width: 100%;
    margin: 0 auto;
    position: relative;
    z-index: 0;
  }
  .toolbar {
	width: 90%;
    border: 1px solid #ccc;
	float: left;
  }
  .text {
	
	margin-top: 12px;
    border: 1px solid #ccc;
    min-height: 80vh;
  }
</style>