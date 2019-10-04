import Communicator.TelloComm;
import Mock.MockTelloComm;
import State.DroneState;
import Message.Message;
import Message.Command;
import Status.StatusPoster;
import org.junit.Test;

public class StatusPosterTest {
    @Test
    public void testSendStatusMsg() throws Exception{
    //public static void main(String args[]) throws Exception{
        Message cmd= new Command();
        DroneState ds = new DroneState();
        TelloComm tc = new MockTelloComm(cmd);
        StatusPoster sp = new StatusPoster(ds, tc);
        sp.sendStatusMsg();


        //System.out.println(msg2.getMessageText());

    }
}
