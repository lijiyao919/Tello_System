package Message;

public class Command extends Message {
    private String cmd;

    //the lang in specification
    protected Command() {
        cmd ="command";
    }

    //the lang of the software itself
    public static String getKeyWord() {
        return "command";
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

