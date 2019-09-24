import org.junit.Assert;
import org.junit.Test;

public class ReplyTest{

    @Test
    public void testGetMessageTest(){
        Message cmd = new Reply("ok");
        Assert.assertEquals("ok", cmd.getMessageText());
    }

    @Test
    public void testGetMessageType(){
        Message cmd = new Reply("ok");
        Assert.assertEquals("reply", cmd.getMessageType());
    }

    @Test
    public void testEncodeAndDecodeCmdMsg(){
        Message cmd = new Reply("ok");
        byte[] encodeMsg;
        Message decodeMsg;

        encodeMsg = cmd.encode();
        decodeMsg = cmd.decode(encodeMsg, 0, 1000);

        Assert.assertEquals(cmd.getMessageText(), decodeMsg.getMessageText());

    }
}
