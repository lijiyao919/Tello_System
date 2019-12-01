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
        Boolean result = Boolean.TRUE;
        Message reply = new Reply("ok");
        TelloComm dc = new MockTelloComm(reply);
        Mission m2 = new Mission2();
        result = m2.executeMission(dc);
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testDoCustomizedActionNotBattery() throws Exception{
        Boolean result = Boolean.TRUE;
        Message reply = new Reply("ok");
        DroneState ds = DroneState.getInstance();
        TelloComm tc = new MockTelloComm( reply);
        Mission m2 = new Mission2();

        ds.consumeBattery(25);
        result = m2.executeMission(tc);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
