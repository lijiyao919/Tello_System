import org.junit.Assert;
import org.junit.Test;

public class CmdHandlerTest {
    @Test
    public void testHandleCmdMsgSuccess() throws Exception {
        //public static void main(String args[]) throws Exception{
        Message cmd = new Command();
        Message left = new Left("left 100");
        DroneState ds=new DroneState();
        TelloComm tc1 = new MockTelloComm(cmd);
        TelloComm tc2 = new MockTelloComm(left);

        CmdHandler ch = new CmdHandler(ds, tc1);
        ch.handleCmdMsg();

        CmdHandler ch2 = new CmdHandler(ds, tc2);
        ch2.handleCmdMsg();

        Assert.assertEquals(Boolean.TRUE, ds.isInCommandMode());
        Assert.assertEquals(95, ds.getBatteryPercentage().intValue());

    }
}
