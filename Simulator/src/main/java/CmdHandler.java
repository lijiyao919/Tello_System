public class CmdHandler {
    TelloComm tc;
    DroneState ds;

    public CmdHandler(DroneState ds) throws Exception{
        tc = new TelloComm(8889);
        this.ds = ds;
    }

    public void handleCmdMsg() throws Exception {
        byte[] msg;
        Message reply = new Reply("error");

        msg = tc.receiveMsg();
        if(msg != null) {
            Message cmdMsg = Message.decode(msg, 0, 1000);
            System.out.println(cmdMsg.getMessageText());
            updateDroneState(cmdMsg);
            if (tc.getSrcAddress() != null && tc.getSrcPort() >= 0) {
                if (cmdMsg.isValid()) {
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
            System.out.println(ds.isInCommandMode());
        }
        Status sta = new Status(ds.getPitch(), ds.getRoll(), ds.getYaw(), ds.getSpeedX(), ds.getSpeedY(), ds.getSpeedZ(),
                ds.getLowTemperature(), ds.getHighTemperature(), ds.getFlightDistance(), ds.getHeight(),
                ds.getBatteryPercentage(), ds.getBarometerMeasurement(), ds.getMotorTime(),
                ds.getAccelerationX(), ds.getAccelerationY(), ds.getAccelerationZ());
        ds.updateFlyingInfo(sta);
    }



}
