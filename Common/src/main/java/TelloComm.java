import java.net.*;
import java.nio.charset.StandardCharsets;

public class TelloComm {
    private DatagramSocket udpClient;
    private InetAddress droneAddress;
    private int dronePort;

    public TelloComm(InetAddress address, int port) throws Exception{
        udpClient =  new DatagramSocket();
        droneAddress = address;
        dronePort = port;
        udpClient.setSoTimeout(1000);
    }

    public void sendMsg(byte[] bytesToSent) throws Exception{
        DatagramPacket datagramPacket;
        datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
        udpClient.send(datagramPacket);
        System.out.println("Sent bytes to " + droneAddress.toString() + ":" + dronePort);
    }

    public DatagramPacket receiveMsg(byte[] bytesReceived) throws Exception{
        DatagramPacket datagramPacket;

        datagramPacket = new DatagramPacket(bytesReceived, 64);
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        return datagramPacket;
    }
}
