import org.junit.Assert;
import org.junit.Test;

import java.net.InetAddress;
import java.util.Arrays;

public class TelloCommTest {
    @Test
    public void testSendAndReceiveMsg() throws Exception {
    //public static void main(String args[]) throws Exception{
        TelloComm dc = new TelloComm(InetAddress.getByName("127.0.0.1"), 8890);
        byte[] cmdSend = new byte[]{99, 111, 109, 109, 97, 110, 100};
        byte[] cmdRec = new byte[64];
        dc.sendMsg(cmdSend);
        Thread.sleep(1000);


        System.out.println(Arrays.toString(cmdSend));
        dc.receiveMsg(cmdRec);
        System.out.println(Arrays.toString(cmdRec));
        //Assert.assertArrayEquals(cmdSend, cmdRec);
    }

}
