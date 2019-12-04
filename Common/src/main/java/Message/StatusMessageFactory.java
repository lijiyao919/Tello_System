package Message;

public class StatusMessageFactory extends MessageFactory {
    @Override
    protected Message createMsg(String data) {
        Message msg=new Status(data);
        return msg;
    }
}
