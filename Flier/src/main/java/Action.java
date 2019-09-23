import java.nio.charset.StandardCharsets;

public abstract class Action {
    public byte[] doAction(){
        byte[] bytes;
        String req;

        req = getRequest();
        bytes = req.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }
    public abstract String getRequest();
}
