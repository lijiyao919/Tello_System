public class Command extends Message{
    private String cmd ="command";

    public static String getKeyWord() { return "command"; }

    @Override
    public String getMessageType() {
        return "command";
    }

    @Override
    public String getMessageText() {
        return cmd;
    }
}

