import Message.Message;
import Message.Command;
import org.junit.Assert;
import org.junit.Test;

public class CommandTest{
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("Message.Message.Command", Command.getKeyWord());
    }

    @Test
    public void testGetMessageTest(){
        Message cmd = new Command();
        Assert.assertEquals("Message.Message.Command", cmd.getMessageText());
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
