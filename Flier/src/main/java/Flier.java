import java.util.Scanner;

public class Flier {
    public static void main(String args[]) throws Exception{
        DroneState ds = new DroneState();
        Runnable sm = new StateMonitor(ds);
        DroneControl dc = new DroneControl();

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
