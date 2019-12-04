package Control;

import Communicator.TelloComm;
import Mission.Mission;
import Mission.Mission1;
import Mission.Mission2;
import Mission.Mission3;

import java.util.ArrayList;
import java.util.Iterator;

public class DroneControl {
    private Mission[] missionArray;

    public DroneControl(TelloComm tc) {
        missionArray = new Mission[] {new Mission1(tc), new Mission2(tc), new Mission3(tc)};
    }

    public Boolean doMissions(ArrayList MissionChoice) throws Exception {
        Iterator iterator = MissionChoice.iterator();
        while (iterator.hasNext()){
            Long missionNumber = (Long) iterator.next();
            if (!missionArray[(int) (missionNumber - 1)].executeMission()){
                return false;
            }
        }
        return true;
    }
}
