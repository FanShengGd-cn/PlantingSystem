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
      <el-table-column prop="inducedDraftFanStartManually" label="温度（℃）" width="140" ></el-table-column>


      <el-table-column prop="inducedDraftFanStartAutomatically" label="风速（m/s）" width="120" ></el-table-column>

      <el-table-column prop="inducedDraftFanRun" label="二氧化碳（ppm）" width="120" ></el-table-column>

      <el-table-column prop="inducedDraftFanFail" label="空气湿度（%）" width="120" ></el-table-column>

      <el-table-column prop="inducedDraftFanMotorPower" label="土壤湿度（%）" width="120" ></el-table-column>

      <el-table-column prop="blowerMotorPower" label="光照度（LUM）" width="120" ></el-table-column>

      <el-table-column prop="secondaryBlowerPower" label="降雨量（mm）" width="120"></el-table-column>

      <el-table-column prop="grateReducerStartManually" label="日照时长（h）" width="120"></el-table-column>

      <!--<el-table-column prop="grateReducerStartAutomatically" label="炉排减速机自动启动" width="120"></el-table-column>

      <el-table-column prop="grateReducerStartStopManually" label="炉排减速机手动启停" width="120"></el-table-column>

      <el-table-column prop="grateReducerStartStopAutomatically" label="炉排减速机自动启停" width="120"></el-table-column>

      <el-table-column prop="grateReducerFail" label="炉排减速机故障" width="120"></el-table-column>

      <el-table-column prop="grateReducerRun" label="炉排减速机运行" width="120"></el-table-column>

      <el-table-column prop="grateReducerPower" label="炉排减速机功率" width="120"></el-table-column>

      <el-table-column prop="controllerStartManually" label="控料器手动启动" width="120"></el-table-column>

      <el-table-column prop="controllerStartAutomatically" label="控料器自动启动" width="120"></el-table-column>

      <el-table-column prop="controllerStart" label="控料器启动" width="120"></el-table-column>

      <el-table-column prop="controllerRun" label="控料器运行" width="120"></el-table-column>

      <el-table-column prop="controllerMotorPower" label="控料器电机功率" width="120"></el-table-column>

      <el-table-column prop="controllerFail" label="控料器故障" width="120"></el-table-column>

      <el-table-column prop="multibucketElevatorPower" label="多斗提升机电机功率" width="120"></el-table-column>

      <el-table-column prop="dischargeValveMotorPower" label="卸料阀电机功率" width="120"></el-table-column>

      <el-table-column prop="ztypeConveyorMotorPower" label="Z型输送机电机功率" width="120"></el-table-column>

      <el-table-column prop="slagRemoverStartStopManually" label="除渣机手动启停" width="120"></el-table-column>

      <el-table-column prop="slagRemoverStartStopAutomatically" label="除渣机自动启停" width="120"></el-table-column>

      <el-table-column prop="slagRemoverRun" label="除渣机运行" width="120"></el-table-column>

      <el-table-column prop="slagRemoverFail" label="除渣机故障" width="120"></el-table-column>

      <el-table-column prop="slagRemoverMotorPower" label="除渣机电机功率" width="120"></el-table-column>

      <el-table-column prop="gasStorageMotorPowerDevice" label="储气装置电机功率" width="120"></el-table-column>

      <el-table-column prop="circulatingPump1StartStopManually" label="循环泵1手动启停" width="120"></el-table-column>

      <el-table-column prop="circulatingPump1StartStopAutomatically" label="循环泵1自动启停" width="120"></el-table-column>

      <el-table-column prop="circulatingPump1Run" label="循环泵1运行" width="120"></el-table-column>

      <el-table-column prop="circulatingPump1Fail" label="循环泵1故障" width="120"></el-table-column>

      <el-table-column prop="circulatingPump1MotorPower" label="循环泵1电机功率" width="120"></el-table-column>

      <el-table-column prop="circulatingPump2StartStopManually" label="循环泵2手动启停" width="120"></el-table-column>

      <el-table-column prop="circulatingPump2StartStopAutomatically" label="循环泵2自动启停" width="120"></el-table-column>

      <el-table-column prop="circulatingPump2Run" label="循环泵2运行" width="120"></el-table-column>

      <el-table-column prop="circulatingPump2Fail" label="循环泵2故障" width="120"></el-table-column>

      <el-table-column prop="circulatingPump2MotorPower" label="循环泵2电机功率" width="120"></el-table-column>

      <el-table-column prop="regulatorPumpMotorPower" label="循稳压泵电机功率" width="120"></el-table-column>

      <el-table-column prop="denitrationSprayPumpMotorPower" label="脱硝喷淋泵电机功率" width="120"></el-table-column>

      <el-table-column prop="denitrationMixerMotorPower" label="脱硝搅拌机电机功率" width="120"></el-table-column>

      <el-table-column prop="airSourceConsumptionPower" label="空气源用电功率" width="120"></el-table-column>

      <el-table-column prop="airSourceCirculatingPump1MotorPower" label="空气源循环泵1电机功率" width="120"></el-table-column>

      <el-table-column prop="airSourceCirculatingPump2MotorPower" label="空气源循环泵2电机功率" width="120"></el-table-column>

      <el-table-column prop="flueGasRecirculationFan" label="烟气再循环风机" width="120"></el-table-column>-->


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

    <el-dialog title="环境模块信息" :visible.sync="dialogFormVisible" width="30%">
      <el-form :model="form" label-width="80px" size="small">
        <el-form-item label="温度（℃）" >
          <el-input v-model="form.inducedDraftFanStartManually" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="风速（m/s）" >
          <el-input v-model="form.inducedDraftFanStartAutomatically" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="二氧化碳（ppm）" >
          <el-input v-model="form.inducedDraftFanRun" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="空气湿度（%）" >
          <el-input v-model="form.inducedDraftFanFail" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="土壤湿度（%）" >
          <el-input v-model="form.inducedDraftFanMotorPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="光照度（LUM）" >
          <el-input v-model="form.blowerMotorPower" autocomplete="off"></el-input>
        </el-form-item>
       <el-form-item label="降雨量（mm）" >
          <el-input v-model="form.secondaryBlowerPower" autocomplete="off"></el-input>
       </el-form-item>
          <el-form-item label="日照时长（h）" >
          <el-input v-model="form.grateReducerStartManually" autocomplete="off"></el-input>
        </el-form-item>
        <!--<el-form-item label="炉排减速机自动启动" >
          <el-input v-model="form.grateReducerStartAutomatically" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="炉排减速机手动启停" >
          <el-input v-model="form.grateReducerStartAutomatically" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="炉排减速机自动启动" >
          <el-input v-model="form.grateReducerStartStopManually" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="炉排减速机自动启停" >
          <el-input v-model="form.grateReducerStartStopAutomatically" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="炉排减速机故障" >
          <el-input v-model="form.grateReducerFail" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="炉排减速机运行" >
          <el-input v-model="form.grateReducerRun" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="炉排减速机功率" >
          <el-input v-model="form.grateReducerPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="控料器手动启动" >
          <el-input v-model="form.controllerStartManually" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="控料器自动启动" >
          <el-input v-model="form.controllerStartAutomatically" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="控料器启动" >
          <el-input v-model="form.controllerStart" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="控料器运行" >
          <el-input v-model="form.controllerRun" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="控料器电机功率" >
          <el-input v-model="form.controllerMotorPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="控料器故障" >
          <el-input v-model="form.controllerFail" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="多斗提升机电机功率" >
          <el-input v-model="form.multibucketElevatorPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="卸料阀电机功率" >
          <el-input v-model="form.dischargeValveMotorPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Z型输送机电机功率" >
          <el-input v-model="form.ztypeConveyorMotorPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="除渣机手动启停" >
          <el-input v-model="form.slagRemoverStartStopManually" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="除渣机自动启停" >
          <el-input v-model="form.slagRemoverStartStopAutomatically" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="除渣机运行" >
          <el-input v-model="form.slagRemoverRun" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="除渣机故障" >
          <el-input v-model="form.slagRemoverFail" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="除渣机电机功率" >
          <el-input v-model="form.slagRemoverMotorPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="储气装置电机功率" >
          <el-input v-model="form.gasStorageMotorPowerDevice" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="循环泵1手动启停" >
          <el-input v-model="form.circulatingPump1StartStopManually" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="循环泵1自动启停" >
          <el-input v-model="form.circulatingPump1StartStopAutomatically" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="循环泵1运行" >
          <el-input v-model="form.circulatingPump1Run" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="循环泵1故障" >
          <el-input v-model="form.circulatingPump1Fail" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="循环泵1电机功率" >
          <el-input v-model="form.circulatingPump1MotorPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="循环泵2手动启停" >
          <el-input v-model="form.circulatingPump2StartStopManually" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="循环泵2自动启停" >
          <el-input v-model="form.irculatingPump2StartStopAutomatically" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="循环泵2运行" >
          <el-input v-model="form.circulatingPump2Run" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="循环泵2故障" >
          <el-input v-model="form.circulatingPump2Fail" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="循环泵2电机功率" >
          <el-input v-model="form.circulatingPump2MotorPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="稳压泵电机功率" >
          <el-input v-model="form.regulatorPumpMotorPowe" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="脱硝喷淋泵电机功率" >
          <el-input v-model="form.denitrationSprayPumpMotorPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="脱硝搅拌机电机功率" >
          <el-input v-model="form.denitrationMixerMotorPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="空气源用电功率" >
          <el-input v-model="form.airSourceConsumptionPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="空气源循环泵1电机功率" >
          <el-input v-model="form.airSourceCirculatingPump1MotorPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="空气源循环泵2电机功率" >
          <el-input v-model="form.airSourceCirculatingPump2MotorPower" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="烟气再循环风机" >
          <el-input v-model="form.flueGasRecirculationFan" autocomplete="off"></el-input>
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

      request.get("/control/page",{
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
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
      request.post("/control",this.form).then(res =>{
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
      request.delete("/control/"+id).then(res => {
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
      request.post("/control/del/batch",ids).then(res => {
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