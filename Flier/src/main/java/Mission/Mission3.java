package Mission;

import Communicator.TelloComm;
import State.DroneState;
import Message.Message;
import Message.Rotate;

public class Mission3 extends Mission {

    public Mission3(TelloComm tc) {
        super(tc);
    }

    @Override
    protected Boolean doCustomizedActions(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        //-------- rotate ---------
        if(ds.getBatteryPercentage()>=65){
            result = doAction("cw 360");
        }
        else{
            System.out.println("Rotate 360: The volumne of the battery is not enough...");
            result = Boolean.TRUE;
        }


        return result;
    }
}
