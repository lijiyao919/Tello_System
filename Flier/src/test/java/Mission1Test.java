import org.junit.Assert;
import org.junit.Test;
import java.net.*;

public class Mission1Test {
    @Test
    public void testExecuteMission() throws Exception{
        Boolean result = Boolean.TRUE;
        DroneState ds = new DroneState();
        TelloComm dc = new TelloComm( 0);
        Mission m1 = new Mission1();
        result = m1.executeMission(dc, ds);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
