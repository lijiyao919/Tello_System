public class Takeoff extends Action{
    @Override
    public byte[] doAction() {
        String request = "takeoff";
        return convertStringToBytes(request);
    }
}
