import org.junit.Assert;
import org.junit.Test;

public class LeftTest{
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("left", Left.getKeyWord());
    }

    @Test
    public void testGetMessageText(){
        Message cmd = new Left("left 200");
        Assert.assertEquals("left 200", cmd.getMessageText());
    }

    @Test
    public void testGetMessageType(){
        Message cmd = new Left("left 200");
        Assert.assertEquals("command", cmd.getMessageType());
    }

    @Test
    public void testEncodeAndDecodeCmdMsg(){
        Message cmd = new Left("left 200");
        byte[] encodeMsg;
        Message decodeMsg;

        encodeMsg = cmd.encode();
        decodeMsg = cmd.decode(encodeMsg, 0, 1000);

        Assert.assertEquals(cmd.getMessageText(), decodeMsg.getMessageText());

    }

    @Test
    public void testConstructWithInvalidParameter(){
        Message cmd = new Left("left 700");
        Assert.assertEquals(Boolean.FALSE, cmd.isValid());
    }

}

