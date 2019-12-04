package Message;

public class ReplyOk extends Reply{

    protected ReplyOk() {
        super("ok");
    }

    //the lang in specification
    public static String getKeyWord() { return "ok"; }

    //the lang of the software itself
    @Override
    public String getMessageText() {
        return "ok";
    }

}
