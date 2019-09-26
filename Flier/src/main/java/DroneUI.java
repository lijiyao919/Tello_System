import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DroneUI {
    public static void main(String args[]) throws Exception {
        String DroneAddress;
        int DronePort;
        int numberOfMission;
        Mission[] missionArray = new Mission[] {new Mission1(), new Mission2(), new Mission3()};
        Scanner input = new Scanner(System.in);


        System.out.println("Enter Drone IP Address:");
        DroneAddress = input.nextLine();

        System.out.println("Enter Drone Port:");
        DronePort = input.nextInt();

        System.out.println("The number of the mission sequence:");
        numberOfMission = input.nextInt();

        System.out.println("Enter mission sequence:");
        int[] MissionChoice = new int[numberOfMission];
        for(int i=0; i<numberOfMission; i++){
            MissionChoice[i]=input.nextInt();
        }

        TelloComm tc = new TelloComm(DronePort);
        for(int i=0; i<numberOfMission; i++){
            missionArray[MissionChoice[i]-1].executeMission(tc);
        }



    }
}
