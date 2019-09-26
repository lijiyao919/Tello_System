import org.junit.Assert;
import org.junit.Test;
import java.net.*;

public class Mission2Test {
    @Test
    public void testExecuteMission() throws Exception{
        Boolean result = Boolean.TRUE;
        TelloComm dc = new TelloComm(0);
        Mission m2 = new Mission2();
        result = m2.executeMission(dc);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
