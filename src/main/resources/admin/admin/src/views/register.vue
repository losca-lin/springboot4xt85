<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","width":"100%","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230329/d97879eb2f4d4671b6bf9d276374adef.jpg) no-repeat center center / 100% 100%","justifyContent":"center","display":"flex"}'>
			<el-form v-if="pageFlag=='register'" :style='{"padding":"0px 0px 20px","margin":"0","borderColor":"#fff","display":"flex","float":"right","justifyContent":"center","borderRadius":"0px","flexWrap":"wrap","background":"rgba(220,220,220,.96)","borderWidth":"4px","width":"650px","position":"relative","borderStyle":"solid","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm">
				<div v-if="true" :style='{"padding":"10px 0","margin":"0 0 20px 0","borderColor":"#ddd","color":"#fff","textAlign":"center","borderRadius":"0px","background":"#339933","borderWidth":"0px","width":"100%","fontSize":"22px","borderStyle":"solid","textShadow":"0px 0px 0px rgba(64, 158, 255, .5)","height":"50px"}' class="title">企业财务管理系统注册</div>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">员工工号</div>
					<el-input  v-model="ruleForm.yuangonggonghao"  autocomplete="off" placeholder="员工工号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">员工姓名</div>
					<el-input  v-model="ruleForm.yuangongxingming"  autocomplete="off" placeholder="员工姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in yuangongxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">部门</div>
                    <el-select v-model="ruleForm.bumen" placeholder="请选择部门" :disabled="true">
                        <el-option
                            v-for="(item,index) in yuangongbumenOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">职位</div>
					<el-input  v-model="ruleForm.zhiwei" readonly autocomplete="off" placeholder="职位"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">入职时间</div>
                    <el-date-picker
                        format="yyyy 年 MM 月 dd 日"
                        value-format="yyyy-MM-dd"
                        v-model="ruleForm.ruzhishijian"
                        type="date"
                        placeholder="入职时间"
                    ></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">联系方式</div>
					<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">工资卡号</div>
					<el-input  v-model="ruleForm.gongzikahao"  autocomplete="off" placeholder="工资卡号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">身份证</div>
					<el-input  v-model="ruleForm.shenfenzheng"  autocomplete="off" placeholder="身份证"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='caiwu'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">财务账号</div>
					<el-input  v-model="ruleForm.caiwuzhanghao"  autocomplete="off" placeholder="财务账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='caiwu'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='caiwu'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='caiwu'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">财务姓名</div>
					<el-input  v-model="ruleForm.caiwuxingming"  autocomplete="off" placeholder="财务姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='caiwu'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in caiwuxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='caiwu'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">手机</div>
					<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0px 0px 0px #f9d7b5","margin":"0px auto 10px","color":"#fff","display":"block","outline":"none","borderRadius":"50px","background":"#339933","width":"60%","fontSize":"18px","height":"40px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0","color":"#666","textAlign":"right","display":"inline-block","width":"60%","lineHeight":"1","fontSize":"14px","textDecoration":"underline"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>

export default {
	data() {
		return {
			ruleForm: {
                xingbie: '',
                bumen: '',
                xingbie: '',
			},

            pageFlag : '',
			tableName:"",
			rules: {},
            yuangongxingbieOptions: [],
            yuangongbumenOptions: [],
            caiwuxingbieOptions: [],
		};
	},
	mounted(){
        this.pageFlag = this.$storage.get("pageFlag");
		let table = this.$storage.get("loginTable");
		this.tableName = table;
        this.yuangongxingbieOptions = "男,女".split(',')
        this.$http({
            url: `option/bumenxinxi/bumenmingcheng`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.yuangongbumenOptions = data.data;
            } else {
                this.$message.error(data.msg);
            }
        });
        this.caiwuxingbieOptions = "男,女".split(',')
	},
	created() {
    
	},
	destroyed() {
		  	},
	methods: {
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.yuangonggonghao) && `yuangong` == this.tableName){
						this.$message.error(`员工工号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yuangong` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.yuangongxingming) && `yuangong` == this.tableName){
						this.$message.error(`员工姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`yuangong` == this.tableName && this.ruleForm.lianxifangshi&&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
						this.$message.error(`联系方式应输入手机格式`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`yuangong` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
						this.$message.error(`身份证应输入身份证格式`);
						return
					}
					
					
				
					if((!this.ruleForm.caiwuzhanghao) && `caiwu` == this.tableName){
						this.$message.error(`财务账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `caiwu` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `caiwu` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.caiwuxingming) && `caiwu` == this.tableName){
						this.$message.error(`财务姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`caiwu` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
					
					
					
					
				
			
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20230329/d97879eb2f4d4671b6bf9d276374adef.jpg) no-repeat center center / 100% 100%;

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 30px;
						padding: 0 10px;
						margin: 0px 0px 0px  0px;
						color: #333;
						width: 100%;
						font-size: 14px;
						border-color: #ddd;
						border-width: 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 0;
						border-radius: 30px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #999;
						width: 288px;
						font-size: 14px;
						border-color: #ddd;
						border-width: 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 0;
						border-radius: 30px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #999;
						width: 288px;
						font-size: 14px;
						border-color: #ddd;
						border-width: 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 0;
						border-radius: 30px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #999;
						width: 288px;
						font-size: 14px;
						border-color: #ddd;
						border-width: 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px solid #ddd;
		  		  cursor: pointer;
		  		  border-radius: 20px;
		  		  margin: 10px 0px 10px 10px;
		  		  color: #ccc;
		  		  background: #fff;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px solid #ddd;
		  		  cursor: pointer;
		  		  border-radius: 20px;
		  		  margin: 10px 0px 10px 10px;
		  		  color: #ccc;
		  		  background: #fff;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px solid #ddd;
		  		  cursor: pointer;
		  		  border-radius: 20px;
		  		  margin: 10px 0px 10px 10px;
		  		  color: #ccc;
		  		  background: #fff;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
</style>
