<template>
<div style="font-size: 12px;line-height: 60px;display: flex;">

  <div style="flex: 1; font-size: 18px">
    <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>


      <el-breadcrumb separator="/" style="display: inline-block; margin-left: 10px ">
        <el-breadcrumb-item :to="{path: '/'}">首页</el-breadcrumb-item>
        <el-breadcrumb-item>{{currentPathName}}</el-breadcrumb-item>
      </el-breadcrumb>


  </div>

  <el-dropdown style="width: 150px;cursor: pointer" >
    <div style="display: inline-block">
      <span>{{user.nickname}}</span><i class="el-icon-arrow-down"  style="margin-left: 5px;"></i>
    </div>

    <el-dropdown-menu slot="dropdown" style="width: 100px; text-align: center">
      <el-dropdown-item style="font-size: 14px;padding: 5px 0">
        <router-link to="person">个人信息</router-link>
      </el-dropdown-item>
      <el-dropdown-item style="font-size: 14px;padding: 5px 0">
        <span  style="text-decoration: none" @click="logout">退出</span>
      </el-dropdown-item>
      <!--            <el-dropdown-item>删除</el-dropdown-item>-->
    </el-dropdown-menu>
  </el-dropdown>
</div>
</template>

<script>
export default {
  name: "Header",
  props: {
    collapseBtnClass: String,
    //这个collapse的类型应该填：Function 因为组件期望的是一个函数对象 而不是Boolean对象
    collapse: Function
  },
  created() {
    this.currentPathName = localStorage.getItem("currentPathName")
  },
  watch:{//百度搜索的，监听路由变化
    '$route': function (){
      this.currentPathName = localStorage.getItem("currentPathName") //取出route里面设置的路由信息
    }

  },
  data(){
    return{
      currentPathName: '',
      //把字符串解析成为对象才可以调用
      user: localStorage.getItem("user")?JSON.parse(localStorage.getItem("user")):{}
    }
  },
  methods: {
    logout() {
        this.$router.push("/login")
        localStorage.removeItem("user")
        this.$message.success("退出成功")
    }
  }

}
</script>

<style scoped>

</style>