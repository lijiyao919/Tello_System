public class StateMonitor implements Runnable{
    TelloComm tc;
    DroneState ds;
    Message stateMsg;
    CurrentStateDisplay currStaShow;

    public StateMonitor(DroneState ds) throws Exception {
        tc = new TelloComm( 8890);
        this.ds = ds;
        stateMsg = null;
        currStaShow = new CurrentStateDisplay(ds);
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
                Thread.sleep(100);
            } catch (Exception e) {
                //log
            }
        }
    }
}
