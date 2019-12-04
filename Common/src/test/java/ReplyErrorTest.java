import Message.Message;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import Message.ReplyError;

public class ReplyErrorTest {
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("error", ReplyError.getKeyWord());
    }

    @Test
    public void testConstructMsg(){
        Message cmd = Message.decode("error".getBytes(), 0 , 1000);
        Assert.assertEquals("ReplyError error", cmd.toString());
        Assert.assertEquals("re", cmd.getMessageType());
        Assert.assertTrue(cmd.isValid());
    }



    @Test
    public void testEncodeMsg(){
        Message cmd = Message.decode("error".getBytes(), 0, 1000);
        byte[] encodeMsg = cmd.encode();
        Assert.assertEquals(Arrays.toString("error".getBytes()), Arrays.toString(encodeMsg));
    }
}
