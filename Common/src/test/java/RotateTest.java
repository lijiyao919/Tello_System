import Message.Message;
import Message.Rotate;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RotateTest{
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("cw", Rotate.getKeyWord());
    }

    @Test
    public void testConstructMsgSuccess(){
        Message cmd = Message.decode("cw 360".getBytes(), 0 , 1000);
        Assert.assertEquals("Rotate cw 360.00", cmd.toString());
        Assert.assertEquals("cmd", cmd.getMessageType());
        Assert.assertTrue(cmd.isValid());
    }

    @Test
    public void testConstructMsgFailure(){
        Message cmd = Message.decode("cw 700".getBytes(), 0 , 1000);
        Assert.assertEquals("Rotate cw 700.00", cmd.toString());
        Assert.assertEquals("cmd", cmd.getMessageType());
        Assert.assertFalse(cmd.isValid());
    }


    @Test
    public void testEncodeMsg(){
        Message cmd = Message.decode("cw 700".getBytes(), 0, 1000);
        byte[] encodeMsg = cmd.encode();
        Assert.assertEquals(Arrays.toString("cw 700.00".getBytes()), Arrays.toString(encodeMsg));
    }



}