import java.net.InetAddress;

public class DroneSimu {


    public static void main(String args[]) throws Exception {
        DroneState ds = new DroneState();
        CmdHandler ch = new CmdHandler();

        /*Runnable sp = new StatusPoster(ds);
        Thread cmdThread = new Thread(sp);
        cmdThread.start();*/

        while(true){
            ch.handleCmdMsg();
        }
    }



}
