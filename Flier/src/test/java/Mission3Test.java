import org.junit.Assert;
import org.junit.Test;
import java.net.*;

public class Mission3Test {
    @Test
    public void testExecuteMission() throws Exception{
        Boolean result = Boolean.TRUE;
        TelloComm dc = new TelloComm(InetAddress.getByName("127.0.0.1"), 8889);
        Mission m3 = new Mission3();
        result = m3.executeMission(dc);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
