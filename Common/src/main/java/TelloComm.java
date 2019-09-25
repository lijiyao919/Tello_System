import java.net.*;
import java.nio.charset.StandardCharsets;

public class TelloComm {
    private DatagramSocket udpClient;
    private InetAddress droneAddress;
    private int dronePort;

    public TelloComm(InetAddress address, int port) throws Exception{
        udpClient =  new DatagramSocket(port);
        droneAddress = address;
        dronePort = port;
        udpClient.setSoTimeout(1000);
    }

    public void sendMsg(byte[] bytesToSent, String sendAddress, int sendPort) throws Exception{
        DatagramPacket datagramPacket;
        InetAddress to = InetAddress.getByName(sendAddress);

        datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, to, sendPort);
        udpClient.send(datagramPacket);
        System.out.println("Sent bytes to " + to.toString() + ":" + sendPort);
    }

    public byte[] receiveMsg() throws Exception{
        DatagramPacket datagramPacket;
        byte[] bytesReceived;
        bytesReceived = new byte[64];

        datagramPacket = new DatagramPacket(bytesReceived, 64);
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            return bytesReceived;
        }
        return null;
    }

}
