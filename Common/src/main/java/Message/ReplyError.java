package Message;

public class ReplyError extends Reply{

    protected ReplyError() {
        super(ReplyError.getKeyWord());
    }

    //the lang in specification
    public static String getKeyWord() { return "error"; }


    @Override
    public String getMessageText() {
        return ReplyError.getKeyWord();
    }

}
