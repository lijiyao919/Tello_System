import Communicator.TelloComm;
import Mission.*;
import Mock.MockTelloComm;
import State.DroneState;
import Message.Message;
import Message.Reply;
import org.junit.Assert;
import org.junit.Test;

public class Mission1Test {
    @Test
    public void testExecuteMissionSuccess() throws Exception{
        Boolean result;
        Message reply = Message.decode("ok".getBytes(), 0 , 1000);
        TelloComm tc = new MockTelloComm(reply);
        Mission m1 = new Mission1(tc);
        result = m1.executeMission();
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testExecuteMissionFailure() throws Exception{
        Boolean result;
        TelloComm tc = new MockTelloComm(null);
        Mission m1 = new Mission1(tc);
        result = m1.executeMission();
        Assert.assertEquals(Boolean.FALSE, result);
    }


    @Test
    public void testDoCustomizedActionNotBattery() throws Exception{
        Boolean result;
        Message reply = Message.decode("ok".getBytes(), 0 , 1000);
        DroneState ds = DroneState.getInstance();
        TelloComm tc = new MockTelloComm(reply);
        Mission m1 = new Mission1(tc);

        ds.consumeBattery(25);
        result = m1.executeMission();
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
