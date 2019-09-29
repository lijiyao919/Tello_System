import org.junit.Assert;
import org.junit.Test;

public class CmdHandlerTest {
    @Test
    public void testHandleCmdMsgWithValid() throws Exception {
        Message reply = testHandleCmdMsg("left 100");
        Assert.assertEquals("ok", reply.getMessageText());

    }

    @Test
    public void testHandleCmdMsgWithInvalid() throws Exception {
        Message reply = testHandleCmdMsg("left 1000");
        Assert.assertEquals("error", reply.getMessageText());

    }

    private Message testHandleCmdMsg(String cmd) throws Exception {
        //public static void main(String args[]) throws Exception{
        DroneState ds=new DroneState();
        CmdHandler ch = new CmdHandler(ds);
        TelloComm tcFlier = new TelloComm(0);
        Message request = new Left(cmd);
        byte[] cmdMsg = request.encode();
        tcFlier.sendMsg(cmdMsg, "127.0.0.1", 8889);

        ch.handleCmdMsg();

        byte[] replyMsg;
        replyMsg = tcFlier.receiveMsg();
        Message reply = Message.decode(replyMsg,0,1000);
        System.out.println(reply.getMessageText());
        return reply;
    }
}
