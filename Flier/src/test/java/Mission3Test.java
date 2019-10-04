import org.junit.Assert;
import org.junit.Test;
import java.net.*;

public class Mission3Test {
    @Test
    public void testExecuteMissionSuccess() throws Exception{
        Boolean result = Boolean.TRUE;
        Message reply = new Reply("ok");
        DroneState ds = new DroneState();
        TelloComm dc = new MockTelloComm(reply);
        Mission m3 = new Mission3();
        result = m3.executeMission(dc, ds);
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testDoCustomizedActionNotBattery() throws Exception{
        Boolean result = Boolean.TRUE;
        Message reply = new Reply("ok");
        DroneState ds = new DroneState();
        TelloComm tc = new MockTelloComm( reply);
        Mission m3 = new Mission3();

        ds.consumeBattery(40);
        result = m3.executeMission(tc, ds);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
