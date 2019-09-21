import java.nio.charset.StandardCharsets;

public abstract class Action {
    protected byte[] convertStringToBytes(String req){
        byte[] bytes;
        bytes = req.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }
    public abstract byte[] doAction();
}
