import Message.Message;
import org.junit.Test;
import org.junit.Assert;

public class UnsupportedMessageTest {
    @Test
    public void testUnsupportedMsg(){
        try {
            Message.decode("aaai".getBytes(), 0, 1000);
            Assert.fail("Expected exception here.");
        } catch (UnsupportedOperationException e) {
            //ignore
        }
    }

    @Test
    public void testUnsupportedCommandMsg(){
        try {
            Message.decode("lefted".getBytes(), 0, 1000);
            Assert.fail("Expected exception here.");
        } catch (UnsupportedOperationException e) {
            //ignore
        }
    }

    @Test
    public void testUnsupportedReplyMsg(){
        try {
            Message.decode("ok 123".getBytes(), 0, 1000);
            Assert.fail("Expected exception here.");
        } catch (UnsupportedOperationException e) {
            //ignore
        }
    }
}
