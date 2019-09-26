import org.junit.Assert;
import org.junit.Test;

import java.net.InetAddress;
import java.util.Arrays;

public class TelloCommTest {
    @Test
    public void testSendAndReceiveMsg() throws Exception {
    //public static void main(String args[]) throws Exception{
        TelloComm dc1 = new TelloComm(InetAddress.getByName("127.0.0.1"), 0);
        TelloComm dc2 = new TelloComm(InetAddress.getByName("127.0.0.1"), 8890);
        byte[] cmdSend = new byte[64];
        byte[] cmdRec;

        cmdSend[0] = 99;
        cmdSend[1] = 111;
        cmdSend[2] = 109;
        dc1.sendMsg(cmdSend, "127.0.0.1", 8890);
        Thread.sleep(1000);

        System.out.println(Arrays.toString(cmdSend));
        cmdRec = dc2.receiveMsg();
        System.out.println(Arrays.toString(cmdRec));
        Assert.assertArrayEquals(cmdSend, cmdRec);
    }

}
