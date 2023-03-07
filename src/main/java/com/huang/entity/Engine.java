package com.huang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.sql.Blob;

@Data
@TableName(value = "mainenginemodule")
public class Engine {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //膨胀水箱液位  病虫害种类
    private String expansionWaterTankLevel;
    //膨胀水箱高限位   主要特征
    private String expansionWaterTankHighLimit;
    //膨胀水箱低限位   主要发生时间
    private String expansionWaterTankLowLimit;
    //料斗温度   主要原因
    private String hopperTemp;
    //料斗高限位   防止措施
    private String hopperHighLimit;
    //料斗低限位   图片显示
    private byte[] hopperLowLimit;
    //料斗高温设定
   // private float hopperTempSet;
    //炉膛温度
  //  private float firepotTemp;
    //炉膛压力
  //  private float firepotPres;
    //炉膛高温设定
  //  private float firepotHighTempSet;
    //炉膛压力高设定
  //  private float firepotPresHighSet;
    //炉膛温度高设定
  //  private float firepotTempHighSet;
    //排烟温度
 //   private float exhaustSmokeTemperature;
    //排烟温度高设定
  //  private float smokeExhaustTemperatureHighSetting;
    //供水温度
 //   private float supplyWaterTemp;
    //供水温度高设定
  //  private float supplyWaterTempSet;
    //供水压力
 //   private float supplyWaterPres;
    //供水压力高设定
  //  private float supplyWaterPresSet;
    //回水温度
 //   private float returnWaterTemp;
    //回水温度高设定
  //  private float returnWaterTempSet;
    //回水压力
 //   private float returnWaterPres;
    //回水压力高设定
 //   private float returnWaterPresSet;
    //炉膛出口烟温
 //   private float furnaceOutletSmokeTemperature;

}
