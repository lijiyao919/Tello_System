import Command.CmdHandler;
import Communicator.TelloComm;
import State.DroneState;
import Status.StatusPoster;

public class DroneSimu {
    public static void main(String args[]) throws Exception {
        TelloComm tcCmdHandler = new TelloComm(8889);
        TelloComm tcPoster = new TelloComm( );

        Runnable sp = new StatusPoster(tcPoster);
        Thread cmdThread = new Thread(sp);
        cmdThread.start();

        CmdHandler ch = new CmdHandler(tcCmdHandler);
        while(true){
            ch.handleCmdMsg();
        }
    }



}
