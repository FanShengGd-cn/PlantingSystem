<template>
  <div class="wrapper">
    <div style="margin: 100px auto; background-color: #fff; width: 350px; height: 400px; padding: 20px; border-radius: 10px">
      <div style="margin: 20px 0; text-align: center; font-size: 24px"><b>注册</b></div>
      <el-form :model="user"  :rules="rules" ref="userForm">
        <el-form-item prop="username">
          <el-input placeholder="请输入账号" size="medium" style="margin: 5px 0" prefix-icon="el-icon-user" v-model="user.username"></el-input>
        </el-form-item>

        <el-form-item prop="password">
          <el-input placeholder="请输入密码" size="medium" style="margin: 5px 0" prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
        </el-form-item>

        <el-form-item prop="confirmPassword">
          <el-input placeholder="请确认密码" size="medium" style="margin: 5px 0" prefix-icon="el-icon-lock" show-password v-model="user.confirmPassword"></el-input>
        </el-form-item>

        <div style="margin: 5px 0; text-align: right">
          <el-button type="warning" size="small" autocomplete="off"  >返回登录</el-button>
          <el-button type="primary" size="small" autocomplete="off"  @click="login">注册</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>


import request from "@/utils/request";

export default {
  name: "Login",
  data() {
    return {
      user: {},
      rules: {
         username: [
             //required意味着填写的数据是必须的，message是输入用户名的信息，trigger是鼠标失去焦点后的操作
           {required: true,message: '请输入用户名', trigger: 'blur'},
           {min: 3,max: 15,message: '长度在3到15个字符',trigger: 'blur'}
         ],
        password: [
          {required: true,message: '请输入密码', trigger: 'blur'},
          {min: 3,max: 10,message: '长度在3到10个字符',trigger: 'blur'}
        ],
        confirmPassword: [
          {required: true,message: '请再次输入密码', trigger: 'blur'},
          {min: 3,max: 10,message: '长度在3到10个字符',trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    login(){
      //validate校验
      this.$refs['userForm'].validate((valid)=>{
        //valid是回调参数，如果是true代表合法，false代表不合法

        if(valid){//表单校验合法
          if(this.user.password!==this.user.confirmPassword){
            this.$message.error("两次密码输入不一致")
            //return false 直接跳出不会再请求了，不跳出的话会继续执行
            return false;
          }
          request.post("/register",this.user).then(res =>{
            if(res.code ==='200'){
              this.$message.success("注册成功")
              this.$router.push("/login")
            }else {
              this.$message.error(res.msg)

            }
          })
        }
      });
    }
  }
}
</script>

<style>
.wrapper {
  height: 100vh;
  background-image: linear-gradient(to bottom right, #FC466B, #3F5EFB);
  overflow: hidden;
}
</style>
