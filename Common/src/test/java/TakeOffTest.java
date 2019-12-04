import Message.Message;
import Message.TakeOff;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TakeOffTest{
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("takeoff", TakeOff.getKeyWord());
    }

    @Test
    public void testConstructMsg(){
        Message cmd = Message.decode("takeoff".getBytes(), 0 , 1000);
        Assert.assertEquals("TakeOff takeoff", cmd.toString());
        Assert.assertEquals("cmd", cmd.getMessageType());
        Assert.assertTrue(cmd.isValid());
    }



    @Test
    public void testEncodeMsg(){
        Message cmd = Message.decode("takeoff".getBytes(), 0, 1000);
        byte[] encodeMsg = cmd.encode();
        Assert.assertEquals(Arrays.toString("takeoff".getBytes()), Arrays.toString(encodeMsg));
    }
}

