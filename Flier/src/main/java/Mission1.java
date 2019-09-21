public class Mission1 extends Mission {
    @Override
    public Boolean executeMission(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Action act;
        //-------- Put drone in command mode ---------
        System.out.println("Put drone in command mode...");
        act = new Command();
        result=executeBasicMission(tc, act);
        if(result == Boolean.FALSE) {
            return Boolean.FALSE;
        }

        //-------- take off ---------
        System.out.println("Takeoff...");
        act = new Takeoff();
        result = executeBasicMission(tc, act);
        if(result == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        Thread.sleep(5000);

        //-------- left ---------
        System.out.println("Left 200...");
        act = new Left200();
        result = executeBasicMission(tc, act);
        if(result == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        Thread.sleep(5000);

        //-------- land ---------
        System.out.println("Land...");
        act = new Land();
        result = executeBasicMission(tc, act);
        if(result == Boolean.FALSE) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
