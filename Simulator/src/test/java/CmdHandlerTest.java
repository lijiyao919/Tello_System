import Command.CmdHandler;
import Communicator.TelloComm;
import Mock.MockTelloComm;
import State.DroneState;
import Message.Left;
import Message.Command;
import Message.Message;
import org.junit.Assert;
import org.junit.Test;

public class CmdHandlerTest {
    @Test
    public void testHandleCmdMsgSuccess() throws Exception {
        Message cmd = Message.decode("command".getBytes(), 0, 1000);
        Message left = Message.decode("left 100".getBytes(), 0, 1000);
        DroneState ds = DroneState.getInstance();
        TelloComm tc1 = new MockTelloComm(cmd);
        TelloComm tc2 = new MockTelloComm(left);

        CmdHandler ch = new CmdHandler(tc1);
        ch.handleCmdMsg();

        CmdHandler ch2 = new CmdHandler(tc2);
        ch2.handleCmdMsg();

        Assert.assertEquals(Boolean.TRUE, ds.isInCommandMode());
        Assert.assertEquals(95, ds.getBatteryPercentage().intValue());

    }
}
