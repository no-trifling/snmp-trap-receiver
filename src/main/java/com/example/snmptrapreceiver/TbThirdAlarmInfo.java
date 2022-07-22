package com.example.snmptrapreceiver;


import lombok.ToString;

import java.util.Date;

@ToString
public class TbThirdAlarmInfo {
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
     * 告警等级（12紧急、11严重、13一般、14轻微）
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
     * 告警首次发生时间
     */
    private Date generantTime;

    /**
     * 告警最新发生时间
     */
    private Date lastGenerantTime;

    /**
     * 告警恢复时间
     */
    private Date restoreTime;

    /**
     * 告警时长
     */
    private String alarmLongTime;

    /**
     * 告警次数
     */
    private Integer alarmNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    private Date confirmTime;

    private String confirmReason;

    private String confirmStatus;

    private String kbpClass;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取归属省份/总部
     *
     * @return province - 归属省份/总部
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置归属省份/总部
     *
     * @param province 归属省份/总部
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取所属市
     *
     * @return city - 所属市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所属市
     *
     * @param city 所属市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取所属三朵云（1001 IT云、1002业务云、1003CT云）
     *
     * @return cloud_type - 所属三朵云（1001 IT云、1002业务云、1003CT云）
     */
    public Integer getCloudType() {
        return cloudType;
    }

    /**
     * 设置所属三朵云（1001 IT云、1002业务云、1003CT云）
     *
     * @param cloudType 所属三朵云（1001 IT云、1002业务云、1003CT云）
     */
    public void setCloudType(Integer cloudType) {
        this.cloudType = cloudType;
    }

    /**
     * 获取所属资源池
（M/D域、B域、E域、O域 等）
     *
     * @return pool - 所属资源池
（M/D域、B域、E域、O域 等）
     */
    public String getPool() {
        return pool;
    }

    /**
     * 设置所属资源池
（M/D域、B域、E域、O域 等）
     *
     * @param pool 所属资源池
（M/D域、B域、E域、O域 等）
     */
    public void setPool(String pool) {
        this.pool = pool;
    }

    /**
     * 获取所属数据中心
（亦庄/廊坊/西咸/呼和/无锡等）
     *
     * @return data_center - 所属数据中心
（亦庄/廊坊/西咸/呼和/无锡等）
     */
    public String getDataCenter() {
        return dataCenter;
    }

    /**
     * 设置所属数据中心
（亦庄/廊坊/西咸/呼和/无锡等）
     *
     * @param dataCenter 所属数据中心
（亦庄/廊坊/西咸/呼和/无锡等）
     */
    public void setDataCenter(String dataCenter) {
        this.dataCenter = dataCenter;
    }

    /**
     * 获取设备ID
     *
     * @return device_id - 设备ID
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 设置设备ID
     *
     * @param deviceId 设备ID
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 获取设备IP
     *
     * @return device_ip - 设备IP
     */
    public String getDeviceIp() {
        return deviceIp;
    }

    /**
     * 设置设备IP
     *
     * @param deviceIp 设备IP
     */
    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    /**
     * 获取管理对象（主机、网络设备、存储设备）2001：物理机，2002：宿主机，2003：虚拟机，2004：容器
     *
     * @return device_type - 管理对象（主机、网络设备、存储设备）2001：物理机，2002：宿主机，2003：虚拟机，2004：容器
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * 设置管理对象（主机、网络设备、存储设备）2001：物理机，2002：宿主机，2003：虚拟机，2004：容器
     *
     * @param deviceType 管理对象（主机、网络设备、存储设备）2001：物理机，2002：宿主机，2003：虚拟机，2004：容器
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * 获取设备名称
     *
     * @return device_name - 设备名称
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * 设置设备名称
     *
     * @param deviceName 设备名称
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * 获取应用系统
     *
     * @return application_system - 应用系统
     */
    public String getApplicationSystem() {
        return applicationSystem;
    }

    /**
     * 设置应用系统
     *
     * @param applicationSystem 应用系统
     */
    public void setApplicationSystem(String applicationSystem) {
        this.applicationSystem = applicationSystem;
    }

    /**
     * 获取网管告警ID
     *
     * @return alarm_id - 网管告警ID
     */
    public String getAlarmId() {
        return alarmId;
    }

