package Message;

public class ReplyMessageFactory extends MessageFactory {
    @Override
    protected Message createMsg(String data) {
        Message msg=null;

        if (data.equals(ReplyOk.getKeyWord())) {
            msg = new ReplyOk();
        }
        else if (data.equals(ReplyError.getKeyWord())) {
            msg = new ReplyError();
        }
        else {
            throw new UnsupportedOperationException();
        }
        return msg;
    }
}
