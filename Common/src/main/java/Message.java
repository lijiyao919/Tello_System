import java.nio.charset.StandardCharsets;

public abstract class Message {
    private boolean valid = true;

    public static Message decode(byte[] bytes, int offset, int length) {
        Message message = null;
        if (bytes!=null) {
            length = Math.min(bytes.length, offset + length);

            String data = new String(bytes, offset, length, StandardCharsets.UTF_8);
            data = data.trim();

            if (data.startsWith(Status.getKeyWord()))
                message = new Status(data);
            else if (data.startsWith(Command.getKeyWord()))
                message = new Command();
            else if (data.startsWith(TakeOff.getKeyWord()))
                message = new TakeOff();
            else if (data.startsWith(Land.getKeyWord()))
                message = new Land();
            else if (data.startsWith(Left.getKeyWord()))
                message = new Left(data);
            else if (data.startsWith(Right.getKeyWord()))
                message = new Right(data);
            else if (data.startsWith(Rotate.getKeyWord()))
                message = new Rotate(data);
            else
                message = new Reply(data);

            // TODO: decode all of the other kinds of messages based on what the message starts with.  If it doesn't
            //       start with a recognized key work, assume it is an info message (i.e., a reply to a query)
        }
        return message;
    }

    public byte[] encode() { return getMessageText().getBytes(StandardCharsets.UTF_8); }

    public abstract String getMessageType();

    protected String getMessageText() { return getMessageType(); }

    public boolean isValid() { return valid; }

    protected void setIsValid(boolean valid) { this.valid = valid; }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), getMessageText());
    }

}
