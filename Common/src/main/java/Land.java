public class Land extends Message{
    private String cmd ="land";

    public static String getKeyWord() { return "land"; }

    @Override
    public String getMessageType() {
        return "command";
    }

    @Override
    public String getMessageText() {
        return cmd;
    }
}
