package Message;

public class TakeOff extends Message{
    private String cmd ="takeoff";

    public static String getKeyWord() { return "takeoff"; }

    @Override
    public String getMessageType() {
        return "command";
    }

    @Override
    public String getMessageText() {
        return cmd;
    }
}
