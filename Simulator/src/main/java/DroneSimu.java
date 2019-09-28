import java.net.InetAddress;

public class DroneSimu {


    public static void main(String args[]) throws Exception {
        DroneState ds = new DroneState();

        Runnable sp = new StatusPoster(ds);
        Thread cmdThread = new Thread(sp);
        cmdThread.start();

        CmdHandler ch = new CmdHandler(ds);
        while(true){
            ch.handleCmdMsg();
        }
    }



}
