import org.junit.Assert;
import org.junit.Test;
import java.net.*;

public class Mission1Test {
    @Test
    public void testExecuteMission() throws Exception{
        Boolean result = Boolean.TRUE;
        TelloComm dc = new TelloComm(InetAddress.getByName("127.0.0.1"), 8889);
        Mission m1 = new Mission1();
        result = m1.executeMission(dc);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
