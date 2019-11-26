package MessageFactory;

import Message.Message;
import Message.Status;

public class StatusMessageFactory implements MessageFactory {
    @Override
    public Message createMsg(String data) {
        Message msg=new Status(data);
        return msg;
    }
}
