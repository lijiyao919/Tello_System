
public abstract class Mission {
    protected Boolean executeBasicMission(TelloComm tc, Action act) throws Exception{
        byte[] bytesToSent;
        int maxRetries = 3;

        while (maxRetries > 0) {
            bytesToSent = act.doAction();
            tc.sendMsg(bytesToSent);
            if(tc.receiveMsg() == Boolean.TRUE){
                return Boolean.TRUE;
            }
            maxRetries--;
        }
        return Boolean.FALSE;
    }
    public abstract Boolean executeMission(TelloComm tc) throws Exception;
}
