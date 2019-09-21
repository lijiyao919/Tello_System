public class Mission3 extends Mission {
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

        //-------- rotate ---------
        System.out.println("cw 360...");
        act = new Rotate360();
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
