import Action.Action;
import Action.ActionFactory;
import Action.ActionImpFactory;
import Action.CommandAction;
import Action.TakeOffAction;
import Action.LeftAction;
import Action.RightAction;
import Action.RotateAction;
import Action.LandAction;
import Communicator.TelloComm;
import Message.Message;
import Mock.MockTelloComm;
import org.junit.Assert;
import org.junit.Test;

public class ActionImpFactoryTest {
    @Test
    public void testCreateSuccess() throws Exception {
        Message reply = Message.decode("ok".getBytes(), 0 , 1000);
        TelloComm tc = new MockTelloComm(reply);
        ActionFactory actFactory = new ActionImpFactory();
        Action act = actFactory.create("command", tc);
        Assert.assertTrue(act instanceof CommandAction);

        act = actFactory.create("takeoff", tc);
        Assert.assertTrue(act instanceof TakeOffAction);

        act = actFactory.create("left 200", tc);
        Assert.assertTrue(act instanceof LeftAction);

        act = actFactory.create("right 200", tc);
        Assert.assertTrue(act instanceof RightAction);

        act = actFactory.create("rotate 360", tc);
        Assert.assertTrue(act instanceof RotateAction);

        act = actFactory.create("land", tc);
        Assert.assertTrue(act instanceof LandAction);
    }

    @Test
    public void testCreateFailure() throws Exception{
        try{
            Message reply = Message.decode("ok".getBytes(), 0 , 1000);
            TelloComm tc = new MockTelloComm(reply);
            ActionFactory actFactory = new ActionImpFactory();
            actFactory.create("aaai", tc);
            Assert.fail("Expected exception here.");
        } catch (UnsupportedOperationException e){
            //ignore
        }
    }
}
