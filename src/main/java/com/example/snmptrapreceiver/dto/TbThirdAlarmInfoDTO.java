package com.example.snmptrapreceiver.dto;


import java.io.Serializable;
import java.util.Date;


/**
* <p>Title: TbThirdAlarmInfoDTO</p>
* <p>Description:  </p>
* <p>Copyright: Copyright (c) 2018</p>
* <p>Company: SI-TECH </p>
* @author baigh
* @version 1.0
* @createtime 2020-11-16 16:24:54
*
*/
public class TbThirdAlarmInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public TbThirdAlarmInfoDTO() {

    }

    public TbThirdAlarmInfoDTO(String id, String province, String city, Integer cloudType, String pool, String dataCenter, String deviceId, String deviceIp, String deviceType, String deviceName, String applicationSystem, String alarmId, String monitorMetrics, String alarmContent, Integer alarmLevel, Integer restoreStatus, Integer isTimeOut, Integer monitorType, String dealer, Date generantTime, Date restoreTime, String alarmLongTime, Date createTime, Date updateTime, String remark, int alarmNum, Date lastGenerantTime, String serverroom, String manufacturer, String alarmTitle) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.cloudType = cloudType;
        this.pool = pool;
        this.dataCenter = dataCenter;
        this.deviceId = deviceId;
        this.deviceIp = deviceIp;
        this.deviceType = deviceType;
        this.deviceName = deviceName;
        this.applicationSystem = applicationSystem;
        this.alarmId = alarmId;
        this.monitorMetrics = monitorMetrics;
        this.alarmContent = alarmContent;
        this.alarmLevel = alarmLevel;
        this.restoreStatus = restoreStatus;
        this.isTimeOut = isTimeOut;
        this.monitorType = monitorType;
        this.dealer = dealer;
        this.generantTime = generantTime;
        this.restoreTime = restoreTime;
        this.alarmLongTime = alarmLongTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.remark = remark;
        this.alarmNum = alarmNum;
        this.lastGenerantTime = lastGenerantTime;
        this.serverroom = serverroom;
        this.manufacturer = manufacturer;
        this.alarmTitle = alarmTitle;
    }

    /**
    * 
    */
    private String id;
    /**
    * 归属省份/总部
    */
    private String province;
    /**
    * 所属市
    */
    private String city;
    /**
    * 所属三朵云（1001 IT云、1002业务云、1003CT云）
    */
    private Integer cloudType;
    /**
    * 所属资源池
（M/D域、B域、E域、O域 等）
    */
    private String pool;
    /**
    * 所属数据中心
（亦庄/廊坊/西咸/呼和/无锡等）
    */
    private String dataCenter;
    /**
    * 设备ID
    */
    private String deviceId;
    /**
    * 设备IP
    */
    private String deviceIp;
    /**
    * 管理对象（主机、网络设备、存储设备）2001：物理机，2002：宿主机，2003：虚拟机，2004：容器
    */
    private String deviceType;
    /**
    * 设备名称
    */
    private String deviceName;
    /**
    * 应用系统
    */
    private String applicationSystem;
    /**
    * 网管告警ID
    */
    private String alarmId;
    /**
    * 监控项
    */
    private String monitorMetrics;
    /**
    * 告警内容
    */
    private String alarmContent;
    /**
    * 告警等级（12紧急、11严重）
    */
    private Integer alarmLevel;
    /**
    * 恢复状态 51：未恢复 52：已恢复
    */
    private Integer restoreStatus;
    /**
    * 是否超时（61：是，62：否）
    */
    private Integer isTimeOut;
    /**
    * 监控类别（101Total/102Local）
    */
    private Integer monitorType;
    /**
    * 处理人
    */
    private String dealer;
    /**
    * 告警发生时间
    */
    private Date generantTime;
    /**
    * 告警恢复时间
    */
    private Date restoreTime;
    /**
    * 告警时长
    */
    private String alarmLongTime;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;

    private String remark;

    private int alarmNum;

    private Date lastGenerantTime;

    /**
     * 机房
     */
    private String serverroom;

    //厂商
    private String manufacturer;

    private String alarmTitle;

    public void initIt(String row) {
        String[] data = row.split(",");

        this.province = data[0];
        this.city = data[1];
        this.dataCenter = data[2];
        this.serverroom = data[4];
        this.deviceIp = data[5];
        if (!"".equals(data[6])){
            long time = Long.parseLong(data[6]);
            this.restoreTime = new Date(time * 1000);
        }
        if (!"".equals(data[7])){
            long time = Long.parseLong(data[7]);
            this.generantTime = new Date(time * 1000);
        }
        int category = Integer.parseInt(data[8]);
        if (category == 1){
            this.restoreStatus = 51;
        }else {
            this.restoreStatus = 52;
        }
        this.deviceType = data[9];
        this.deviceId = data[10];
        this.alarmId = data[11];
        this.alarmContent = data[12];
        int severity = Integer.parseInt(data[13]);
        switch (severity){
            case 1:
                this.alarmLevel = 14;
                break;
            case 2:
                this.alarmLevel = 13;
                break;
            case 3:
                this.alarmLevel = 11;
                break;
            case 4:
                this.alarmLevel = 12;
                break;
        }
        this.cloudType = 1001;
        if (!"".equals(data[16])){
            this.manufacturer = data[16];
        }
        if (!"".equals(data[20])){
            this.applicationSystem = data[20];
        }
    }
}
