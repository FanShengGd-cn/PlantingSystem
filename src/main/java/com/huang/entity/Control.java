package com.huang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "controlmodule")
public class Control {

    @TableId(type = IdType.AUTO)
    private Integer id;
    //引风机手动启动   温度
    private String inducedDraftFanStartManually;

    //引风机自动启动   风速
    private String inducedDraftFanStartAutomatically;

    //引风机运行     二氧化碳
    private String inducedDraftFanRun;

    //引风机故障     空气湿度
    private String inducedDraftFanFail;

    //引风机电机功率   土壤湿度
    private String inducedDraftFanMotorPower;

    //鼓风机电机功率   光照度
    private String blowerMotorPower;

    //二次鼓风机功率    降雨量
    private float secondaryBlowerPower;

    //炉排减速机手动启动   日照时长
    private int  grateReducerStartManually;

    //炉排减速机自动启动
 //   private int grateReducerStartAutomatically;

    //炉排减速机手动启停
 //   private int grateReducerStartStopManually;

    //炉排减速机自动启停
  //  private int grateReducerStartStopAutomatically;

    //炉排减速机故障
  //  private int grateReducerFail;

    //炉排减速机运行
  //  private int grateReducerRun;

    //炉排减速机功率
 //   private float grateReducerPower;

    //控料器手动启动
  //  private int  controllerStartManually;

    //控料器自动启动
 //   private int  controllerStartAutomatically;

    //控料器启动
  //  private int  controllerStart;

    //控料器运行
 //   private int controllerRun;

    //控料器电机功率
  //  private float controllerMotorPower;

    //控料器故障
  //  private int controllerFail;

    //多斗提升机电机功率
  //  private float multibucketElevatorPower;

    //卸料阀电机功率
 //   private float dischargeValveMotorPower;

    //Z型输送机电机功率
 //   private float zTypeConveyorMotorPower;

    //除渣机手动启停
  //  private int slagRemoverStartStopManually;

    //除渣机自动启停
 //   private int  slagRemoverStartStopAutomatically;

    //除渣机运行
 //   private int slagRemoverRun;

    //除渣机故障
  //  private int slagRemoverFail;

    //除渣机电机功率
   // private float slagRemoverMotorPower;

    //储气装置电机功率
  //  private float gasStorageMotorPowerDevice;

    //循环泵1手动启停
 //   private int circulatingPump1StartStopManually;

    //循环泵1自动启停
 //   private int circulatingPump1StartStopAutomatically;

    //循环泵1运行
 //   private int circulatingPump1Run;

    //循环泵1故障
  //  private int circulatingPump1Fail;

    //循环泵1电机功率
  //  private float circulatingPump1MotorPower;

    //循环泵2手动启停
 //   private int circulatingPump2StartStopManually;

    //循环泵2自动启停
  //  private int circulatingPump2StartStopAutomatically;

    //循环泵2运行
 //   private int  circulatingPump2Run;

    //循环泵2故障
//    private int circulatingPump2Fail;

    //循环泵2电机功率
  //  private float circulatingPump2MotorPower;

    //稳压泵电机功率
//    private float regulatorPumpMotorPower;

    //脱硝喷淋泵电机功率
 //   private float denitrationSprayPumpMotorPower;

    //脱硝搅拌机电机功率
  //  private float denitrationMixerMotorPower;

    //空气源用电功率
  //  private float airSourceConsumptionPower;

    //空气源循环泵1电机功率
 //   private float airSourceCirculatingPump1MotorPower;

    //空气源循环泵2电机功率
 //   private float airSourceCirculatingPump2MotorPower;

    //烟气再循环风机
  //  private float flueGasRecirculationFan;






}

