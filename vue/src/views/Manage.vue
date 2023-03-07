<template>
<div style="height: 100%">
  <el-container style="height: 100%; ">

<!--  aside侧边栏  -->
    <el-aside :width="sideWidth+'px'" style="background-color: rgb(238, 241, 246);">
      <Aside :is-collapse="isCollapse" :logo-text-show="logoTextShow" style="height: 900px"></Aside>
<!--actice-text-color 高亮文本是黄色
    collpase-transition 菜单动画
 -->
<!--      <el-menu :default-openeds="['1', '3']" style="height: 100%;overflow-x: hidden "-->
<!--               background-color="rgb(48,65,86)"-->
<!--               text-color="#fff"-->
<!--               active-text-color="#ffd04b"-->
<!--               :collapse-transition="false"-->
<!--               :collapse="isCollapse"-->
<!--      >-->

<!--        <div style="height: 60px;line-height: 60px;text-align: center">-->
<!--           <img src="../assets/logo.png" alt="" style="width:20px;position: relative;top:5px;margin-right: 5px">-->
<!--           <b style="color: white" v-show="logoTextShow">云春后台管理系统</b>-->
<!--        </div>-->

<!--        <el-submenu index="1">-->
<!--          <template slot="title"><i class="el-icon-message"></i>-->
<!--            <span slot="title">导航一</span>-->

<!--          </template>-->
<!--          <el-menu-item-group>-->
<!--            <template slot="title">分组一</template>-->
<!--            <el-menu-item index="1-1">选项1</el-menu-item>-->
<!--            <el-menu-item index="1-2">选项2</el-menu-item>-->
<!--          </el-menu-item-group>-->
<!--          <el-menu-item-group title="分组2">-->
<!--            <el-menu-item index="1-3">选项3</el-menu-item>-->
<!--          </el-menu-item-group>-->
<!--          <el-submenu index="1-4">-->
<!--            <template slot="title">选项4</template>-->
<!--            <el-menu-item index="1-4-1">选项4-1</el-menu-item>-->
<!--          </el-submenu>-->
<!--        </el-submenu>-->
<!--        <el-submenu index="2">-->
<!--          <template slot="title"><i class="el-icon-menu"></i>-->
<!--            <span slot="title">导航二</span>-->
<!--          </template>-->
<!--          <el-menu-item-group>-->
<!--            <template slot="title">分组一</template>-->
<!--            <el-menu-item index="2-1">选项1</el-menu-item>-->
<!--            <el-menu-item index="2-2">选项2</el-menu-item>-->
<!--          </el-menu-item-group>-->
<!--          <el-menu-item-group title="分组2">-->
<!--            <el-menu-item index="2-3">选项3</el-menu-item>-->
<!--          </el-menu-item-group>-->
<!--          <el-submenu index="2-4">-->
<!--            <template slot="title">选项4</template>-->
<!--            <el-menu-item index="2-4-1">选项4-1</el-menu-item>-->
<!--          </el-submenu>-->
<!--        </el-submenu>-->
<!--        <el-submenu index="3">-->
<!--          <template slot="title"><i class="el-icon-setting"></i>-->
<!--            <span slot="title">导航三</span>-->
<!--          </template>-->
<!--          <el-menu-item-group>-->
<!--            <template slot="title">分组一</template>-->
<!--            <el-menu-item index="3-1">选项1</el-menu-item>-->
<!--            <el-menu-item index="3-2">选项2</el-menu-item>-->
<!--          </el-menu-item-group>-->
<!--          <el-menu-item-group title="分组2">-->
<!--            <el-menu-item index="3-3">选项3</el-menu-item>-->
<!--          </el-menu-item-group>-->
<!--          <el-submenu index="3-4">-->
<!--            <template slot="title">选项4</template>-->
<!--            <el-menu-item index="3-4-1">选项4-1</el-menu-item>-->
<!--          </el-submenu>-->
<!--        </el-submenu>-->
<!--      </el-menu>-->
    </el-aside>


    <el-container>

      <el-header style=" border-bottom: 1px solid #ccc; ">
        <Header :collapse-btn-class="collapseBtnClass" :collapse="collapse" ></Header>
<!--    菜单收缩的效果    -->
<!--        <div style="flex: 1; font-size: 18px">-->
<!--          <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>-->
<!--        </div>-->

<!--        <el-dropdown style="width: 70px;cursor: pointer" >-->
<!--          <span>王小虎</span><i class="el-icon-arrow-down" style="margin-left: 5px;"></i>-->
<!--          <el-dropdown-menu slot="dropdown">-->
<!--            <el-dropdown-item>个人信息</el-dropdown-item>-->
<!--            <el-dropdown-item>退出</el-dropdown-item>-->
<!--&lt;!&ndash;            <el-dropdown-item>删除</el-dropdown-item>&ndash;&gt;-->
<!--          </el-dropdown-menu>-->
<!--        </el-dropdown>-->
<!--        <span>王小虎</span>-->

