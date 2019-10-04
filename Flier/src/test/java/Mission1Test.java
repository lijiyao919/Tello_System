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
        Boolean result = Boolean.TRUE;
        Message reply = new Reply("ok");
        DroneState ds = new DroneState();
        TelloComm dc = new MockTelloComm(reply);
        Mission m1 = new Mission1();
        result = m1.executeMission(dc, ds);
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testDoCustomizedActionNotBattery() throws Exception{
        Boolean result = Boolean.TRUE;
        Message reply = new Reply("ok");
        DroneState ds = new DroneState();
        TelloComm tc = new MockTelloComm( reply);
        Mission m1 = new Mission1();

        ds.consumeBattery(25);
        result = m1.executeMission(tc, ds);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
