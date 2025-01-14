package com.pnoker.device.group.bean.wia;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Copyright(c) 2019. Pnoker All Rights Reserved.
 * <p>Author     : Pnoker
 * <p>Email      : pnokers@gmail.com
 * <p>Description: Wia 网关信息
 */
@Data
@Slf4j
public class MyGateway {
    /* 网关基本信息 */
    private Map<String, MyHartDevice> hartDeviceMap = new HashMap<>(10);
    private String ipAddress;
    private int localPort;
    private int port;

    /* 报文信息 */
    private DatagramSocket datagramSocket;
    private DatagramPacket datagramReceive;
    private DatagramPacket datagramSend;
    private byte[] buff = new byte[1024];
    private byte[] sendCode = {(byte) 0x01, (byte) 0x0B, (byte) 0xFF, (byte) 0xFF, (byte) 0x4A, (byte) 0x9B};

    public MyGateway(String ipAddress, int localPort, int port, List<MyHartDevice> myHartDeviceList) {
        myHartDeviceList.forEach(myHartDevice -> hartDeviceMap.put(myHartDevice.getLongAddress(), myHartDevice));
        try {
            this.datagramSocket = new DatagramSocket(localPort);
            this.datagramSocket.setSoTimeout(1000 * 60 * 3);
            this.datagramSocket.receive(datagramReceive);
            this.datagramSend = new DatagramPacket(sendCode, sendCode.length, InetAddress.getByName(ipAddress), port);
        } catch (SocketException e) {
            log.error("init datagram socket fail", e);
        } catch (UnknownHostException e) {
            log.error("unknow gateway host", e);
        } catch (IOException e) {
            log.error("receive datagram fail", e);
        }
        this.datagramReceive = new DatagramPacket(buff, 1024);
    }
}
