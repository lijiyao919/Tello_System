package Message;
import java.nio.charset.StandardCharsets;

public abstract class Message {
    private boolean valid = true;

    public static Message decode(byte[] bytes, int offset, int length) {
        Message message = null;
        MessageFactory mf;
        if (bytes!=null) {
            length = Math.min(bytes.length, offset + length);

            String data = new String(bytes, offset, length, StandardCharsets.UTF_8);
            data = data.trim();

            if (data.startsWith(Status.getKeyWord())) {
                mf = new StatusMessageFactory();
            }
            else if (data.startsWith(Command.getKeyWord()) || data.startsWith(TakeOff.getKeyWord()) || data.startsWith(Land.getKeyWord()) ||
                     data.startsWith(Left.getKeyWord()) || data.startsWith(Right.getKeyWord()) || data.startsWith(Rotate.getKeyWord())){
                mf = new CommandMessageFactory();
            }
            else if (data.startsWith(ReplyOk.getKeyWord()) || data.startsWith(ReplyError.getKeyWord())) {
                mf = new ReplyMessageFactory();
            }
            else {
                throw new UnsupportedOperationException();
            }
            message = mf.createMsg(data);
        }
        return message;
    }

    public byte[] encode() { return getMessageText().getBytes(StandardCharsets.UTF_8); }

    public abstract String getMessageType();

    public abstract String getMessageText();

    public boolean isValid() { return valid; }

    protected void setIsValid(boolean valid) { this.valid = valid; }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), getMessageText());
    }

}
