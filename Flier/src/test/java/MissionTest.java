import Communicator.TelloComm;
import Mission.Mission;
import Mission.Mission1;
import Mock.MockTelloComm;
import State.DroneState;
import Message.Command;
import Message.Reply;
import Message.Message;
import org.junit.Assert;
import org.junit.Test;

public class MissionTest {

    @Test
    public void testExecuteBasicActionErrorReply() throws Exception{
        Message reply = Message.decode("error".getBytes(), 0 , 1000);
        Message cmd = Message.decode("command".getBytes(), 0 , 1000);
        TelloComm tc= new MockTelloComm(reply);
        Mission m1 = new Mission1();
        Boolean res;

        res = m1.executeBasicAction(tc,cmd);

        Assert.assertEquals(Boolean.FALSE, res);
    }

    @Test
    public void testExecuteBasicActionNullMsg() throws Exception{
        Message cmd = Message.decode("command".getBytes(), 0 , 1000);
        TelloComm tc= new MockTelloComm(null);
        Mission m1 = new Mission1();
        Boolean res;

        res = m1.executeBasicAction(tc,cmd);

        Assert.assertEquals(Boolean.FALSE, res);
    }


    @Test
    public void testTakeoffNotBattery() throws Exception{
        Message reply = Message.decode("ok".getBytes(), 0 , 1000);
        TelloComm tc= new MockTelloComm(reply);
        DroneState ds = DroneState.getInstance();
        ds.consumeBattery(50);
        Mission m1 = new Mission1();
        Boolean res;

        res = m1.executeMission(tc);

        Assert.assertTrue(res);
    }
}
