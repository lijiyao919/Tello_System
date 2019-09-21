public class Left200 extends Action{
    @Override
    public byte[] doAction() {
        String request = "left 200";
        return convertStringToBytes(request);
    }
}