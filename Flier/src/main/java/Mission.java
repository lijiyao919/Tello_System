public abstract class Mission {
    protected Boolean executeBasicAction(TelloComm tc, DroneState ds, Message msg) throws Exception{
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
                reply = Status.decode(bytesReceived, 0, 1000);
                //System.out.println("Receive " + reply.getMessageText());
                if (reply.getMessageText().equals("ok")) {
                    updateByCmdReply(ds, msg);
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

    private void updateByCmdReply(DroneState ds, Message msg){
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

    private Boolean enterCommandMode(TelloComm tc, DroneState ds) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        System.out.println("Command mode...");
        msg = new Command();
        result= executeBasicAction(tc, ds, msg);
        Thread.sleep(5000);
        return result;
    }

    private Boolean doTakeOff(TelloComm tc, DroneState ds) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        if(ds.getBatteryPercentage() >= 60){
            System.out.println("Take off...");
            msg = new TakeOff();
            result= executeBasicAction(tc, ds, msg);
            Thread.sleep(5000);
            return result;
        }
        else{
            System.out.println("Takeoff: The volumne of the battery is not enough...");
            return Boolean.TRUE;
        }

    }

    private Boolean doLand(TelloComm tc, DroneState ds) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        System.out.println("Land...");
        msg = new Land();
        result= executeBasicAction(tc, ds, msg);
        Thread.sleep(5000);
        return result;
    }

    protected abstract Boolean doCustomizedActions(TelloComm tc, DroneState ds) throws Exception;

    public Boolean executeMission(TelloComm tc, DroneState ds) throws Exception{
        if(enterCommandMode(tc, ds) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        if(doTakeOff(tc, ds) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        if(doCustomizedActions(tc, ds) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        if(doLand(tc, ds) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
