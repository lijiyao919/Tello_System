import Message.Land;
import Message.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LandTest{
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("land", Land.getKeyWord());
    }

    @Test
    public void testConstructMsg(){
        Message cmd = Message.decode("land".getBytes(), 0 , 1000);
        Assert.assertEquals("Land land", cmd.toString());
        Assert.assertEquals("cmd", cmd.getMessageType());
        Assert.assertTrue(cmd.isValid());
    }



    @Test
    public void testEncodeMsg(){
        Message cmd = Message.decode("land".getBytes(), 0, 1000);
        byte[] encodeMsg = cmd.encode();
        Assert.assertEquals(Arrays.toString("land".getBytes()), Arrays.toString(encodeMsg));
    }

}