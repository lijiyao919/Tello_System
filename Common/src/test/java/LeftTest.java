import Message.Left;
import Message.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LeftTest{
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("left", Left.getKeyWord());
    }

    @Test
    public void testConstructMsgSuccess(){
        Message cmd = Message.decode("left 200".getBytes(), 0 , 1000);
        Assert.assertEquals("Left left 200.00", cmd.toString());
        Assert.assertEquals("cmd", cmd.getMessageType());
        Assert.assertTrue(cmd.isValid());
    }

    @Test
    public void testConstructMsgFailure(){
        Message cmd = Message.decode("left 700".getBytes(), 0 , 1000);
        Assert.assertEquals("Left left 700.00", cmd.toString());
        Assert.assertEquals("cmd", cmd.getMessageType());
        Assert.assertFalse(cmd.isValid());
    }


    @Test
    public void testEncodeMsg(){
        Message cmd = Message.decode("left 200".getBytes(), 0, 1000);
        byte[] encodeMsg = cmd.encode();
        Assert.assertEquals(Arrays.toString("left 200.00".getBytes()), Arrays.toString(encodeMsg));
    }

}

