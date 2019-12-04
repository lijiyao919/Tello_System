package Message;

public class Command extends Message {
    private String cmd;


    protected Command() {
        cmd = Command.getKeyWord();
    }

    //the lang in specification
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

