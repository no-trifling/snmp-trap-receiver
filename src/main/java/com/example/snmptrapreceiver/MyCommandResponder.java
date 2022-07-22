package com.example.snmptrapreceiver;

import com.example.snmptrapreceiver.dto.TbThirdAlarmInfoDTO;
import com.example.snmptrapreceiver.util.DateTimeUtil;
import org.snmp4j.*;
import org.snmp4j.smi.*;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName MyCommandResponder
 * @Description TODO
 * @Author wangxc
 * @date 2022/7/21 16:04
 * @Version 1.0
 */
public class MyCommandResponder implements CommandResponder {


    private final String vEPC_XSQ_address = "132.79.254.156";

    private final String vEPC_ZY_address = "132.79.254.157";

    private final String vIMS_MXY_address = "132.79.254.158";

    private final String vIMS_FZ_address = "132.79.254.159";


    @Override
    public void processPdu(CommandResponderEvent commandResponderEvent) {

        String address = ((IpAddress) commandResponderEvent.getPeerAddress()).getInetAddress().getHostAddress();
        System.out.println("snmp agent address: " + address);

        PDU pdu = commandResponderEvent.getPDU();
        System.out.println("receive snmp request, pdu: " + commandResponderEvent.getPDU());
        int pduType = pdu.getType();
        if (pduType == PDU.INFORM || pduType == PDU.TRAP) {

            String pool = "";
            String dataCenter = "";
            String dataUpDataCenter = "";
            String serverRoom = "";

            switch (address) {
                case vEPC_XSQ_address:
                    pool = "vEPC资源池";
                    dataCenter = "西三旗电话局";
                    dataUpDataCenter = "西三旗电话局数据中心";
                    serverRoom = "二层5G核心机房1";
                    break;
                case vEPC_ZY_address:
                    pool = "vEPC资源池";
                    dataCenter = "亦庄电话局";
                    dataUpDataCenter = "亦庄电话局数据中心";
                    serverRoom = "二层DC机房";
                    break;
                case vIMS_FZ_address:
                    pool = "vIMS&NB资源池";
                    dataCenter = "北京-方庄局母局";
                    dataUpDataCenter = "方庄局母局数据中心";
                    serverRoom = "三层302市话交换机房";
                    break;
                case vIMS_MXY_address:
                    pool = "vIMS&NB资源池";
                    dataCenter = "北京-木樨园局";
                    dataUpDataCenter = "木樨园局数据中心";
                    serverRoom = "二层8725交换机房";
                    break;
            }

            // 告警恢复标志
            int iMAPNorthboundAlarmRestore = pdu.getVariable(HwAlarmOidConstants.iMAPNorthboundAlarmRestore).toInt();
            String iMAPNorthboundAlarmCSN = pdu.getVariable(HwAlarmOidConstants.iMAPNorthboundAlarmCSN).toString();
            String iMAPNorthboundAlarmOccurTime = pdu.getVariable(HwAlarmOidConstants.iMAPNorthboundAlarmOccurTime).toString();
            Date alarmOccurTime = DateTimeUtil.strToDate(iMAPNorthboundAlarmOccurTime, DateTimeUtil.DEFAULT_FORMAT);
            OctetString iMAPNorthboundAlarmRestoreTime = (OctetString) pdu.getVariable(HwAlarmOidConstants.iMAPNorthboundAlarmRestoreTime);
            Date alarmRestoreTime = DateTimeUtil.strToDate(iMAPNorthboundAlarmRestoreTime.toString(), DateTimeUtil.DEFAULT_FORMAT);

            // 查询是否有数据
//            Example example = new Example(TbThirdAlarmInfo.class);
//            example.createCriteria().andEqualTo("alarmId", iMAPNorthboundAlarmCSN);
//            TbThirdAlarmInfo alarmInfo = tbThirdAlarmInfoMapper.selectOneByExample(example);
            TbThirdAlarmInfo alarmInfo = new TbThirdAlarmInfo();

            if (alarmInfo != null) {

                // '恢复状态 51：未恢复 52：已恢复'
                if (iMAPNorthboundAlarmRestore == 1) {
                    // 已恢复
                    alarmInfo.setRestoreStatus(52);
                    alarmInfo.setRestoreTime(alarmRestoreTime);
                } else if (iMAPNorthboundAlarmRestore == 2) {
                    alarmInfo.setRestoreStatus(51);
                    alarmInfo.setLastGenerantTime(alarmOccurTime);
                }

                // 计算告警时长
//                if (EmptyValidator.isNotEmpty(alarmInfo.getGenerantTime()) && EmptyValidator.isNotEmpty(alarmInfo.getRestoreTime())) {
//                    Date generantTime = alarmInfo.getGenerantTime();
//                    Date restoreTime = alarmInfo.getRestoreTime();
//                    long time = restoreTime.getTime() - generantTime.getTime();
//                    String longTime = secondToTime(time / 1000);
//                    alarmInfo.setAlarmLongTime(longTime);
//                }

            } else {

                String iMAPNorthboundAlarmProbablecause = pdu.getVariable(HwAlarmOidConstants.iMAPNorthboundAlarmProbablecause).toString();
                String iMAPNorthboundAlarmSpecificproblems = pdu.getVariable(HwAlarmOidConstants.iMAPNorthboundAlarmProbablecause).toString();
                String iMAPNorthboundAlarmNEDevID = pdu.getVariable(HwAlarmOidConstants.iMAPNorthboundAlarmNEDevID).toString();
                String iMAPNorthboundAlarmMOName = pdu.getVariable(HwAlarmOidConstants.iMAPNorthboundAlarmMOName).toString();
                String iMAPNorthboundAlarmNEType = pdu.getVariable(HwAlarmOidConstants.iMAPNorthboundAlarmNEType).toString();
                int iMAPNorthboundAlarmLevel = pdu.getVariable(HwAlarmOidConstants.iMAPNorthboundAlarmLevel).toInt();


                alarmInfo = new TbThirdAlarmInfo();
                alarmInfo.setProvince("北京");
                alarmInfo.setCity("北京");
                alarmInfo.setCloudType(1003);
                alarmInfo.setAlarmId(iMAPNorthboundAlarmCSN);
                alarmInfo.setPool(pool);
                alarmInfo.setDataCenter(dataCenter);
                String alarmContent = iMAPNorthboundAlarmProbablecause + "[" + iMAPNorthboundAlarmSpecificproblems + "]";
                alarmInfo.setAlarmContent(alarmContent);
                alarmInfo.setDeviceId(iMAPNorthboundAlarmNEDevID);
                alarmInfo.setDeviceName(iMAPNorthboundAlarmMOName);
//                alarmInfo.setId(UUIDGenerator.create());
                alarmInfo.setDeviceType(iMAPNorthboundAlarmNEType);
                alarmInfo.setCreateTime(new Date());
                alarmInfo.setRemark(pdu.getVariableBindings().toString());
                int alarmLevel = 0;
                switch (iMAPNorthboundAlarmLevel) {
                    case 1:
                        alarmLevel = 12;
                        break;
                    case 2:
                        alarmLevel = 11;
                        break;
                    case 3:
                        alarmLevel = 13;
                        break;
                    case 4:
                        alarmLevel = 14;
                        break;
                }
                alarmInfo.setAlarmLevel(alarmLevel);
                if (iMAPNorthboundAlarmRestore == 1) {
                    alarmInfo.setRestoreStatus(52);
                    alarmInfo.setRestoreTime(alarmRestoreTime);
                } else if (iMAPNorthboundAlarmRestore == 2) {
                    alarmInfo.setRestoreStatus(51);
                    alarmInfo.setLastGenerantTime(alarmOccurTime);
                }


                if ("BJ_BJ_eSight01_HW_V".equals(alarmInfo.getDeviceName())) {
                    alarmInfo.setDataCenter("北京-木樨园局");
                } else {
                    alarmInfo.setDataCenter("北京-方庄局母局");
                }
                System.out.println(alarmInfo);
//                tbThirdAlarmInfoMapper.insert(alarmInfo);

            }


            //上报数据处理
//            TbThirdAlarmInfoDTO alarmInfoDTO = BeanConvertor.getCopyObject(TbThirdAlarmInfoDTO.class, alarmInfo);
//            alarmInfoDTO.setManufacturer("华为");
//            alarmInfoDTO.setServerroom(serverRoom);
//            alarmInfoDTO.setDataCenter(dataUpDataCenter);
//
//            dataUpApp.sendAlarmInfo(alarmInfoDTO);
//            //告警数据发送到kafka
//            alarmInfoDTO.setAlarmTitle(pdu.getVariable(HwAlarmOidConstants.iMAPNorthboundAlarmProbablecause).toString());
//            kafkaHelper.syncThirdAlarmToKafka(JSON.toJSONString(alarmInfoDTO));


        }
    }

}
