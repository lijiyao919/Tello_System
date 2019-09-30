public class ReplyMessageFactory implements MessageFactory{

    @Override
    public Message createMsg(String data) {
        Message msg = new Reply(data);
        return msg;
    }
}
