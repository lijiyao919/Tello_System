package Message;

public class ReplyOk extends Reply{

    protected ReplyOk() {
        super(ReplyOk.getKeyWord());
    }

    //the lang in specification
    public static String getKeyWord() { return "ok"; }

    @Override
    public String getMessageText() {
        return ReplyOk.getKeyWord();
    }

}
