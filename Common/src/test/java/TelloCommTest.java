import Communicator.TelloComm;
import org.junit.Assert;
import org.junit.Test;

public class TelloCommTest {
    @Test
    public void testSendAndReceiveMsg() throws Exception {
    //public static void main(String args[]) throws Exception{
        TelloComm dc1 = new TelloComm(8889);
        TelloComm dc2 = new TelloComm(8890);
        byte[] cmdSend = new byte[1024];
        byte[] cmdRec;

        cmdSend[0] = 99;
        cmdSend[1] = 111;
        cmdSend[2] = 109;
        dc1.sendMsg(cmdSend, "127.0.0.1", 8890);
        Thread.sleep(1000);

        //System.out.println(Arrays.toString(cmdSend));
        cmdRec = dc2.receiveMsg();
        //System.out.println(Arrays.toString(cmdRec));
        //System.out.println(dc2.getSrcAddress().toString());
        Assert.assertArrayEquals(cmdSend, cmdRec);
        Assert.assertEquals("/127.0.0.1", dc2.getSrcAddress().toString());
        Assert.assertEquals(8889, dc2.getSrcPort());
    }

    @Test
    public void receiveMsgTimeout() throws Exception{
        TelloComm dc1 = new TelloComm();
        byte[] cmdRec;
        cmdRec = dc1.receiveMsg();
        Assert.assertEquals(null, cmdRec);

    }

}
