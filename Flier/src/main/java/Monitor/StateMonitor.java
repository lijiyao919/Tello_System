package Monitor;

import Communicator.TelloComm;
import Observer.CurrentStateDisplay;
import State.DroneState;
import Message.Message;
import Message.Status;

public class StateMonitor implements Runnable{
    private TelloComm tc;
    private DroneState ds;
    private Message stateMsg;
    private CurrentStateDisplay currStaShow;

    public StateMonitor(TelloComm tc) {
        this.tc = tc;
        this.ds = DroneState.getInstance();
        stateMsg = null;
        currStaShow = new CurrentStateDisplay();
        //ds.setInCommandMode(true);
    }

    private void receiveStateMsg() throws Exception{
        byte[] encodeMsg;
        encodeMsg = tc.receiveMsg();
        stateMsg = Status.decode(encodeMsg, 0, 1000);
        //System.out.println(stateMsg.getMessageText());
    }

    public void updateDroneState() throws Exception{
        receiveStateMsg();
        if (stateMsg != null){
            ds.updateFlyingInfo((Status) stateMsg);
            stateMsg = null;
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                updateDroneState();
               // Thread.sleep(100);
            } catch (Exception e) {
                //log
            }
        }
    }
}
