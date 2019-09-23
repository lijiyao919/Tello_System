public class Mission1 extends Mission {
    @Override
    public Boolean doCustomizedMissions(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Action act;

        //-------- left ---------
        System.out.println("Left 200...");
        act = new Left200();
        result = executeBasicMission(tc, act);
        if(result == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        Thread.sleep(5000);

        //-------- right ---------
        System.out.println("Right 200...");
        act = new Right200();
        result = executeBasicMission(tc, act);
        if(result == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        Thread.sleep(5000);

        return result;
    }
}
