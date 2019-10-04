public class Mission3 extends Mission {
    @Override
    protected Boolean doCustomizedActions(TelloComm tc, DroneState ds) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        //-------- rotate ---------
        if(ds.getBatteryPercentage()>=65){
            System.out.println("cw 360...");
            msg = new Rotate("cw 360");
            result = executeBasicAction(tc, ds, msg);
            Thread.sleep(5000);
        }
        else{
            System.out.println("Rotate 360: The volumne of the battery is not enough...");
            result = Boolean.TRUE;
        }


        return result;
    }
}
