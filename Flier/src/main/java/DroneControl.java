import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DroneControl {
    TelloComm tc;
    Mission[] missionArray;

    public DroneControl() throws Exception{
        tc = new TelloComm(0);
        missionArray = new Mission[] {new Mission1(), new Mission2(), new Mission3()};
    }

    public Boolean doMissions(int numberOfMission, int[] MissionChoice) throws Exception {
        for(int i=0; i<numberOfMission; i++){
            if (missionArray[MissionChoice[i]-1].executeMission(tc) == false){
                return false;
            }
        }
        return true;
    }
}
