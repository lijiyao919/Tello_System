public class CmdHandler {
    TelloComm tc;

    public CmdHandler() throws Exception{
        tc = new TelloComm(8889);
    }

    public void handleCmdMsg() throws Exception {
        byte[] msg;
        Message reply = new Reply("error");

        msg = tc.receiveMsg();
        if(msg != null) {
            Message cmdMsg = Message.decode(msg, 0, 1000);
            System.out.println(cmdMsg.getMessageText());
            if (tc.getSrcAddress() != null && tc.getSrcPort() >= 0) {
                if (cmdMsg.isValid()) {
                    reply = new Reply("ok");
                }
                byte[] replyMsg = reply.encode();
                tc.sendMsg(replyMsg, tc.getSrcAddress().getHostAddress(), tc.getSrcPort());
            }
        }
    }



}
