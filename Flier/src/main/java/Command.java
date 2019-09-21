public class Command extends Action{
    @Override
    public byte[] doAction() {
        String request = "command";
        return convertStringToBytes(request);
    }
}
