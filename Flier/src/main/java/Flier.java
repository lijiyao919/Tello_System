import Communicator.TelloComm;
import Control.DroneControl;
import Import.ImportStrategy;
import Monitor.StateMonitor;
import Import.ImportFromJSON;
import java.util.ArrayList;
import java.util.Scanner;

public class Flier {
    public static void main(String args[]) throws Exception{
        TelloComm tcControl = new TelloComm();
        TelloComm tcMonitor = new TelloComm( 8890);
        Runnable sm = new StateMonitor(tcMonitor);
        DroneControl dc = new DroneControl(tcControl);
        ArrayList<Long> MissionChoice = new ArrayList<Long>();
        Scanner input = new Scanner(System.in);

        //monitor state (receive state msg and update)
        Thread threadSM = new Thread(sm);
        threadSM.start();

        System.out.println("Run missions manually?");
        char manual = input.next().charAt(0);

        if(manual == 'y'){
            System.out.println("Input missions (end up with '#')");
            while(true) {
                char number = input.next().charAt(0);
                if(number == '#') {
                    break;
                }
                MissionChoice.add((long) (number-'0'));
            }
        }
        else {
            ImportStrategy ip = new ImportFromJSON();
            ip.load(MissionChoice);
        }

        dc.doMissions(MissionChoice);
    }
}
