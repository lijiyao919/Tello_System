package MessageFactory;

import Message.Message;

public interface MessageFactory {
    public abstract Message createMsg(String data) throws UnsupportedOperationException;
}
