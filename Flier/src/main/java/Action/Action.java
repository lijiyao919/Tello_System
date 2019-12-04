package Action;

import Communicator.TelloComm;
import Message.Message;
import Message.Command;
import Message.TakeOff;
import Message.Land;
import Message.Left;
import Message.Right;
import State.DroneState;

public abstract class Action {
    private TelloComm tc;
    private String cmd;
    private DroneState ds;


    protected Action(TelloComm tc, String cmd) {
        this.tc = tc;
        this.cmd = cmd;
        this.ds = DroneState.getInstance();
    }

    private Boolean executeBasicAction(TelloComm tc, Message msg) throws Exception{
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

    public Boolean execute() throws Exception{
        System.out.println(cmd + "....");
        Message msg = Message.decode(cmd.getBytes(), 0 , 1000);
        Boolean result= executeBasicAction(tc, msg);
        Thread.sleep(5000);
        return result;
    }
}
