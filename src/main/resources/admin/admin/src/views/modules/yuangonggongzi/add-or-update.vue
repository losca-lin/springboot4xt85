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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="年月份" prop="nianyuefen">
					<el-input v-model="ruleForm.nianyuefen" placeholder="年月份" clearable  :readonly="ro.nianyuefen"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="年月份" prop="nianyuefen">
					<el-input v-model="ruleForm.nianyuefen" placeholder="年月份" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'" label="员工工号" prop="yuangonggonghao">
					<el-select :disabled="ro.yuangonggonghao" @change="yuangonggonghaoChange" v-model="ruleForm.yuangonggonghao" placeholder="请选择员工工号">
						<el-option
							v-for="(item,index) in yuangonggonghaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.yuangonggonghao" label="员工工号" prop="yuangonggonghao">
					<el-input v-model="ruleForm.yuangonggonghao" placeholder="员工工号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="员工姓名" prop="yuangongxingming">
					<el-input v-model="ruleForm.yuangongxingming" placeholder="员工姓名" clearable  :readonly="ro.yuangongxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="员工姓名" prop="yuangongxingming">
					<el-input v-model="ruleForm.yuangongxingming" placeholder="员工姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="职位" prop="zhiwei">
					<el-input v-model="ruleForm.zhiwei" placeholder="职位" clearable  :readonly="ro.zhiwei"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="职位" prop="zhiwei">
					<el-input v-model="ruleForm.zhiwei" placeholder="职位" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="部门" prop="bumen">
					<el-input v-model="ruleForm.bumen" placeholder="部门" clearable  :readonly="ro.bumen"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="部门" prop="bumen">
					<el-input v-model="ruleForm.bumen" placeholder="部门" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="工资卡号" prop="gongzikahao">
					<el-input v-model="ruleForm.gongzikahao" placeholder="工资卡号" clearable  :readonly="ro.gongzikahao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="工资卡号" prop="gongzikahao">
					<el-input v-model="ruleForm.gongzikahao" placeholder="工资卡号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="底薪" prop="dixin">
					<el-input v-model="ruleForm.dixin" placeholder="底薪" clearable  :readonly="ro.dixin"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="底薪" prop="dixin">
					<el-input v-model="ruleForm.dixin" placeholder="底薪" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="全勤奖" prop="quanqinjiang">
					<el-input v-model="ruleForm.quanqinjiang" placeholder="全勤奖" clearable  :readonly="ro.quanqinjiang"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="全勤奖" prop="quanqinjiang">
					<el-input v-model="ruleForm.quanqinjiang" placeholder="全勤奖" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="加班费" prop="jiabanfei">
					<el-input v-model="ruleForm.jiabanfei" placeholder="加班费" clearable  :readonly="ro.jiabanfei"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="加班费" prop="jiabanfei">
					<el-input v-model="ruleForm.jiabanfei" placeholder="加班费" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="绩效奖金" prop="jixiaojiangjin">
					<el-input v-model="ruleForm.jixiaojiangjin" placeholder="绩效奖金" clearable  :readonly="ro.jixiaojiangjin"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="绩效奖金" prop="jixiaojiangjin">
					<el-input v-model="ruleForm.jixiaojiangjin" placeholder="绩效奖金" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="其它扣款" prop="qitakoukuan">
					<el-input v-model="ruleForm.qitakoukuan" placeholder="其它扣款" clearable  :readonly="ro.qitakoukuan"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="其它扣款" prop="qitakoukuan">
					<el-input v-model="ruleForm.qitakoukuan" placeholder="其它扣款" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="金额" prop="jine">
					<el-input v-model="jine" placeholder="金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.jine" label="金额" prop="jine">
					<el-input v-model="ruleForm.jine" placeholder="金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="工资备注" prop="gongzibeizhu">
					<el-input v-model="ruleForm.gongzibeizhu" placeholder="工资备注" clearable  :readonly="ro.gongzibeizhu"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="工资备注" prop="gongzibeizhu">
					<el-input v-model="ruleForm.gongzibeizhu" placeholder="工资备注" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="登记时间" prop="dengjishijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.dengjishijian" 
						type="datetime"
						:readonly="ro.dengjishijian"
						placeholder="登记时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.dengjishijian" label="登记时间" prop="dengjishijian">
					<el-input v-model="ruleForm.dengjishijian" placeholder="登记时间" readonly></el-input>
				</el-form-item>
			</template>
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
				nianyuefen : false,
				yuangonggonghao : false,
				yuangongxingming : false,
				zhiwei : false,
				bumen : false,
				gongzikahao : false,
				dixin : false,
				quanqinjiang : false,
				jiabanfei : false,
				jixiaojiangjin : false,
				qitakoukuan : false,
				jine : false,
				gongzibeizhu : false,
				dengjishijian : false,
			},
			
			
			ruleForm: {
				nianyuefen: '',
				yuangonggonghao: '',
				yuangongxingming: '',
				zhiwei: '',
				bumen: '',
				gongzikahao: '',
				dixin: '',
				quanqinjiang: '',
				jiabanfei: '',
				jixiaojiangjin: '',
				qitakoukuan: '',
				jine: '',
				gongzibeizhu: '',
				dengjishijian: '',
			},
		
			yuangonggonghaoOptions: [],

			
			rules: {
				nianyuefen: [
					{ required: true, message: '年月份不能为空', trigger: 'blur' },
				],
				yuangonggonghao: [
					{ required: true, message: '员工工号不能为空', trigger: 'blur' },
				],
				yuangongxingming: [
				],
				zhiwei: [
				],
				bumen: [
				],
				gongzikahao: [
				],
				dixin: [
					{ required: true, message: '底薪不能为空', trigger: 'blur' },
					{ validator: validateNumber, trigger: 'blur' },
				],
				quanqinjiang: [
					{ required: true, message: '全勤奖不能为空', trigger: 'blur' },
					{ validator: validateNumber, trigger: 'blur' },
				],
				jiabanfei: [
					{ required: true, message: '加班费不能为空', trigger: 'blur' },
					{ validator: validateNumber, trigger: 'blur' },
				],
				jixiaojiangjin: [
					{ required: true, message: '绩效奖金不能为空', trigger: 'blur' },
					{ validator: validateNumber, trigger: 'blur' },
				],
				qitakoukuan: [
					{ required: true, message: '其它扣款不能为空', trigger: 'blur' },
					{ validator: validateNumber, trigger: 'blur' },
				],
				jine: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				gongzibeizhu: [
				],
				dengjishijian: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {
		jine: {
			get: function () {
				return 0+parseFloat(this.ruleForm.dixin==""?0:this.ruleForm.dixin)+parseFloat(this.ruleForm.quanqinjiang==""?0:this.ruleForm.quanqinjiang)+parseFloat(this.ruleForm.jiabanfei==""?0:this.ruleForm.jiabanfei)+parseFloat(this.ruleForm.jixiaojiangjin==""?0:this.ruleForm.jixiaojiangjin)-parseFloat(this.ruleForm.qitakoukuan==""?0:this.ruleForm.qitakoukuan) || 0
			}
		},



	},
    components: {
    },
	created() {
		this.ruleForm.dengjishijian = this.getCurDateTime()
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
						if(o=='nianyuefen'){
							this.ruleForm.nianyuefen = obj[o];
							this.ro.nianyuefen = true;
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
						if(o=='zhiwei'){
							this.ruleForm.zhiwei = obj[o];
							this.ro.zhiwei = true;
							continue;
						}
						if(o=='bumen'){
							this.ruleForm.bumen = obj[o];
							this.ro.bumen = true;
							continue;
						}
						if(o=='gongzikahao'){
							this.ruleForm.gongzikahao = obj[o];
							this.ro.gongzikahao = true;
							continue;
						}
						if(o=='dixin'){
							this.ruleForm.dixin = obj[o];
							this.ro.dixin = true;
							continue;
						}
						if(o=='quanqinjiang'){
							this.ruleForm.quanqinjiang = obj[o];
							this.ro.quanqinjiang = true;
							continue;
						}
						if(o=='jiabanfei'){
							this.ruleForm.jiabanfei = obj[o];
							this.ro.jiabanfei = true;
							continue;
						}
						if(o=='jixiaojiangjin'){
							this.ruleForm.jixiaojiangjin = obj[o];
							this.ro.jixiaojiangjin = true;
							continue;
						}
						if(o=='qitakoukuan'){
							this.ruleForm.qitakoukuan = obj[o];
							this.ro.qitakoukuan = true;
							continue;
						}
						if(o=='jine'){
							this.ruleForm.jine = obj[o];
							this.ro.jine = true;
							continue;
						}
						if(o=='gongzibeizhu'){
							this.ruleForm.gongzibeizhu = obj[o];
							this.ro.gongzibeizhu = true;
							continue;
						}
						if(o=='dengjishijian'){
							this.ruleForm.dengjishijian = obj[o];
							this.ro.dengjishijian = true;
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
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/yuangong/yuangonggonghao`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.yuangonggonghaoOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
			// 下二随
			yuangonggonghaoChange () {
				this.$http({
					url: `follow/yuangong/yuangonggonghao?columnValue=`+ this.ruleForm.yuangonggonghao,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.yuangongxingming){
							this.ruleForm.yuangongxingming = data.data.yuangongxingming
						}
						if(data.data.zhiwei){
							this.ruleForm.zhiwei = data.data.zhiwei
						}
						if(data.data.bumen){
							this.ruleForm.bumen = data.data.bumen
						}
						if(data.data.gongzikahao){
							this.ruleForm.gongzikahao = data.data.gongzikahao
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `yuangonggongzi/info/${id}`,
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
        this.ruleForm.jine = this.jine





























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
				url: "yuangonggongzi/page", 
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
					   url: `yuangonggongzi/${!this.ruleForm.id ? "save" : "update"}`,
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
						 this.parent.yuangonggongziCrossAddOrUpdateFlag = false;
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
			   url: `yuangonggongzi/${!this.ruleForm.id ? "save" : "update"}`,
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
				 this.parent.yuangonggongziCrossAddOrUpdateFlag = false;
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
      this.parent.yuangonggongziCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
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
