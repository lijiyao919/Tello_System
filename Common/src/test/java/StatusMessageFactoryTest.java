import Message.Message;
import Message.Status;
import MessageFactory.MessageFactory;
import MessageFactory.StatusMessageFactory;
import org.junit.Assert;
import org.junit.Test;

public class StatusMessageFactoryTest {
    @Test
    public void testStatusMessage() {
        MessageFactory mf = new StatusMessageFactory();
        Message msg = mf.createMsg("height:10");
        Assert.assertTrue(msg instanceof Status);
    }
}
