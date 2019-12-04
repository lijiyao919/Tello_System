import Communicator.TelloComm;
import Control.DroneControl;
import Mock.MockTelloComm;
import Message.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class DroneControlTest {
    @Test
    public void testDoMissionsSuccess() throws Exception{
        Message replay = Message.decode("ok".getBytes(), 0 , 1000);
        TelloComm tc = new MockTelloComm(replay);
        DroneControl dc = new DroneControl(tc);
        ArrayList<Long> missions = new ArrayList<Long>();
        missions.add((long) 1);
        missions.add((long) 2);
        missions.add((long) 3);
        Boolean result = dc.doMissions(missions);
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testDoMissionsFailure() throws Exception{
        Message replay = Message.decode("error".getBytes(), 0 , 1000);
        TelloComm tc = new MockTelloComm(replay);
        DroneControl dc = new DroneControl(tc);
        ArrayList<Long> missions = new ArrayList<Long>();
        missions.add((long) 1);
        missions.add((long) 2);
        missions.add((long) 3);
        Boolean result = dc.doMissions(missions);
        Assert.assertEquals(Boolean.FALSE, result);
    }
}
