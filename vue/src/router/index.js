import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    //不建议在主路由中写name,不然后面路由跳转会给你警告，Manage这一行删掉都行
    //name: 'Manage',
    component: () => import('../views/Manage.vue'),
    redirect: "/home",
    //设置子路由 [
    children: [
      {
        path: 'home',name:'首页',component:() => import("../views/Home")
      },{
        path: 'user',name:'用户管理',component:() => import("../views/User")
      },
      {
        path: 'person',
        name: '个人信息',
        component: ()=> import("../views/Person")
      },{
        path: 'controller',
        name: '环境信息模块',
        component:() =>  import("../views/module/Controll")
      },{
        path: 'mainframe',
        name: '专家信息库模块',
        component:() => import("../views/module/MainFrame")
      },{
        path: 'water',
        name: '图片识别模块',
        component:() => import("../views/module/WaterSystem")
      },{
        path: 'environment',
        name: '报警模块',
        component:() => import("../views/module/Environment")
      },{
        path: 'smoke',
        name: '烟风系统',
        component:() => import("../views/module/Smoke")
      },{
        path: 'energy',
        name: '节能系统',
        component:() => import("../views/module/Energy")
      },{
        path: 'feeding',
        name: '报警系统',
        component:() => import("../views/module/Feeding")
      }
    ]
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },{
    path: '/login',
    name: 'Login',
    component: () =>import('../views/Login.vue')
  },
  {
    path: '/register',
    name: 'Register',
    component: ()=> import("../views/Register")
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

//路由守卫
router.beforeEach((to, from, next)=>{
  //用localstorage存一下
  localStorage.setItem("currentPathName",to.name)//设置当前路由名称
  console.log(from)


  next()//放行
})

export default router
