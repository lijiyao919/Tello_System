import Communicator.TelloComm;
import Control.DroneControl;
import Mock.MockTelloComm;
import Message.Message;
import Message.Reply;
import org.junit.Assert;
import org.junit.Test;


public class DroneControlTest {
    @Test
    public void testDoMissionsSuccess() throws Exception{
        Message replay = new Reply("ok");
        TelloComm tc = new MockTelloComm(replay);
        DroneControl dc = new DroneControl(tc);
        int[] MissionChoice = {1,2,3};
        Boolean result = dc.doMissions(3,MissionChoice);
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testDoMissionsFailure() throws Exception{
        Message replay = new Reply("error");
        TelloComm tc = new MockTelloComm(replay);
        DroneControl dc = new DroneControl(tc);
        int[] MissionChoice = {1,2,3};
        Boolean result = dc.doMissions(3,MissionChoice);
        Assert.assertEquals(Boolean.FALSE, result);
    }
}
