package Message;

public class TakeOff extends Message{
    private String cmd;


    protected TakeOff() {
        cmd =TakeOff.getKeyWord();
    }

    //the lang in specification
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
