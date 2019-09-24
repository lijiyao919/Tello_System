import java.net.DatagramPacket;
import java.nio.charset.StandardCharsets;

public abstract class Mission {
    protected Boolean executeBasicMission(TelloComm tc, Message msg) throws Exception{
        byte[] bytesToSent;
        byte[] bytesReceived = new byte[64];
        DatagramPacket datagramPacket;
        int maxRetries = 3;
        String reply = null;

        while (maxRetries > 0) {
            bytesToSent = msg.encode();
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

    protected Boolean enterCommandMode(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        System.out.println("Put drone in command mode...");
        msg = new Command();
        result=executeBasicMission(tc, msg);
        return result;
    }

    protected Boolean doTakeOff(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        System.out.println("Put drone in command mode...");
        msg = new TakeOff();
        result=executeBasicMission(tc, msg);
        Thread.sleep(5000);
        return result;
    }

    protected Boolean doLand(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        System.out.println("Put drone in command mode...");
        msg = new Land();
        result=executeBasicMission(tc, msg);
        Thread.sleep(5000);
        return result;
    }

    protected abstract Boolean doCustomizedMissions(TelloComm tc) throws Exception;

    public Boolean executeMission(TelloComm tc) throws Exception{
        if(enterCommandMode(tc) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        if(doTakeOff(tc) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        if(doCustomizedMissions(tc) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        if(doLand(tc) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
