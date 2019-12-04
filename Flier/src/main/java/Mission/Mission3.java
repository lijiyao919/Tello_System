package Mission;

import Communicator.TelloComm;
import State.DroneState;
import Message.Message;
import Message.Rotate;

public class Mission3 extends Mission {
    @Override
    protected Boolean doCustomizedActions(TelloComm tc) throws Exception {
        Boolean result = Boolean.FALSE;
        Message msg;

        //-------- rotate ---------
        if(ds.getBatteryPercentage()>=65){
            System.out.println("Rotate 360...");
            msg = Message.decode("cw 360".getBytes(), 0 , 1000);;
            result = executeBasicAction(tc, msg);
            Thread.sleep(5000);
        }
        else{
            System.out.println("Rotate 360: The volumne of the battery is not enough...");
            result = Boolean.TRUE;
        }


        return result;
    }
}
