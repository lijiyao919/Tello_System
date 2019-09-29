public class Mission2 extends Mission {
    @Override
    public Boolean doCustomizedMissions(TelloComm tc, DroneState ds) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        //-------- right ---------
        if(ds.getBatteryPercentage()>=80){
            System.out.println("Right 200...");
            msg = new Left("right 200");
            result = executeBasicMission(tc, msg);
            if(result == Boolean.FALSE) {
                return Boolean.FALSE;
            }
            Thread.sleep(5000);
        }
        else{
            System.out.println("Right 200: The volumne of the battery is not enough...");
            result = Boolean.TRUE;
        }


        //-------- left ---------
        if(ds.getBatteryPercentage()>=80){
            System.out.println("Left 200...");
            msg = new Right("left 200");
            result = executeBasicMission(tc, msg);
            if(result == Boolean.FALSE) {
                return Boolean.FALSE;
            }
            Thread.sleep(5000);
        }
        else{
            System.out.println("Left 200: The volumne of the battery is not enough...");
            result = Boolean.TRUE;
        }


        return result;
    }
}
