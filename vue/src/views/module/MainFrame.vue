<template>
  <div>
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
      <el-table-column prop="expansionWaterTankLevel" label="病虫害种类" width="140" ></el-table-column>
      <el-table-column prop="expansionWaterTankHighLimit" label="主要特征" width="150" ></el-table-column>
      <el-table-column prop="expansionWaterTankLowLimit" label="主要发生时间" width="140" ></el-table-column>

      <el-table-column prop="hopperTemp" label="发生原因" width="140" ></el-table-column>

      <el-table-column prop="hopperHighLimit" label="防治措施" width="160" ></el-table-column>
      <el-table-column prop="hopperLowLimit" label="图片显示" width="250" >
        <template v-slot:default="scope">
          <el-image :src="'data:image/png;base64,'+scope.row.hopperLowLimit"></el-image>
        </template>
      </el-table-column>

   <!-- <el-table-column prop="hopperTempSet" label="料斗高温设定" width="120" ></el-table-column>


      <el-table-column prop="firepotTemp" label="炉膛温度" width="120" ></el-table-column>

      <el-table-column prop="firepotPres" label="炉膛压力" width="120"></el-table-column>

      <el-table-column prop="firepotHighTempSet" label="炉膛高温设定" width="120" ></el-table-column>

      <el-table-column prop="firepotPresHighSet" label="炉膛压力高设定" width="120"></el-table-column>

      <el-table-column prop="firepotTempHighSet" label="炉膛温度高设定" width="120" ></el-table-column>

      <el-table-column prop="exhaustSmokeTemperature" label="排烟温度" width="120" ></el-table-column>

      <el-table-column prop="smokeExhaustTemperatureHighSetting" label="排烟温度高设定" width="120" ></el-table-column>

      <el-table-column prop="supplyWaterTemp" label="供水温度" width="120"></el-table-column>

      <el-table-column prop="supplyWaterTempSet" label="供水温度高设定" width="120"></el-table-column>

      <el-table-column prop="supplyWaterPres" label="供水压力" width="120"></el-table-column>

      <el-table-column prop="supplyWaterPresSet" label="供水压力高设定" width="120"></el-table-column>

      <el-table-column prop="returnWaterTemp" label="回水温度" width="120"></el-table-column>

      <el-table-column prop="returnWaterTempSet" label="回水温度高设定" width="120"></el-table-column>

      <el-table-column prop="returnWaterPres" label="回水压力" width="120"></el-table-column>

      <el-table-column prop="returnWaterPresSet" label="回水压力高设定" width="120"></el-table-column>

      <el-table-column prop="furnaceOutletSmokeTemperature" label="炉膛出口烟温" width="120"></el-table-column>
-->
      <el-table-column label="操作" width="200">
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

    <el-dialog title="病害专家信息库模块" :visible.sync="dialogFormVisible" width="30%">
      <el-form :model="form" label-width="100px" size="small">
        <el-form-item label="病虫害种类" >
          <el-input v-model="form.expansionWaterTankLevel" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="主要特征" >
          <el-input v-model="form.expansionWaterTankHighLimit" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="主要发生时间" >
          <el-input v-model="form.expansionWaterTankLowLimit" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="发生原因" >
          <el-input v-model="form.hopperTemp" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="防止措施" >
          <el-input v-model="form.hopperHighLimit" autocomplete="off"></el-input>
        </el-form-item>
    <!--      <el-form-item label="图片显示" >
                <el-input v-model="form.hopperLowLimit" autocomplete="off"></el-input>
          </el-form-item>
            <el-form-item label="料斗高温设定" >
                <el-input v-model="form.hopperTempSet" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item label="炉膛温度" >
                <el-input v-model="form.firepotTemp" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="炉膛压力" >
                <el-input v-model="form.firepotPres" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item label="炉膛高温设定" >
                <el-input v-model="form.firepotHighTempSet" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="炉膛压力高设定" >
                <el-input v-model="form.firepotPresHighSet" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item label="炉膛温度高设定" >
                <el-input v-model="form.firepotTempHighSet" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item label="排烟温度" >
                <el-input v-model="form.exhaustSmokeTemperature" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item label="排烟温度高设定" >
                <el-input v-model="form.smokeExhaustTemperatureHighSetting" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item label="供水温度" >
                <el-input v-model="form.supplyWaterTemp" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="供水温度高设定" >
                <el-input v-model="form.supplyWaterTempSet" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="供水压力" >
                <el-input v-model="form.supplyWaterPres" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="供水压力高设定" >
                <el-input v-model="form.supplyWaterPresSet" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="回水温度" >
                <el-input v-model="form.returnWaterTemp" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="回水温度高设定" >
                <el-input v-model="form.returnWaterTempSet" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="回水压力" >
                <el-input v-model="form.returnWaterPres" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="回水压力高设定" >
                <el-input v-model="form.returnWaterPresSet" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="炉膛出口烟温" >
                <el-input v-model="form.furnaceOutletSmokeTemperature" autocomplete="off"></el-input>
              </el-form-item>-->
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
      headerBg: 'headerBg',
      imgurl:""
    }
  },
  created() {
    this.load()
  },
  methods:{
    load(){

      request.get("/Engine/page",{
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
      request.post("/Engine",this.form).then(res =>{
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
      request.delete("/Engine/"+id).then(res => {
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
      request.post("/Engine/del/batch",ids).then(res => {
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
  },
  // watch:{
  //   'form.hopperLowLimit':{
  //     handler(val){
  //       let blob = new Blob([val])
  //       let url = window.URL.createObjectURL(blob)
  //       console.log(url)
  //       this.imgurl = url
  //       // const blob = new Blob(stream, { type: 'image/jpg' })
  //       // const blobUrl = (window.URL || window.webkitURL).createObjectURL(blob)
  //       // this.$set('form','bloburl',blobUrl)
  //       // this.form.hopperLowLimit = blobUrl
  //       // console.log(this)
  //
  //     },
  //     immediate: true
  //   }
  // }
}
</script>

<style >
.headerBg{
  background: #eee!important;
}
</style>