import Communicator.TelloComm;
import Mission.*;
import Mock.MockTelloComm;
import State.DroneState;
import Message.Message;
import Message.Reply;
import org.junit.Assert;
import org.junit.Test;

public class Mission2Test {
    @Test
    public void testExecuteMissionSuccess() throws Exception{
        Boolean result;
        Message reply = Message.decode("ok".getBytes(), 0 , 1000);
        TelloComm tc = new MockTelloComm(reply);
        Mission m2 = new Mission2(tc);
        result = m2.executeMission();
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testDoCustomizedActionNotBattery() throws Exception{
        Boolean result;
        Message reply = Message.decode("ok".getBytes(), 0 , 1000);
        DroneState ds = DroneState.getInstance();
        TelloComm tc = new MockTelloComm( reply);
        Mission m2 = new Mission2(tc);

        ds.consumeBattery(25);
        result = m2.executeMission();
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
