package Control;

import Communicator.TelloComm;
import Mission.Mission;
import Mission.Mission1;
import Mission.Mission2;
import Mission.Mission3;

public class DroneControl {
    private Mission[] missionArray;

    public DroneControl(TelloComm tc) {
        missionArray = new Mission[] {new Mission1(tc), new Mission2(tc), new Mission3(tc)};
    }

    public Boolean doMissions(int numberOfMission, int[] MissionChoice) throws Exception {
        for(int i=0; i<numberOfMission; i++){
            if (!missionArray[MissionChoice[i] - 1].executeMission()){
                return false;
            }
        }
        return true;
    }
}
