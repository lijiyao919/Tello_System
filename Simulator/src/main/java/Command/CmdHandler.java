package Command;

import Communicator.TelloComm;
import State.DroneState;
import Message.Message;
import Message.Command;
import Message.Reply;

public class CmdHandler {
    private TelloComm tc;
    private DroneState ds;

    public CmdHandler(TelloComm tc) {
        this.tc = tc;
        this.ds = DroneState.getInstance();
    }

    public void handleCmdMsg() throws Exception {
        byte[] msg;
        Message reply = Message.decode("error".getBytes(), 0 , 1000);

        msg = tc.receiveMsg();
        if(msg != null) {
            Message cmdMsg = Message.decode(msg, 0, 1000);
            System.out.println(cmdMsg.getMessageText());
            if (tc.getSrcAddress() != null && tc.getSrcPort() >= 0) {
                if (cmdMsg.isValid()) {
                    updateDroneState(cmdMsg);
                    reply = Message.decode("ok".getBytes(), 0 , 1000);
                }
                byte[] replyMsg = reply.encode();
                tc.sendMsg(replyMsg, tc.getSrcAddress().getHostAddress(), tc.getSrcPort());
            }
        }
    }

    private void updateDroneState(Message cmdMsg) {
        if(cmdMsg.getMessageText().startsWith(Command.getKeyWord())){
            ds.setInCommandMode(true);
        }
        else{
            ds.consumeBattery(5);
        }

    }



}
