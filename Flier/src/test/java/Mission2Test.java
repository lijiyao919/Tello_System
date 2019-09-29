import org.junit.Assert;
import org.junit.Test;
import java.net.*;

public class Mission2Test {
    @Test
    public void testExecuteMission() throws Exception{
        Boolean result = Boolean.TRUE;
        DroneState ds = new DroneState();
        TelloComm dc = new TelloComm(0);
        Mission m2 = new Mission2();
        result = m2.executeMission(dc,ds);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
