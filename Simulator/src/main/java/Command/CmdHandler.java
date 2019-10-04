package Command;

import Communicator.TelloComm;
import State.DroneState;
import Message.Message;
import Message.Command;
import Message.Reply;

public class CmdHandler {
    private TelloComm tc;
    private DroneState ds;

    public CmdHandler(DroneState ds, TelloComm tc) throws Exception{
        this.tc = tc;
        this.ds = ds;
    }

    public void handleCmdMsg() throws Exception {
        byte[] msg;
        Message reply = new Reply("error");

        msg = tc.receiveMsg();
        if(msg != null) {
            Message cmdMsg = Message.decode(msg, 0, 1000);
            System.out.println(cmdMsg.getMessageText());
            if (tc.getSrcAddress() != null && tc.getSrcPort() >= 0) {
                if (cmdMsg.isValid()) {
                    updateDroneState(cmdMsg);
                    reply = new Reply("ok");
                }
                byte[] replyMsg = reply.encode();
                tc.sendMsg(replyMsg, tc.getSrcAddress().getHostAddress(), tc.getSrcPort());
            }
        }
    }

    private void updateDroneState(Message cmdMsg) throws Exception {
        if(cmdMsg.getMessageText().startsWith(Command.getKeyWord())){
            ds.setInCommandMode(true);
        }
        else{
            ds.consumeBattery(5);
        }

    }



}
