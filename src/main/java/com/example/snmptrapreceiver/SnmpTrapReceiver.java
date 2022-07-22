package com.example.snmptrapreceiver;

import org.snmp4j.MessageDispatcher;
import org.snmp4j.MessageDispatcherImpl;
import org.snmp4j.Snmp;
import org.snmp4j.mp.MPv1;
import org.snmp4j.mp.MPv2c;
import org.snmp4j.mp.MPv3;
import org.snmp4j.security.*;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.util.MultiThreadedMessageDispatcher;
import org.snmp4j.util.ThreadPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * @ClassName SnmpTrapReceiver
 * @Description TODO
 * @Author wangxc
 * @date 2022/7/21 16:03
 * @Version 1.0
 */
@Component
public class SnmpTrapReceiver  {

    @Value("${snmptrapd.port:162}")
    private int port;


    @PostConstruct
    public void run() {
        try {

            MultiThreadedMessageDispatcher dispatcher = new MultiThreadedMessageDispatcher(ThreadPool.create("trapPool", 5), new MessageDispatcherImpl());

            USM usm = new USM();

            dispatcher.addMessageProcessingModel(new MPv1());
            dispatcher.addMessageProcessingModel(new MPv2c());
            dispatcher.addMessageProcessingModel(new MPv3(usm));

            usm.addUser(new OctetString("wangxc"),
                    new UsmUser(new OctetString("wangxc"), AuthMD5.ID, new OctetString("mypassword"), PrivDES.ID, new OctetString("mypassword")));
            usm.addUser(new OctetString("authNoPriv"),
                    new UsmUser(new OctetString("authNoPriv"), AuthMD5.ID, new OctetString("mypassword"), null, null));
            usm.addUser(new OctetString("noAuthNoPriv"),
                    new UsmUser(new OctetString("noAuthNoPriv"), null ,null, null, null));

            UdpAddress udpAddress = new UdpAddress("127.0.0.1/" + port);
            Snmp snmp = new Snmp(dispatcher);

            snmp.addNotificationListener(udpAddress, new MyCommandResponder());

            System.out.println("snmptrapd 启动成功! 监听端口: " +  udpAddress.getPort());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
