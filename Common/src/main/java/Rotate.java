public class Rotate extends Message{
    private String cmd;

    public static String getKeyWord() { return "cw"; }

    public Rotate(String data){
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