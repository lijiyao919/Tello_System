package Message;

public abstract class MessageFactory {
    protected abstract Message createMsg(String data) throws UnsupportedOperationException;
}
