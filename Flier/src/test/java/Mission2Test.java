import org.junit.Assert;
import org.junit.Test;
import java.net.*;

public class Mission2Test {
    @Test
    public void testExecuteMissionSuccess() throws Exception{
        Boolean result = Boolean.TRUE;
        Message reply = new Reply("ok");
        DroneState ds = new DroneState();
        TelloComm dc = new MockTelloComm(reply);
        Mission m2 = new Mission2();
        result = m2.executeMission(dc, ds);
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testDoCustomizedActionNotBattery() throws Exception{
        Boolean result = Boolean.TRUE;
        Message reply = new Reply("ok");
        DroneState ds = new DroneState();
        TelloComm tc = new MockTelloComm( reply);
        Mission m2 = new Mission2();

        ds.consumeBattery(25);
        result = m2.executeMission(tc, ds);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
