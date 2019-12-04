package Mission;

import Communicator.TelloComm;
import Message.Left;
import Message.*;
import State.*;

public abstract class Mission {
    protected DroneState ds;

    public Mission() {
        ds = DroneState.getInstance();
    }

    public Boolean executeBasicAction(TelloComm tc, Message msg) throws Exception{
        byte[] bytesToSent;
        byte[] bytesReceived ;
        int maxRetries = 3;
        Message reply;

        while (maxRetries > 0) {
            bytesToSent = msg.encode();
            tc.sendMsg(bytesToSent, "127.0.0.1", 8889);
            bytesReceived = tc.receiveMsg();
            if (bytesReceived != null) {
                //System.out.println(String.format("Received %d bytes", bytesReceived.length));
                reply = Message.decode(bytesReceived, 0, 1000);
                //System.out.println("Receive " + reply.getMessageText());
                if (reply.getMessageText().equals("ok")) {
                    updateByCmdReply(msg);
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

    private void updateByCmdReply(Message msg){
        if(msg.getMessageText().startsWith(Command.getKeyWord())){
            ds.setInCommandMode(true);
        }
        else if(msg.getMessageText().startsWith(TakeOff.getKeyWord())){
            ds.setHasTakenOff(true);
            ds.move(0, -75, 0);
        }
        else if(msg.getMessageText().startsWith(Land.getKeyWord())){
            ds.setHasTakenOff(false);
            ds.move(0, 75, 0);
        }
        else if(msg.getMessageText().startsWith(Left.getKeyWord())){
            ds.move(-50, 0,0);
        }
        else if(msg.getMessageText().startsWith(Right.getKeyWord())){
            ds.move(50, 0,0);
        }

    }

    private Boolean enterCommandMode(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        System.out.println("Command mode...");
        msg = Message.decode("command".getBytes(), 0 , 1000);
        result= executeBasicAction(tc, msg);
        Thread.sleep(5000);
        return result;
    }

    private Boolean doTakeOff(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        if(ds.getBatteryPercentage() >= 60){
            System.out.println("Take off...");
            msg = Message.decode("takeoff".getBytes(), 0 , 1000);
            result= executeBasicAction(tc, msg);
            Thread.sleep(5000);
            return result;
        }
        else{
            System.out.println("Takeoff: The volumne of the battery is not enough...");
            return Boolean.TRUE;
        }

    }

    private Boolean doLand(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        System.out.println("Land...");
        msg = Message.decode("land".getBytes(), 0 , 1000);;
        result= executeBasicAction(tc, msg);
        Thread.sleep(5000);
        return result;
    }

    protected abstract Boolean doCustomizedActions(TelloComm tc) throws Exception;

    public Boolean executeMission(TelloComm tc) throws Exception{
        if(enterCommandMode(tc) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        if(doTakeOff(tc) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        if(doCustomizedActions(tc) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        if(doLand(tc) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
