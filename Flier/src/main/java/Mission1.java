public class Mission1 extends Mission {
    @Override
    protected Boolean doCustomizedActions(TelloComm tc, DroneState ds) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        //-------- left ---------
        if(ds.getBatteryPercentage()>=80){
            System.out.println("Left 200...");
            msg = new Left("left 200");
            result = executeBasicAction(tc, ds, msg);
            if(result == Boolean.FALSE) {
                return Boolean.FALSE;
            }
            Thread.sleep(5000);
        }
        else{
            System.out.println("Left 200: The volumne of the battery is not enough...");
            Thread.sleep(1000);
            result = Boolean.TRUE;
        }


        //-------- right ---------
        if(ds.getBatteryPercentage()>=80){
            System.out.println("Right 200...");
            msg = new Right("right 200");
            result = executeBasicAction(tc, ds, msg);
            if(result == Boolean.FALSE) {
                return Boolean.FALSE;
            }
            Thread.sleep(5000);
        }
        else{
            System.out.println("Right 200: The volumne of the battery is not enough...");
            Thread.sleep(1000);
            result = Boolean.TRUE;
        }


        return result;
    }
}
