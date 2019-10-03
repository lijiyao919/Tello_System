import org.junit.Assert;
import org.junit.Test;

public class RotateTest{
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("cw", Rotate.getKeyWord());
    }

    @Test
    public void testGetMessageTest(){
        Message cmd = new Rotate("cw 360");
        Assert.assertEquals("cw 360", cmd.getMessageText());
    }

    @Test
    public void testGetMessageType(){
        Message cmd = new Rotate("cw 360");
        Assert.assertEquals("command", cmd.getMessageType());
    }

    @Test
    public void testEncodeAndDecodeCmdMsg(){
        Message cmd = new Rotate("cw 360");
        byte[] encodeMsg;
        Message decodeMsg;

        encodeMsg = cmd.encode();
        decodeMsg = Message.decode(encodeMsg, 0, 1000);

        Assert.assertEquals(cmd.getMessageText(), decodeMsg.getMessageText());

    }

    @Test
    public void testConstructWithInvalidParameter(){
        Message cmd = new Rotate("cw 600");
        Assert.assertEquals(Boolean.FALSE, cmd.isValid());
    }
}