package Message;

public class ReplyError extends Reply{

    protected ReplyError() {
        super("error");
    }

    //the lang in specification
    public static String getKeyWord() { return "error"; }

    //the lang of the software itself
    @Override
    public String getMessageText() {
        return "error";
    }

}
