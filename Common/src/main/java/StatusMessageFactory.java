public class StatusMessageFactory implements MessageFactory{
    @Override
    public Message createMsg(String data) {
        Message msg=new Status(data);
        return msg;
    }
}
