public class Mission3 extends Mission {
    @Override
    public Boolean doCustomizedMissions(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Action act;

        //-------- rotate ---------
        System.out.println("cw 360...");
        act = new Rotate360();
        result = executeBasicMission(tc, act);
        Thread.sleep(5000);

        return result;
    }
}
