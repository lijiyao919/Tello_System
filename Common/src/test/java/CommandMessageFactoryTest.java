import Message.Message;
import MessageFactory.MessageFactory;
import MessageFactory.CommandMessageFactory;
import static org.junit.Assert.*;
import Message.Command;
import Message.Land;
import Message.Left;
import Message.Right;
import Message.Rotate;
import Message.TakeOff;
import org.junit.Assert;
import org.junit.Test;

public class CommandMessageFactoryTest {
    @Test
    public void testCommandMessage() {
        MessageFactory mf = new CommandMessageFactory();
        Message msg = mf.createMsg("command");
        Assert.assertTrue(msg instanceof Command);
    }

    @Test
    public void testLandMessage() {
        MessageFactory mf = new CommandMessageFactory();
        Message msg = mf.createMsg("land");
        Assert.assertTrue(msg instanceof Land);
    }

    @Test
    public void testLeftMessage() {
        MessageFactory mf = new CommandMessageFactory();
        Message msg = mf.createMsg("left 10");
        Assert.assertTrue(msg instanceof Left);
    }

    @Test
    public void testRightMessage() {
        MessageFactory mf = new CommandMessageFactory();
        Message msg = mf.createMsg("right 10");
        Assert.assertTrue(msg instanceof Right);
    }

    @Test
    public void testRotateMessage() {
        MessageFactory mf = new CommandMessageFactory();
        Message msg = mf.createMsg("cw 360");
        Assert.assertTrue(msg instanceof Rotate);
    }

    @Test
    public void testTakeoffMessage() {
        MessageFactory mf = new CommandMessageFactory();
        Message msg = mf.createMsg("takeoff");
        Assert.assertTrue(msg instanceof TakeOff);
    }

    @Test
    public void testUnsupportedCommandMessage() {
        try {
            MessageFactory mf = new CommandMessageFactory();
            mf.createMsg("aaai");
            fail("Expect exception here.");
        }catch(UnsupportedOperationException e){
            //ignore
        }
    }
}
