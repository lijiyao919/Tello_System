public class Mission1 extends Mission {
    @Override
    public Boolean doCustomizedMissions(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        //-------- left ---------
        System.out.println("Left 200...");
        msg = new Left("left 200");
        result = executeBasicMission(tc, msg);
        if(result == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        Thread.sleep(5000);

        //-------- right ---------
        System.out.println("Right 200...");
        msg = new Right("right 200");
        result = executeBasicMission(tc, msg);
        if(result == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        Thread.sleep(5000);

        return result;
    }
}
