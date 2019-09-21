public class Rotate360 extends Action{
    @Override
    public byte[] doAction() {
        String request = "cw 360";
        return convertStringToBytes(request);
    }
}