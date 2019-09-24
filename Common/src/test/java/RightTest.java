import org.junit.Assert;
import org.junit.Test;

public class RightTest{
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("right", Right.getKeyWord());
    }

    @Test
    public void testGetMessageTest(){
        Message cmd = new Left("right 200");
        Assert.assertEquals("right 200", cmd.getMessageText());
    }

    @Test
    public void testGetMessageType(){
        Message cmd = new Left("right 200");
        Assert.assertEquals("command", cmd.getMessageType());
    }

    @Test
    public void testEncodeAndDecodeCmdMsg(){
        Message cmd = new Right("right 200");
        byte[] encodeMsg;
        Message decodeMsg;

        encodeMsg = cmd.encode();
        decodeMsg = cmd.decode(encodeMsg, 0, 1000);

        Assert.assertEquals(cmd.getMessageText(), decodeMsg.getMessageText());

    }
}
