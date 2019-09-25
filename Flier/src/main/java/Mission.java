import java.net.DatagramPacket;
import java.nio.charset.StandardCharsets;

public abstract class Mission {
    protected Boolean executeBasicMission(TelloComm tc, Message msg) throws Exception{
        byte[] bytesToSent;
        byte[] bytesReceived ;
        int maxRetries = 3;
        Message reply;

        while (maxRetries > 0) {
            bytesToSent = msg.encode();
            tc.sendMsg(bytesToSent, "127.0.0.1", 8889);
            bytesReceived = tc.receiveMsg();
            if (bytesReceived != null) {
                System.out.println(String.format("Received %d bytes", bytesReceived.length));
                reply = Status.decode(bytesReceived, 0, 1000);
                System.out.println("Receive " + reply.getMessageText());
                if (reply.getMessageText().equals("ok")) {
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
