import org.junit.Assert;
import org.junit.Test;
import java.net.*;

public class Mission3Test {
    @Test
    public void testExecuteMission() throws Exception{
        Boolean result = Boolean.TRUE;
        TelloComm dc = new TelloComm(0);
        DroneState ds = new DroneState();
        Mission m3 = new Mission3();
        result = m3.executeMission(dc, ds);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
