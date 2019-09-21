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

    public Boolean receiveMsg() throws Exception{
        DatagramPacket datagramPacket;
        byte[] bytesReceived;
        String reply = null;

        bytesReceived = new byte[64];
        datagramPacket = new DatagramPacket(bytesReceived, 64);
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
            System.out.println("Receive " + reply);
            if (reply.equals("ok")) {
                return Boolean.TRUE;
            }
            else{
                return Boolean.FALSE;
            }
        }
        else{
            return Boolean.FALSE;
        }
    }
}
