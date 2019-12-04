package Message;

public class TakeOff extends Message{
    private String cmd;

    //the lang in specification
    protected TakeOff() {
        cmd ="takeoff";
    }

    //the lang of the software itself
    public static String getKeyWord() {
        return "takeoff";
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
