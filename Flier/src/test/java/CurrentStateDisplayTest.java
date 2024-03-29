import Observer.CurrentStateDisplay;
import State.DroneState;
import Message.Status;
import Message.Message;
import org.junit.Test;

public class CurrentStateDisplayTest {
    @Test
    public void testCurrentStateUpdateAndDisplay(){
        DroneState ds =DroneState.getInstance();
        ds.setInCommandMode(true);
        CurrentStateDisplay csd = new CurrentStateDisplay();
        String msg="mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:0;roll:0;yaw:0;"+
                "vgx:0;vgy:0;vgz:0;"+
                "templ:0;temph:0;"+
                "tof:0;h:0;"+
                "bat:100;baro:0;"+
                "time:0;"+
                "agx:0;agy:%s;agz:0";
        Status sta = (Status) Message.decode(msg.getBytes(), 0 , 1000);
        ds.updateFlyingInfo(sta);

    }
}
