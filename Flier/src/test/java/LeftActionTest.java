import Action.Action;
import Action.ActionFactory;
import Action.ActionImpFactory;
import Communicator.TelloComm;
import Message.Message;
import Mock.MockTelloComm;
import org.junit.Assert;
import org.junit.Test;

public class LeftActionTest {
    @Test
    public void testExecuteSuccess() throws Exception {
        Message reply = Message.decode("ok".getBytes(), 0 , 1000);
        TelloComm tc = new MockTelloComm(reply);
        ActionFactory actFactory = new ActionImpFactory();
        Action act = actFactory.create("left 200", tc);
        Assert.assertTrue(act.execute());
    }

    @Test
    public void testExecuteWithNoReply() throws Exception {
        TelloComm tc = new MockTelloComm(null);
        ActionFactory actFactory = new ActionImpFactory();
        Action act = actFactory.create("left 200", tc);
        Assert.assertFalse(act.execute());
    }

    @Test
    public void testExecuteWithWithErrorReply() throws Exception {
        Message reply = Message.decode("error".getBytes(), 0 , 1000);
        TelloComm tc = new MockTelloComm(reply);
        ActionFactory actFactory = new ActionImpFactory();
        Action act = actFactory.create("left 200", tc);
        Assert.assertFalse(act.execute());
    }
}
