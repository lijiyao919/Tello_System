import Message.Message;
import Message.Right;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RightTest{
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("right", Right.getKeyWord());
    }

    @Test
    public void testConstructMsgSuccess(){
        Message cmd = Message.decode("right 200".getBytes(), 0 , 1000);
        Assert.assertEquals("Right right 200.00", cmd.toString());
        Assert.assertEquals("cmd", cmd.getMessageType());
        Assert.assertTrue(cmd.isValid());
    }

    @Test
    public void testConstructMsgFailure(){
        Message cmd = Message.decode("right 700".getBytes(), 0 , 1000);
        Assert.assertEquals("Right right 700.00", cmd.toString());
        Assert.assertEquals("cmd", cmd.getMessageType());
        Assert.assertFalse(cmd.isValid());
    }


    @Test
    public void testEncodeMsg(){
        Message cmd = Message.decode("right 200".getBytes(), 0, 1000);
        byte[] encodeMsg = cmd.encode();
        Assert.assertEquals(Arrays.toString("right 200.00".getBytes()), Arrays.toString(encodeMsg));
    }

}
