import Communicator.TelloComm;
import Mock.MockTelloComm;
import Message.Message;
import Message.Command;
import Status.StatusPoster;
import org.junit.Test;

public class StatusPosterTest {
    @Test
    public void testSendStatusMsg() throws Exception{
        Message cmd= Message.decode("command".getBytes(), 0, 1000);
        TelloComm tc = new MockTelloComm(cmd);
        StatusPoster sp = new StatusPoster(tc);
        sp.sendStatusMsg();
        //System.out.println(msg2.getMessageText());
    }
}
