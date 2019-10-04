import Message.Land;
import Message.Message;
import org.junit.Assert;
import org.junit.Test;

public class LandTest{
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("land", Land.getKeyWord());
    }

    @Test
    public void testGetMessageTest(){
        Message cmd = new Land();
        Assert.assertEquals("land", cmd.getMessageText());
    }

    @Test
    public void testGetMessageType(){
        Message cmd = new Land();
        Assert.assertEquals("command", cmd.getMessageType());
    }

    @Test
    public void testEncodeAndDecodeCmdMsg(){
        Message cmd = new Land();
        byte[] encodeMsg;
        Message decodeMsg;

        encodeMsg = cmd.encode();
        decodeMsg = cmd.decode(encodeMsg, 0, 1000);

        Assert.assertEquals(cmd.getMessageText(), decodeMsg.getMessageText());

    }
}