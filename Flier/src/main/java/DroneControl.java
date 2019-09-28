import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DroneControl {
    TelloComm tc;
    DroneState ds;
    Mission[] missionArray;

    public DroneControl(DroneState ds) throws Exception{
        tc = new TelloComm(0);
        this.ds = ds;
        missionArray = new Mission[] {new Mission1(), new Mission2(), new Mission3()};
    }

    public Boolean doMissions(int numberOfMission, int[] MissionChoice) throws Exception {
        for(int i=0; i<numberOfMission; i++){
            if (missionArray[MissionChoice[i]-1].executeMission(tc, ds) == false){
                return false;
            }
        }
        return true;
    }
}
