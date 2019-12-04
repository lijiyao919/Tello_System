package Mission;

import Communicator.TelloComm;
import State.DroneState;
import Message.Left;
import Message.Message;
import Message.Right;

public class Mission2 extends Mission {

    public Mission2(TelloComm tc) {
        super(tc);
    }

    @Override
    protected Boolean doCustomizedActions(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        //-------- right ---------
        if(ds.getBatteryPercentage()>=80){
            result = doAction("right 200");
            if(result == Boolean.FALSE) {
                return Boolean.FALSE;
            }
        }
        else{
            System.out.println("Right 200: The volumne of the battery is not enough...");
            Thread.sleep(1000);
            result = Boolean.TRUE;
        }


        //-------- left ---------
        if(ds.getBatteryPercentage()>=80){
            result = doAction("left 200");
            if(result == Boolean.FALSE) {
                return Boolean.FALSE;
            }
        }
        else{
            System.out.println("Left 200: The volumne of the battery is not enough...");
            Thread.sleep(1000);
            result = Boolean.TRUE;
        }


        return result;
    }
}
