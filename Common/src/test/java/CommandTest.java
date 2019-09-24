import org.junit.Assert;
import org.junit.Test;

public class CommandTest{
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("Command", Command.getKeyWord());
    }

    @Test
    public void testGetMessageTest(){
        Message cmd = new Command();
        Assert.assertEquals("Command", cmd.getMessageText());
    }

    @Test
    public void testGetMessageType(){
        Message cmd = new Command();
        Assert.assertEquals("command", cmd.getMessageType());
    }

    @Test
    public void testEncodeAndDecodeCmdMsg(){
        Message cmd = new Command();
        byte[] encodeMsg;
        Message decodeMsg;

        encodeMsg = cmd.encode();
        decodeMsg = cmd.decode(encodeMsg, 0, 1000);

        Assert.assertEquals(cmd.getMessageText(), decodeMsg.getMessageText());

    }
}
