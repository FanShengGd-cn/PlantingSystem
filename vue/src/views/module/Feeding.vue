<template>
  <div>
    <!--  <div style="margin-bottom: 30px">-->
    <!--    <el-breadcrumb separator="/">-->
    <!--      <el-breadcrumb-item :to="{path: '/'}">首页</el-breadcrumb-item>-->
    <!--      <el-breadcrumb-item>用户管理</el-breadcrumb-item>-->
    <!--    </el-breadcrumb>-->
    <!--  </div>-->

<!--    <div style="margin: 10px 0">-->
<!--      <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="username"></el-input>-->
<!--      <el-input style="width: 200px" placeholder="请输入邮箱" suffix-icon="el-icon-message" class="ml-5" v-model="email"></el-input>-->
<!--      <el-input style="width: 200px" placeholder="请输入地址" suffix-icon="el-icon-map-location" class="ml-5" v-model="address"></el-input>-->
<!--      <el-button class="ml-5" type="primary" @click="load">搜索</el-button>-->
<!--      <el-button  type="warning" @click="reset">重置</el-button>-->
<!--    </div>-->

    <div style="margin: 10px 0">
      <el-button type="primary" @click="handleAdd">新增<i class="el-icon-circle-plus-outline"></i></el-button>
      <el-popconfirm
          class="ml-5"
          confirm-button-text='好的'
          cancel-button-text='不用了'
          icon="el-icon-info"
          icon-color="red"
          title="您确定要批量删除吗？"
          @confirm="delBatch"
      >
        <el-button type="danger" slot="reference">批量删除<i class="el-icon-remove-outline"></i></el-button>
      </el-popconfirm>
      <el-button type="primary" class="ml-5">导入<i class="el-icon-bottom"></i></el-button>
      <el-button type="primary" class="ml-5">导出<i class="el-icon-top"></i></el-button>
    </div>

    <el-table :data="tableData" border stripe :header-cell-class-name="headerBg" @selection-change="handleSelectionChange" >

      <el-table-column type="selection" width="55px"></el-table-column>

      <el-table-column prop="id" label="ID" width="140" ></el-table-column>
      <el-table-column prop="feedingMotorStart" label="上料电机启动" width="140" ></el-table-column>

      <el-table-column prop="feedingMachineRun" label="上料机运行" width="120" ></el-table-column>

      <el-table-column prop="feedingMachineFail" label="上料机故障" width="120" ></el-table-column>

      <el-table-column prop="feedingMachineStartManually" label="上料机手动启动" width="120" ></el-table-column>

      <el-table-column prop="feedingMachineStartAutomatically" label="上料机自动启动" width="120" ></el-table-column>



      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="success" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit"></i></el-button>
          <el-popconfirm
              class="ml-5"
              confirm-button-text='好的'
              cancel-button-text='不用了'
              icon="el-icon-info"
              icon-color="red"
              title="您确定删除吗？"
              @confirm="del(scope.row.id)"
          >

            <el-button type="danger" slot="reference"  >删除<i class="el-icon-remove-outline"></i></el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <div style="padding: 10px 0">
      <!--      ：current-page:当前页码绑定
                  pageSize绑定动态   -->
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[2, 5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>

    <el-dialog title="上料机" :visible.sync="dialogFormVisible" width="30%">
      <el-form :model="form" label-width="80px" size="small">
        <el-form-item label="上料电机启动" >
          <el-input v-model="form.feedingMotorStart" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="上料机运行" >
          <el-input v-model="form.feedingMachineRun" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="上料机故障" >
          <el-input v-model="form.feedingMachineFail" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="上料机手动启动" >
          <el-input v-model="form.feedingMachineStartManually" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="上料机自动启动" >
          <el-input v-model="form.feedingMachineStartAutomatically" autocomplete="off"></el-input>
        </el-form-item>

        <!--            <el-form-item label="活动区域"  >-->
        <!--              <el-select v-model="form.region" placeholder="请选择活动区域">-->

        <!--              </el-select>-->
        <!--            </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "User",
  data(){
    return{
      tableData: [],
      //数据总数
      total: 0,
      //这里是默认的页数和页面信息条数
      pageNum:1,
      pageSize:2,
      //绑定username 默认空字符串
      username:"",
      //绑定email默认空字符串
      email:"",
      //绑定address默认空字符串
      address:"",
      //定义一个form对象，专门存放我们的信息对象
      form: {},
      //默认这个框不展示
      dialogFormVisible:false,
      //给个变量存放数组，方便批量删除
      multipleSelection: [],
      headerBg: 'headerBg'
    }
  },
  created() {
    this.load()
  },
  methods:{
    load(){

      request.get("/feeding/page",{
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
      request.post("/feeding",this.form).then(res =>{
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
      request.delete("/feeding/"+id).then(res => {
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
      request.post("/feeding/del/batch",ids).then(res => {
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
}
</script>

<style >
.headerBg{
  background: #eee!important;
}
</style>