public class Mission3 extends Mission {
    @Override
    public Boolean doCustomizedMissions(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        //-------- rotate ---------
        System.out.println("cw 360...");
        msg = new Rotate("cw 360");
        result = executeBasicMission(tc, msg);
        Thread.sleep(5000);

        return result;
    }
}
