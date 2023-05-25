<template>
	<div class="addEdit-block" :style='{"minHeight":"100vh","padding":"30px","background":"url(http://codegen.caihongy.cn/20230329/eff4ea96c952463cb46b9c79d043ce56.gif) fixed,#f6f6f6"}' style="width: 100%;">
		<el-form
			:style='{"padding":"20px","boxShadow":"0 0px 0px #ddd","borderRadius":"0px","background":"none"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="报销标题" prop="baoxiaobiaoti">
					<el-input v-model="ruleForm.baoxiaobiaoti" placeholder="报销标题" clearable  :readonly="ro.baoxiaobiaoti"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="报销标题" prop="baoxiaobiaoti">
					<el-input v-model="ruleForm.baoxiaobiaoti" placeholder="报销标题" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="月份" prop="yuefen">
					<el-select :disabled="ro.yuefen" v-model="ruleForm.yuefen" placeholder="请选择月份" >
						<el-option
							v-for="(item,index) in yuefenOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="月份" prop="yuefen">
					<el-input v-model="ruleForm.yuefen"
						placeholder="月份" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info'&& !ro.baoxiaowenjian" label="报销文件" prop="baoxiaowenjian">
					<file-upload
						tip="点击上传报销文件"
						action="file/upload"
						:limit="1"
						:multiple="true"
						:fileUrls="ruleForm.baoxiaowenjian?ruleForm.baoxiaowenjian:''"
						@change="baoxiaowenjianUploadChange"
					></file-upload>
				</el-form-item>  
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.baoxiaowenjian" label="报销文件" prop="baoxiaowenjian">
					<el-button :style='{"border":"0px solid #47afce","cursor":"pointer","padding":"0 35px","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"0px","background":"#339933","width":"auto","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="text" size="small" @click="download($base.url+ruleForm.baoxiaowenjian)">下载</el-button>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="!ruleForm.baoxiaowenjian" label="报销文件" prop="baoxiaowenjian">
					<el-button :style='{"border":"0px solid #47afce","cursor":"pointer","padding":"0 35px","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"0px","background":"#339933","width":"auto","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="text" size="small">无</el-button>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="报销金额" prop="baoxiaojine">
					<el-input v-model="ruleForm.baoxiaojine" placeholder="报销金额" clearable  :readonly="ro.baoxiaojine"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="报销金额" prop="baoxiaojine">
					<el-input v-model="ruleForm.baoxiaojine" placeholder="报销金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="申请日期" prop="shenqingriqi">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.shenqingriqi" 
						type="date"
						:readonly="ro.shenqingriqi"
						placeholder="申请日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.shenqingriqi" label="申请日期" prop="shenqingriqi">
					<el-input v-model="ruleForm.shenqingriqi" placeholder="申请日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="员工工号" prop="yuangonggonghao">
					<el-input v-model="ruleForm.yuangonggonghao" placeholder="员工工号" clearable  :readonly="ro.yuangonggonghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="员工工号" prop="yuangonggonghao">
					<el-input v-model="ruleForm.yuangonggonghao" placeholder="员工工号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="员工姓名" prop="yuangongxingming">
					<el-input v-model="ruleForm.yuangongxingming" placeholder="员工姓名" clearable  :readonly="ro.yuangongxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="员工姓名" prop="yuangongxingming">
					<el-input v-model="ruleForm.yuangongxingming" placeholder="员工姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="联系方式" prop="lianxifangshi">
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" clearable  :readonly="ro.lianxifangshi"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="联系方式" prop="lianxifangshi">
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="部门" prop="bumen">
					<el-input v-model="ruleForm.bumen" placeholder="部门" clearable  :readonly="ro.bumen"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="部门" prop="bumen">
					<el-input v-model="ruleForm.bumen" placeholder="部门" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="职位" prop="zhiwei">
					<el-input v-model="ruleForm.zhiwei" placeholder="职位" clearable  :readonly="ro.zhiwei"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="职位" prop="zhiwei">
					<el-input v-model="ruleForm.zhiwei" placeholder="职位" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="textarea" v-if="type!='info'" label="报销内容" prop="baoxiaoneirong">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="报销内容"
					  v-model="ruleForm.baoxiaoneirong" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.baoxiaoneirong" label="报销内容" prop="baoxiaoneirong">
					<span :style='{"fontSize":"16px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}'>{{ruleForm.baoxiaoneirong}}</span>
				</el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"0px","background":"#339933","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"0px solid #1b5a90","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#333","borderRadius":"0px","background":"#FFCC33","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"0px solid #1b5a90","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#333","borderRadius":"0px","background":"#FFCC33","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				baoxiaobiaoti : false,
				yuefen : false,
				baoxiaoneirong : false,
				baoxiaowenjian : false,
				baoxiaojine : false,
				shenqingriqi : false,
				yuangonggonghao : false,
				yuangongxingming : false,
				lianxifangshi : false,
				bumen : false,
				zhiwei : false,
				sfsh : false,
				shhf : false,
				ispay : false,
			},
			
			
			ruleForm: {
				baoxiaobiaoti: '',
				yuefen: '',
				baoxiaoneirong: '',
				baoxiaowenjian: '',
				baoxiaojine: '',
				shenqingriqi: '',
				yuangonggonghao: '',
				yuangongxingming: '',
				lianxifangshi: '',
				bumen: '',
				zhiwei: '',
				shhf: '',
			},
		
			yuefenOptions: [],

			
			rules: {
				baoxiaobiaoti: [
					{ required: true, message: '报销标题不能为空', trigger: 'blur' },
				],
				yuefen: [
					{ required: true, message: '月份不能为空', trigger: 'blur' },
				],
				baoxiaoneirong: [
					{ required: true, message: '报销内容不能为空', trigger: 'blur' },
				],
				baoxiaowenjian: [
				],
				baoxiaojine: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				shenqingriqi: [
				],
				yuangonggonghao: [
				],
				yuangongxingming: [
				],
				lianxifangshi: [
					{ validator: validateMobile, trigger: 'blur' },
				],
				bumen: [
				],
				zhiwei: [
				],
				sfsh: [
				],
				shhf: [
				],
				ispay: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.shenqingriqi = this.getCurDate()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='baoxiaobiaoti'){
							this.ruleForm.baoxiaobiaoti = obj[o];
							this.ro.baoxiaobiaoti = true;
							continue;
						}
						if(o=='yuefen'){
							this.ruleForm.yuefen = obj[o];
							this.ro.yuefen = true;
							continue;
						}
						if(o=='baoxiaoneirong'){
							this.ruleForm.baoxiaoneirong = obj[o];
							this.ro.baoxiaoneirong = true;
							continue;
						}
						if(o=='baoxiaowenjian'){
							this.ruleForm.baoxiaowenjian = obj[o];
							this.ro.baoxiaowenjian = true;
							continue;
						}
						if(o=='baoxiaojine'){
							this.ruleForm.baoxiaojine = obj[o];
							this.ro.baoxiaojine = true;
							continue;
						}
						if(o=='shenqingriqi'){
							this.ruleForm.shenqingriqi = obj[o];
							this.ro.shenqingriqi = true;
							continue;
						}
						if(o=='yuangonggonghao'){
							this.ruleForm.yuangonggonghao = obj[o];
							this.ro.yuangonggonghao = true;
							continue;
						}
						if(o=='yuangongxingming'){
							this.ruleForm.yuangongxingming = obj[o];
							this.ro.yuangongxingming = true;
							continue;
						}
						if(o=='lianxifangshi'){
							this.ruleForm.lianxifangshi = obj[o];
							this.ro.lianxifangshi = true;
							continue;
						}
						if(o=='bumen'){
							this.ruleForm.bumen = obj[o];
							this.ro.bumen = true;
							continue;
						}
						if(o=='zhiwei'){
							this.ruleForm.zhiwei = obj[o];
							this.ro.zhiwei = true;
							continue;
						}
				}
				














			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.yuangonggonghao!=''&&json.yuangonggonghao) || json.yuangonggonghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yuangonggonghao = json.yuangonggonghao
						this.ro.yuangonggonghao = true;
					}
					if(((json.yuangongxingming!=''&&json.yuangongxingming) || json.yuangongxingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yuangongxingming = json.yuangongxingming
						this.ro.yuangongxingming = true;
					}
					if(((json.lianxifangshi!=''&&json.lianxifangshi) || json.lianxifangshi==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.lianxifangshi = json.lianxifangshi
						this.ro.lianxifangshi = true;
					}
					if(((json.bumen!=''&&json.bumen) || json.bumen==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.bumen = json.bumen
						this.ro.bumen = true;
					}
					if(((json.zhiwei!=''&&json.zhiwei) || json.zhiwei==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.zhiwei = json.zhiwei
						this.ro.zhiwei = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.yuefenOptions = "1月份,2月份,3月份,4月份,5月份,6月份,7月份,8月份,9月份,10月份,11月份,12月份".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `yuangongbaoxiao/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {








	if(this.ruleForm.baoxiaowenjian!=null) {
		this.ruleForm.baoxiaowenjian = this.ruleForm.baoxiaowenjian.replace(new RegExp(this.$base.url,"g"),"");
	}





















var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "yuangongbaoxiao/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `yuangongbaoxiao/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.yuangongbaoxiaoCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `yuangongbaoxiao/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.yuangongbaoxiaoCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.yuangongbaoxiaoCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    baoxiaowenjianUploadChange(fileUrls) {
	    this.ruleForm.baoxiaowenjian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 180px;
	  	  font-size: 16px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 400px;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 10px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 200px;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 200px;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: #ccc;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: #ccc;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: #ccc;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 12px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 400px;
	  	  font-size: 16px;
	  	  min-height: 120px;
	  	  height: auto;
	  	}
</style>
