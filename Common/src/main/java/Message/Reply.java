package Message;

public abstract class Reply extends Message {
    protected String ack;

    protected Reply(String ack) {
        this.ack = ack;
    }

    @Override
    public String getMessageType() {
        return "re";
    }
}
