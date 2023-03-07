package com.huang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "water_system_module")
public class Water {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //软化水箱液位
    private float softWaterTankLevel;
    //软化水箱高限位
    private float softWaterTankHighLimit;
    //软化水箱低限位
    private float softWaterTankLowLimit;
    //补水泵启动
    private int refillPumpStart;
    //补水泵手动启动
    private int refillPumpStartManually;
    //补水泵自动启动
    private int refillPumpStartAutomatically;
    //补水泵运行
    private int refillPumpRun;
    //补水泵故障
    private int refillPumpFail;
    //分水器供水温度
    private float waterDividerSupplywaterTemperature;
    //分水器供水温度高设定
    private float waterDividerSupplywaterHighTemperatureSetting;
    //分水器供水压力高设定
    private float waterDividerSupplywaterHighPressureSetting;
    //集水器回水温度
    private float waterCollectorBackwaterTemperature;
    //集水器回水温度高设定
    private float waterCollectorBackwaterHighTemperatureSetting;
    //集水器回水压力
    private float waterCollectorBackwaterPressure;
    //集水器回水压力高设定
    private float waterCollectorBackwaterHighPressureSetting;
    //泄压阀启动
    private int pressureReliefValveStart;
    //泄压阀手动启动
    private int pressureReliefValveStartManually;
    //泄压阀自动启动
    private int pressureReliefValveStartAutomatically;
    //泄压阀运行
    private int pressureReliefValveRun;







}
