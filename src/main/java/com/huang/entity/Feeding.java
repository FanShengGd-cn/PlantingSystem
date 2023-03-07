package com.huang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "loading_system_module")
public class Feeding {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //上料电机启动
    private int feedingMotorStart;
    //上料机运行
    private int feedingMachineRun;
    //上料机故障
    private int feedingMachineFail;
    //上料机手动启动
    private int feedingMachineStartManually;
    //上料机自动启动
    private int feedingMachineStartAutomatically;
}
