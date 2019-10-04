package Communicator;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class TelloComm {
    private DatagramSocket udpClient;
    private InetAddress srcAddr;
    private int srcPort;

    public TelloComm(int port) throws Exception{
        udpClient =  new DatagramSocket(port);
        udpClient.setSoTimeout(1000);
        srcAddr = null;
        srcPort = -1;
    }

    public TelloComm() throws Exception{
        udpClient =  new DatagramSocket();
        udpClient.setSoTimeout(1000);
        srcAddr = null;
        srcPort = -1;
    }

    public void sendMsg(byte[] bytesToSent, String sendAddress, int sendPort) throws Exception{
        DatagramPacket datagramPacket;
        InetAddress to = InetAddress.getByName(sendAddress);

        datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, to, sendPort);
        udpClient.send(datagramPacket);
        //System.out.println("Sent bytes to " + to.toString() + ":" + sendPort);
    }

    public byte[] receiveMsg() throws Exception{
        DatagramPacket datagramPacket;
        byte[] bytesReceived;
        bytesReceived = new byte[1024];

        datagramPacket = new DatagramPacket(bytesReceived, 1024);
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            srcAddr = datagramPacket.getAddress();
            srcPort = datagramPacket.getPort();
            return bytesReceived;
        }
        return null;
    }

    public InetAddress getSrcAddress() {
        return srcAddr;
    }

    public int getSrcPort(){
        return srcPort;
    }


}
