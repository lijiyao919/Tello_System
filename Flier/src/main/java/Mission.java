import java.net.DatagramPacket;
import java.nio.charset.StandardCharsets;

public abstract class Mission {
    protected Boolean executeBasicMission(TelloComm tc, Action act) throws Exception{
        byte[] bytesToSent;
        byte[] bytesReceived = new byte[64];
        DatagramPacket datagramPacket;
        int maxRetries = 3;
        String reply = null;

        while (maxRetries > 0) {
            bytesToSent = act.doAction();
            tc.sendMsg(bytesToSent);
            datagramPacket = tc.receiveMsg(bytesReceived);
            if (datagramPacket != null) {
                System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
                reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
                System.out.println("Receive " + reply);
                if (reply.equals("ok")) {
                    return Boolean.TRUE;
                }
                else{
                    maxRetries--;
                }
            }
            else{
                maxRetries--;
            }

        }
        return Boolean.FALSE;
    }
    public abstract Boolean executeMission(TelloComm tc) throws Exception;
}
