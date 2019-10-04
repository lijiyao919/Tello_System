import Message.Message;
import Message.TakeOff;
import org.junit.Assert;
import org.junit.Test;

public class TakeOffTest{
    @Test
    public void testGetKeyWord(){
        Assert.assertEquals("takeoff", TakeOff.getKeyWord());
    }

    @Test
    public void testGetMessageTest(){
        Message cmd = new TakeOff();
        Assert.assertEquals("takeoff", cmd.getMessageText());
    }

    @Test
    public void testGetMessageType(){
        Message cmd = new TakeOff();
        Assert.assertEquals("command", cmd.getMessageType());
    }

    @Test
    public void testEncodeAndDecodeCmdMsg(){
        Message cmd = new TakeOff();
        byte[] encodeMsg;
        Message decodeMsg;

        encodeMsg = cmd.encode();
        decodeMsg = cmd.decode(encodeMsg, 0, 1000);

        Assert.assertEquals(cmd.getMessageText(), decodeMsg.getMessageText());

    }
}

