import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DroneControl {
    private TelloComm tc;
    private DroneState ds;
    private Mission[] missionArray;

    public DroneControl(DroneState ds, TelloComm tc) throws Exception{
        this.tc = tc;
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
