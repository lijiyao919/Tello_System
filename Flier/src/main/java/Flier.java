import Communicator.TelloComm;
import Control.DroneControl;
import Monitor.StateMonitor;
import State.DroneState;

import java.util.Scanner;

public class Flier {
    public static void main(String args[]) throws Exception{
        DroneState ds = new DroneState();
        TelloComm tcControl = new TelloComm();
        TelloComm tcMonitor = new TelloComm( 8890);
        Runnable sm = new StateMonitor(ds, tcMonitor);
        DroneControl dc = new DroneControl(ds, tcControl);

        int numberOfMission;
        Scanner input = new Scanner(System.in);

        //monitor state (receive state msg and update)
        Thread threadSM = new Thread(sm);
        threadSM.start();

        //do mission
        System.out.println("The number of the mission sequence:");
        numberOfMission = input.nextInt();

        System.out.println("Enter mission sequence:");
        int[] MissionChoice = new int[numberOfMission];
        for(int i=0; i<numberOfMission; i++){
            MissionChoice[i]=input.nextInt();
        }

        dc.doMissions(numberOfMission, MissionChoice);
    }
}