<!--
el-icon-message 邮箱图标
el-icon-map-location 地址图标

-->
      </el-header>




      <el-main>
<!--   当前页面的子路由会在<router-view>中展示     //-->
        <router-view></router-view>

<!--        <div style="margin-bottom: 30px">-->
<!--          <el-breadcrumb separator="/">-->
<!--            <el-breadcrumb-item :to="{path: '/'}">首页</el-breadcrumb-item>-->
<!--            <el-breadcrumb-item>用户管理</el-breadcrumb-item>-->
<!--          </el-breadcrumb>-->
<!--        </div>-->

<!--        <div style="margin: 10px 0">-->
<!--          <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="username"></el-input>-->
<!--          <el-input style="width: 200px" placeholder="请输入邮箱" suffix-icon="el-icon-message" class="ml-5" v-model="email"></el-input>-->
<!--          <el-input style="width: 200px" placeholder="请输入地址" suffix-icon="el-icon-map-location" class="ml-5" v-model="address"></el-input>-->
<!--          <el-button class="ml-5" type="primary" @click="load">搜索</el-button>-->
<!--          <el-button  type="warning" @click="reset">重置</el-button>-->
<!--        </div>-->

<!--        <div style="margin: 10px 0">-->
<!--          <el-button type="primary" @click="handleAdd">新增<i class="el-icon-circle-plus-outline"></i></el-button>-->
<!--          <el-popconfirm-->
<!--              class="ml-5"-->
<!--              confirm-button-text='好的'-->
<!--              cancel-button-text='不用了'-->
<!--              icon="el-icon-info"-->
<!--              icon-color="red"-->
<!--              title="您确定要批量删除吗？"-->
<!--              @confirm="delBatch"-->
<!--          >-->
<!--          <el-button type="danger" slot="reference">批量删除<i class="el-icon-remove-outline"></i></el-button>-->
<!--          </el-popconfirm>-->
<!--          <el-button type="primary" class="ml-5">导入<i class="el-icon-bottom"></i></el-button>-->
<!--          <el-button type="primary" class="ml-5">导出<i class="el-icon-top"></i></el-button>-->
<!--        </div>-->

<!--        <el-table :data="tableData" border stripe :header-cell-class-name="headerBg" @selection-change="handleSelectionChange">-->

<!--          <el-table-column type="selection" width="55"></el-table-column>-->

<!--          <el-table-column prop="id" label="ID" width="140"></el-table-column>-->
<!--          <el-table-column prop="username" label="用户名" width="140"></el-table-column>-->


<!--          <el-table-column prop="nickname" label="昵称" width="120"></el-table-column>-->

<!--          <el-table-column prop="name" label="姓名" width="120"></el-table-column>-->

<!--          <el-table-column prop="email" label="邮箱" width="120"></el-table-column>-->

<!--          <el-table-column prop="phone" label="电话" width="120"></el-table-column>-->

<!--          <el-table-column prop="role" label="角色" width="120"></el-table-column>-->

<!--          <el-table-column prop="address" label="地址"></el-table-column>-->

<!--          <el-table-column label="操作">-->
<!--            <template slot-scope="scope">-->
<!--              <el-button type="success" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit"></i></el-button>-->
<!--              <el-popconfirm-->
<!--                  class="ml-5"-->
<!--                  confirm-button-text='好的'-->
<!--                  cancel-button-text='不用了'-->
<!--                  icon="el-icon-info"-->
<!--                  icon-color="red"-->
<!--                  title="您确定删除吗？"-->
<!--                  @confirm="del(scope.row.id)"-->
<!--              >-->

<!--              <el-button type="danger" slot="reference"  >删除<i class="el-icon-remove-outline"></i></el-button>-->
<!--              </el-popconfirm>-->
<!--            </template>-->
<!--          </el-table-column>-->
<!--        </el-table>-->

<!--        <div style="padding: 10px 0">-->
<!--&lt;!&ndash;      ：current-page:当前页码绑定-->
<!--            pageSize绑定动态   &ndash;&gt;-->
<!--          <el-pagination-->
<!--              @size-change="handleSizeChange"-->
<!--              @current-change="handleCurrentChange"-->
<!--              :current-page="pageNum"-->
<!--              :page-sizes="[2, 5, 10, 20]"-->
<!--              :page-size="pageSize"-->
<!--              layout="total, sizes, prev, pager, next, jumper"-->
<!--              :total="total">-->
<!--          </el-pagination>-->
<!--        </div>-->

