public class Land extends Action{
    @Override
    public byte[] doAction() {
        String request = "land";
        return convertStringToBytes(request);
    }
}