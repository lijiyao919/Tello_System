package Message;

public class Right extends Message{
    private String cmd;

    public static String getKeyWord() { return "right"; }

    public Right(String data){
        cmd = data;
        checkValues();
    }

    private void checkValues(){
        String[] cmdFields = cmd.trim().split(" ");
        double value = Double.parseDouble(cmdFields[1]);
        if(value<20 || value>500 ){
            setIsValid(Boolean.FALSE);
        }
    }

    @Override
    public String getMessageType() {
        return "command";
    }

    @Override
    public String getMessageText() {
        return cmd;
    }
}