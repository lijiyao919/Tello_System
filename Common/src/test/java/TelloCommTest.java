import org.junit.Assert;
import org.junit.Test;

import java.net.InetAddress;

public class TelloCommTest {
    @Test
    public void testSendMsg() throws Exception {
        TelloComm dc = new TelloComm(InetAddress.getByName("127.0.0.1"), 8889);
        byte[] cmd = new byte[]{99, 111, 109, 109, 97, 110, 100};
        dc.sendMsg(cmd);
    }

    @Test
    public void testReceiveMsg() throws Exception {
        TelloComm dc = new TelloComm(InetAddress.getByName("127.0.0.1"), 8889);
        byte[] cmd = new byte[]{99, 111, 109, 109, 97, 110, 100};
        Boolean result = Boolean.FALSE;
        dc.sendMsg(cmd);

        result = dc.receiveMsg();
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
