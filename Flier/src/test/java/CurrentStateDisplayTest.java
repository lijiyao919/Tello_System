import org.junit.Test;

public class CurrentStateDisplayTest {
    @Test
    public void testCurrentStateUpdateAndDisplay(){
    //public static void main(String args[]){
        DroneState ds =new DroneState();
        ds.setInCommandMode(true);
        CurrentStateDisplay csd = new CurrentStateDisplay(ds);
        String msg="mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:%s;roll:%s;yaw:%s;"+
                "vgx:%s;vgy:%s;vgz:%s;"+
                "templ:%s;temph:%s;"+
                "tof:%s;h:%s;"+
                "bat:%s;baro:%s;"+
                "time:%s;"+
                "agx:%s;agy:%s;agz:%s";
        Status sta = new Status(msg);
        ds.updateFlyingInfo(sta);

    }
}
