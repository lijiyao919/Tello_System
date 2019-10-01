import org.junit.Assert;
import org.junit.Test;

public class StatusPosterTest {
    @Test
    public void testSendStatusMsg() throws Exception{
    //public static void main(String args[]) throws Exception{
        DroneState ds = new DroneState();
        StatusPoster sp = new StatusPoster(ds);
        TelloComm tcFlier = new TelloComm(8890);

        sp.sendStatusMsg();

        String res = "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:0;roll:0;yaw:0;"+ "vgx:0;vgy:0;vgz:0;"+
                "templ:0;temph:0;"+ "tof:0;h:0;"+ "bat:100;baro:0.00;"+ "time:0;"+ "agx:0.00;agy:0.00;agz:0.00";
        byte[] msg = tcFlier.receiveMsg();
        Message msg2 = Message.decode(msg, 0, 1000);
        Assert.assertEquals(res, msg2.getMessageText());
        //System.out.println(msg2.getMessageText());

    }
}
