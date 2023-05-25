import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import yuangong from '@/views/modules/yuangong/list'
    import chanpinxinxi from '@/views/modules/chanpinxinxi/list'
    import yuangonggongzi from '@/views/modules/yuangonggongzi/list'
    import yuangongbaoxiao from '@/views/modules/yuangongbaoxiao/list'
    import yuanliaocaigou from '@/views/modules/yuanliaocaigou/list'
    import xitonggonggao from '@/views/modules/xitonggonggao/list'
    import caiwu from '@/views/modules/caiwu/list'
    import yuanliaoleibie from '@/views/modules/yuanliaoleibie/list'
    import menu from '@/views/modules/menu/list'
    import bumenxinxi from '@/views/modules/bumenxinxi/list'
    import chanpinleixing from '@/views/modules/chanpinleixing/list'
    import chanpinxiaoshouzhangmu from '@/views/modules/chanpinxiaoshouzhangmu/list'
    import caiwushouzhi from '@/views/modules/caiwushouzhi/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/yuangong',
        name: '员工',
        component: yuangong
      }
      ,{
	path: '/chanpinxinxi',
        name: '产品信息',
        component: chanpinxinxi
      }
      ,{
	path: '/yuangonggongzi',
        name: '员工工资',
        component: yuangonggongzi
      }
      ,{
	path: '/yuangongbaoxiao',
        name: '员工报销',
        component: yuangongbaoxiao
      }
      ,{
	path: '/yuanliaocaigou',
        name: '原料采购',
        component: yuanliaocaigou
      }
      ,{
	path: '/xitonggonggao',
        name: '系统公告',
        component: xitonggonggao
      }
      ,{
	path: '/caiwu',
        name: '财务',
        component: caiwu
      }
      ,{
	path: '/yuanliaoleibie',
        name: '原料类别',
        component: yuanliaoleibie
      }
      ,{
	path: '/menu',
        name: '菜单列表',
        component: menu
      }
      ,{
	path: '/bumenxinxi',
        name: '部门信息',
        component: bumenxinxi
      }
      ,{
	path: '/chanpinleixing',
        name: '产品类型',
        component: chanpinleixing
      }
      ,{
	path: '/chanpinxiaoshouzhangmu',
        name: '产品销售账目',
        component: chanpinxiaoshouzhangmu
      }
      ,{
	path: '/caiwushouzhi',
        name: '财务收支',
        component: caiwushouzhi
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
