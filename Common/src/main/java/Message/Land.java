package Message;

public class Land extends Message{
    private String cmd;

    protected Land() {
        cmd =Land.getKeyWord();
    }

    //the lang in specification.
    public static String getKeyWord() {
        return "land";
    }

    @Override
    public String getMessageType() {
        return "cmd";
    }

    @Override
    public String getMessageText() {
        return cmd;
    }
}