<!--        <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width="30%">-->
<!--          <el-form :model="form" label-width="80px" size="small">-->
<!--            <el-form-item label="用户名" >-->
<!--              <el-input v-model="form.username" autocomplete="off"></el-input>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="姓名" >-->
<!--              <el-input v-model="form.name" autocomplete="off"></el-input>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="昵称" >-->
<!--              <el-input v-model="form.nickname" autocomplete="off"></el-input>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="邮箱" >-->
<!--              <el-input v-model="form.email" autocomplete="off"></el-input>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="电话" >-->
<!--              <el-input v-model="form.phone" autocomplete="off"></el-input>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="地址" >-->
<!--              <el-input v-model="form.address" autocomplete="off"></el-input>-->
<!--            </el-form-item>-->
<!--&lt;!&ndash;            <el-form-item label="活动区域"  >&ndash;&gt;-->
<!--&lt;!&ndash;              <el-select v-model="form.region" placeholder="请选择活动区域">&ndash;&gt;-->

<!--&lt;!&ndash;              </el-select>&ndash;&gt;-->
<!--&lt;!&ndash;            </el-form-item>&ndash;&gt;-->
<!--          </el-form>-->
<!--          <div slot="footer" class="dialog-footer">-->
<!--            <el-button @click="dialogFormVisible = false">取 消</el-button>-->
<!--            <el-button type="primary" @click="save">确 定</el-button>-->
<!--          </div>-->
<!--        </el-dialog>-->


      </el-main>
    </el-container>
  </el-container>
</div>
</template>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>

<script>
import request from "@/utils/request";

import Aside from "@/components/Aside";
import Header from "@/components/Header";

export default {
  data() {

    return {
      // tableData: [],
      // //数据总数
      // total: 0,
      // //这里是默认的页数和页面信息条数
      // pageNum:1,
      // pageSize:2,
      // //绑定username 默认空字符串
      // username:"",
      // //绑定email默认空字符串
      // email:"",
      // //绑定address默认空字符串
      // address:"",
      // //定义一个form对象，专门存放我们的信息对象
      // form: {},
      // //默认这个框不展示
      // dialogFormVisible:false,
      // //给个变量存放数组，方便批量删除
      // multipleSelection: [],


      collapseBtnClass: 'el-icon-s-fold',
      //默认false代表是展开的，true代表折叠，通过点击按钮变化
      isCollapse: false,
      sideWidth: 200,
      logoTextShow:true,
      headerBg: 'headerBg'
    }
  },
  created() {
   // this.load()
  },
  components: {
    Aside,
    Header
  },

  methods:{
    collapse(){ //点击收缩按钮触发
      this.isCollapse = !this.isCollapse;
      //如果是true的话
      if(this.isCollapse){ //收缩
        this.sideWidth = 64;
        this.collapseBtnClass = 'el-icon-s-unfold';
        this.logoTextShow= false;
      }else {//展开
        this.sideWidth = 200;
        this.logoTextShow= true;
        this.collapseBtnClass= 'el-icon-s-fold'
      }
    },
    load(){

      request.get("/user/page",{
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          username: this.username,
          email: this.email,
          address: this.address
        }

          }).then(res => {
        console.log(res)
        this.tableData=res.records
        this.total=res.total
      })

      //请求分页查询数据

    },
    reset(){
         this.username = ""
         this.email= ""
         this.address= ""
         this.load()
    },
    handleSizeChange(pageSize){
      console.log(pageSize);
      this.pageSize=pageSize;
      this.load();
    },
    handleCurrentChange(pageNum){
      console.log(pageNum);
      this.pageNum=pageNum;
      this.load();
    },
    handleAdd(){
      this.dialogFormVisible =true
      //可能你之前已经填写过一次信息，所以点击的时候需要置空
      this.form={}
    },
    //save保存数据
    save(){
      //res就是我们后台返回的结果
      request.post("/user",this.form).then(res =>{
        //调用后台的controller里面的save方法，返回的是ture or false
        //默认true
        if(res){
          this.$message.success("保存成功")
          this.dialogFormVisible = false
          this.load()
        }else {
          this.$message.error("保存失败")
        }
      })
    },
    //编辑
    handleEdit(row){
      this.form = JSON.parse(JSON.stringify(row))  //可以解决编辑未确认就改变的问题//把我们的数据赋予给form
      // 下面要打开弹窗
      this.dialogFormVisible=true

    },
    //删除
    del(id){
      request.delete("/user/"+id).then(res => {
        //调用后台的controller里面的delete方法，返回的是ture or false
        //默认true
        if(res){
          this.$message.success("删除成功")
          this.load()
        }else {
          this.$message.error("删除失败")
        }

      })
    },
    //批量选择事件
    handleSelectionChange(val){
      console.log(val)
      this.multipleSelection=val

    },
    //批量删除事件
    delBatch(){
      let ids = this.multipleSelection.map(v => v.id) //[{},{},{}]=>     [1,2,3] 对象数组变成一个ID数组
      request.post("/user/del/batch",ids).then(res => {
        //调用后台的controller里面的delete方法，返回的是ture or false
        //默认true
        if(res){
          this.$message.success("批量删除成功")
          this.load()
        }else {
          this.$message.error("批量删除失败")
        }

      })
    }

  }



};
</script>

<style>
.headerBg{
  background: #eee!important;
}
</style>
