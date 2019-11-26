import Message.Message;
import Message.Reply;
import MessageFactory.MessageFactory;
import MessageFactory.ReplyMessageFactory;
import org.junit.Assert;
import org.junit.Test;

public class ReplyMessageFactoryTest {
    @Test
    public void testReplyMessage() {
        MessageFactory mf = new ReplyMessageFactory();
        Message msg = mf.createMsg("reply ok");
        Assert.assertTrue(msg instanceof Reply);
    }
}