    /**
     * 设置网管告警ID
     *
     * @param alarmId 网管告警ID
     */
    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }

    /**
     * 获取监控项
     *
     * @return monitor_metrics - 监控项
     */
    public String getMonitorMetrics() {
        return monitorMetrics;
    }

    /**
     * 设置监控项
     *
     * @param monitorMetrics 监控项
     */
    public void setMonitorMetrics(String monitorMetrics) {
        this.monitorMetrics = monitorMetrics;
    }

    /**
     * 获取告警内容
     *
     * @return alarm_content - 告警内容
     */
    public String getAlarmContent() {
        return alarmContent;
    }

    /**
     * 设置告警内容
     *
     * @param alarmContent 告警内容
     */
    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent;
    }

    /**
     * 获取告警等级（12紧急、11严重、13一般、14轻微）
     *
     * @return alarm_level - 告警等级（12紧急、11严重、13一般、14轻微）
     */
    public Integer getAlarmLevel() {
        return alarmLevel;
    }

    /**
     * 设置告警等级（12紧急、11严重、13一般、14轻微）
     *
     * @param alarmLevel 告警等级（12紧急、11严重、13一般、14轻微）
     */
    public void setAlarmLevel(Integer alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    /**
     * 获取恢复状态 51：未恢复 52：已恢复
     *
     * @return restore_status - 恢复状态 51：未恢复 52：已恢复
     */
    public Integer getRestoreStatus() {
        return restoreStatus;
    }

    /**
     * 设置恢复状态 51：未恢复 52：已恢复
     *
     * @param restoreStatus 恢复状态 51：未恢复 52：已恢复
     */
    public void setRestoreStatus(Integer restoreStatus) {
        this.restoreStatus = restoreStatus;
    }

    /**
     * 获取是否超时（61：是，62：否）
     *
     * @return is_time_out - 是否超时（61：是，62：否）
     */
    public Integer getIsTimeOut() {
        return isTimeOut;
    }

    /**
     * 设置是否超时（61：是，62：否）
     *
     * @param isTimeOut 是否超时（61：是，62：否）
     */
    public void setIsTimeOut(Integer isTimeOut) {
        this.isTimeOut = isTimeOut;
    }

    /**
     * 获取监控类别（101Total/102Local）
     *
     * @return monitor_type - 监控类别（101Total/102Local）
     */
    public Integer getMonitorType() {
        return monitorType;
    }

    /**
     * 设置监控类别（101Total/102Local）
     *
     * @param monitorType 监控类别（101Total/102Local）
     */
    public void setMonitorType(Integer monitorType) {
        this.monitorType = monitorType;
    }

    /**
     * 获取处理人
     *
     * @return dealer - 处理人
     */
    public String getDealer() {
        return dealer;
    }

    /**
     * 设置处理人
     *
     * @param dealer 处理人
     */
    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    /**
     * 获取告警首次发生时间
     *
     * @return generant_time - 告警首次发生时间
     */
    public Date getGenerantTime() {
        return generantTime;
    }

    /**
     * 设置告警首次发生时间
     *
     * @param generantTime 告警首次发生时间
     */
    public void setGenerantTime(Date generantTime) {
        this.generantTime = generantTime;
    }

    /**
     * 获取告警最新发生时间
     *
     * @return last_generant_time - 告警最新发生时间
     */
    public Date getLastGenerantTime() {
        return lastGenerantTime;
    }

    /**
     * 设置告警最新发生时间
     *
     * @param lastGenerantTime 告警最新发生时间
     */
    public void setLastGenerantTime(Date lastGenerantTime) {
        this.lastGenerantTime = lastGenerantTime;
    }

    /**
     * 获取告警恢复时间
     *
     * @return restore_time - 告警恢复时间
     */
    public Date getRestoreTime() {
        return restoreTime;
    }

    /**
     * 设置告警恢复时间
     *
     * @param restoreTime 告警恢复时间
     */
    public void setRestoreTime(Date restoreTime) {
        this.restoreTime = restoreTime;
    }

    /**
     * 获取告警时长
     *
     * @return alarm_long_time - 告警时长
     */
    public String getAlarmLongTime() {
        return alarmLongTime;
    }

    /**
     * 设置告警时长
     *
     * @param alarmLongTime 告警时长
     */
    public void setAlarmLongTime(String alarmLongTime) {
        this.alarmLongTime = alarmLongTime;
    }

    /**
     * 获取告警次数
     *
     * @return alarm_num - 告警次数
     */
    public Integer getAlarmNum() {
        return alarmNum;
    }

    /**
     * 设置告警次数
     *
     * @param alarmNum 告警次数
     */
    public void setAlarmNum(Integer alarmNum) {
        this.alarmNum = alarmNum;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return confirm_time
     */
    public Date getConfirmTime() {
        return confirmTime;
    }

    /**
     * @param confirmTime
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * @return confirm_reason
     */
    public String getConfirmReason() {
        return confirmReason;
    }

    /**
     * @param confirmReason
     */
    public void setConfirmReason(String confirmReason) {
        this.confirmReason = confirmReason;
    }

    /**
     * @return confirm_status
     */
    public String getConfirmStatus() {
        return confirmStatus;
    }

    /**
     * @param confirmStatus
     */
    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    /**
     * @return kbp_class
     */
    public String getKbpClass() {
        return kbpClass;
    }

    /**
     * @param kbpClass
     */
    public void setKbpClass(String kbpClass) {
        this.kbpClass = kbpClass;
    }
}