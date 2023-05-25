<template>
<div class="content" :style='{"minHeight":"100vh","padding":"30px","background":"url(http://codegen.caihongy.cn/20230329/eff4ea96c952463cb46b9c79d043ce56.gif) fixed,#f6f6f6"}'>
	<div class="text" :style='{"margin":"30px auto","fontSize":"32px","color":"#333","textAlign":"center","fontWeight":"bold"}'>欢迎使用 {{this.$project.projectName}}</div>
    <div class="cardView">
        <div class="cards" :style='{"margin":"50px 0","alignItems":"center","justifyContent":"center","display":"flex"}'>
			<div :style='{"border":"1px solid #ddd","boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"0px","background":"#fff","display":"flex"}' v-if="isAuth('caiwushouzhi','首页总数')">
				<div :style='{"borderColor":"#ddd","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230224/7b9ac76e6ed4427d925b003bcf9bf4c5.png) no-repeat center center / 60% auto","borderWidth":"0 1px 0 0","width":"100px","borderStyle":"solid","height":"100px"}'></div>
				<div :style='{"alignItems":"center","borderRadius":"0px","flexDirection":"column","background":"#fff","display":"flex","width":"180px","justifyContent":"center"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"24px","color":"#555","fontWeight":"bold","height":"24px"}'>{{caiwushouzhiCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>财务收支总数</div>
				</div>
			</div>
        </div>
        <div style="display: flex;align-items: center;width: 100%;margin-bottom: 10px;">
            <el-card style="width: 50%;margin: 0 10px;" v-if="isAuth('caiwushouzhi','首页统计')">
                <div id="caiwushouzhiChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 50%;margin: 0 10px;" v-if="isAuth('caiwushouzhi','首页统计')">
                <div id="caiwushouzhiChart2" style="width:100%;height:400px;"></div>
            </el-card>
        </div>
    </div>
</div>
</template>
<script>
//2
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
            caiwushouzhiCount: 0,
		};
	},
  mounted(){
    this.init();
    this.getcaiwushouzhiCount();
    this.caiwushouzhiChat1();
    this.caiwushouzhiChat2();
  },
  methods:{
    init(){
        if(this.$storage.get('Token')){
        this.$http({
            url: `${this.$storage.get('sessionTable')}/session`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code != 0) {
            router.push({ name: 'login' })
            }
        });
        }else{
            router.push({ name: 'login' })
        }
    },
    getcaiwushouzhiCount() {
        this.$http({
            url: `caiwushouzhi/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.caiwushouzhiCount = data.data
            }
        })
    },

    caiwushouzhiChat1() {
      this.$nextTick(()=>{

        var caiwushouzhiChart1 = echarts.init(document.getElementById("caiwushouzhiChart1"),'macarons');
        this.$http({
            url: `caiwushouzhi/value/dengjiriqi/caiwushouru`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].dengjiriqi);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].dengjiriqi
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '财务收入',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:70
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                caiwushouzhiChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    caiwushouzhiChart1.resize();
                };
            }
        });
      })
    },

    caiwushouzhiChat2() {
      this.$nextTick(()=>{

        var caiwushouzhiChart2 = echarts.init(document.getElementById("caiwushouzhiChart2"),'macarons');
        this.$http({
            url: `caiwushouzhi/value/dengjiriqi/caiwuzhichu`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].dengjiriqi);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].dengjiriqi
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '财务支出',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:70
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                caiwushouzhiChart2.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    caiwushouzhiChart2.resize();
                };
            }
        });
      })
    },





  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
</style>
