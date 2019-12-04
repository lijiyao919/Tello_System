package Message;

public class Left extends Message{
    private String cmd;

    //the lang in specification.
    public static String getKeyWord() {
        return "left";
    }

    protected Left(double value){
        cmd = Left.getKeyWord() + " " + StringUtils.formatDouble(value);
        checkValues(value);
    }

    private void checkValues(double value){
        if(value<20 || value>500 ){
            setIsValid(Boolean.FALSE);
        }
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