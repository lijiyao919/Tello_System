import Message.Message;
import Message.ReplyOk;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ReplyOkTest {
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("ok", ReplyOk.getKeyWord());
    }

    @Test
    public void testConstructMsg(){
        Message cmd = Message.decode("ok".getBytes(), 0 , 1000);
        Assert.assertEquals("ReplyOk ok", cmd.toString());
        Assert.assertEquals("re", cmd.getMessageType());
        Assert.assertTrue(cmd.isValid());
    }



    @Test
    public void testEncodeMsg(){
        Message cmd = Message.decode("ok".getBytes(), 0, 1000);
        byte[] encodeMsg = cmd.encode();
        Assert.assertEquals(Arrays.toString("ok".getBytes()), Arrays.toString(encodeMsg));
    }

}
