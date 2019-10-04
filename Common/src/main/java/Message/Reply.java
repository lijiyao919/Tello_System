package Message;

public class Reply extends Message {
    private String key;

    public Reply(String data){
        key=data;
    }

    @Override
    public String getMessageType() {
        return "reply";
    }

    @Override
    public String getMessageText() {
        return key;
    }
}
