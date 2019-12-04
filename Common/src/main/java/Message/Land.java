package Message;

public class Land extends Message{
    private String cmd;

    //the lang in specification.
    protected Land() {
        cmd ="land";
    }

    //the lang of the software itself.
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
