import Message.Message;
import Message.Command;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class CommandTest{

    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("command", Command.getKeyWord());
    }

    @Test
    public void testConstructMsg(){
        Message cmd = Message.decode("command".getBytes(), 0 , 1000);
        Assert.assertEquals("Command command", cmd.toString());
        Assert.assertEquals("cmd", cmd.getMessageType());
        Assert.assertTrue(cmd.isValid());
    }

    @Test
    public void testEncodeMsg(){
        Message cmd = Message.decode("command".getBytes(), 0, 1000);
        byte[] encodeMsg = cmd.encode();
        Assert.assertEquals(Arrays.toString("command".getBytes()), Arrays.toString(encodeMsg));
    }

}
