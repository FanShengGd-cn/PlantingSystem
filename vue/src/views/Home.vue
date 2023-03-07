<template>
<div>
  <div id = "main" style="width: 500px; height: 400px" ></div>
</div>
</template>

<script>
import * as echarts from 'echarts';
import request from "@/utils/request";

export default {
  name: "Home",
  data() {
    return {
      arr: [],//横坐标数组
      inducedDraftFanMotorPower: [] //引风机电机功率
    }
  },
  mounted() { //页面元素渲染之后再触发


    var chartDom = document.getElementById('main');
    var myChart = echarts.init(chartDom);
    var option = {
      xAxis: {
        type: 'category',
        data: []
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: [],
          type: 'line'
        },
        {
          data: [],
          type: 'bar'
        }

      ]
    };
    request.get("/echarts/data").then(res =>{
      //请求完数据，将请求结束的数据传递给上面的XY轴坐标
      let arr = [];
      let inducedDraftFanMotorPower = [];
      for (let i = 0; i <res.data.length ; i++) {
          this.arr[i] = res.data[i].id;
      }
      for (let i = 0; i <res.data.length; i++) {
          this.inducedDraftFanMotorPower[i] = res.data[i].inducedDraftFanMotorPower
      }
      arr = this.arr;
      inducedDraftFanMotorPower =this.inducedDraftFanMotorPower;

      option.xAxis.data = arr;
      option.series[0].data =inducedDraftFanMotorPower ;
      option.series[1].data = inducedDraftFanMotorPower;
      //set必须要在option准备完毕之后进行
      myChart.setOption(option);
    })


  }
}
</script>

<style scoped>

</style>