<template>
   <el-card style="width: 500px; padding: 20px">
     <el-form :model="form" label-width="80px" size="small">
       <el-form-item label="用户名" >
         <el-input v-model="form.username" autocomplete="off"></el-input>
       </el-form-item>
       <el-form-item label="姓名" >
         <el-input v-model="form.name" autocomplete="off"></el-input>
       </el-form-item>
       <el-form-item label="昵称" >
         <el-input v-model="form.nickname" autocomplete="off"></el-input>
       </el-form-item>
       <el-form-item label="邮箱" >
         <el-input v-model="form.email" autocomplete="off"></el-input>
       </el-form-item>
       <el-form-item label="电话" >
         <el-input v-model="form.phone" autocomplete="off"></el-input>
       </el-form-item>
       <el-form-item label="地址" >
         <el-input v-model="form.address" autocomplete="off"></el-input>
       </el-form-item>
       <el-form-item>
           <el-button type="primary" @click="save">保存</el-button>
       </el-form-item>

     </el-form>

   </el-card>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Person",
  data(){
    return{
      form: {},
      //当前用户的用户信息
      //我们在登录的时候，写过存储信息的方法，然后在这里取出调用
      user: localStorage.getItem("user")?JSON.parse(localStorage.getItem("user")):{}
    }
  },
  created() {
    request.get("/user/username/"+this.user.username).then(res =>{
     if(res.code==='200'){
       this.form = res.data
     }
    })
  },
  methods:{
    //save保存数据
    save(){
      //res就是我们后台返回的结果
      request.post("/user",this.form).then(res =>{
        //调用后台的controller里面的save方法，返回的是ture or false
        //默认true
        if(res){
          this.$message.success("保存成功")
        }else {
          this.$message.error("保存失败")
        }
      })
    }
  }
}
</script>

<style scoped>

</style>