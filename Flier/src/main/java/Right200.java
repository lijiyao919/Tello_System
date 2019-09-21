public class Right200 extends Action{
    @Override
    public byte[] doAction() {
        String request = "right 100";
        return convertStringToBytes(request);
    }
}