import java.net.InetAddress;

public class DroneSimu {


    public static void main(String args[]) throws Exception {
        DroneState ds = new DroneState();
        TelloComm tcCmdHandler = new TelloComm(8889);
        TelloComm tcPoster = new TelloComm( );

        Runnable sp = new StatusPoster(ds, tcPoster);
        Thread cmdThread = new Thread(sp);
        cmdThread.start();

        CmdHandler ch = new CmdHandler(ds, tcCmdHandler);
        while(true){
            ch.handleCmdMsg();
        }
    }



}
