import org.junit.Assert;
import org.junit.Test;

public class StateMonitorTest {
    @Test
    public void testUpdate() throws Exception{
        byte[] encodeMsg;
        String stat = "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:10;roll:60;yaw:30;"+
                "vgx:20;vgy:20;vgz:20;"+
                "templ:70;temph:100;"+
                "tof:100;h:50;"+
                "bat:70;baro:30.00;"+
                "time:50;"+
                "agx:10.00;agy:10.00;agz:10.10";
        Message staMsg = new Status(stat);
        TelloComm tc = new MockTelloComm(staMsg);
        DroneState ds = new DroneState();
        StateMonitor sm = new StateMonitor(ds, tc);

        ds.setInCommandMode(true);
        sm.updateDroneState();

        Assert.assertEquals(10, ds.getPitch().intValue());
        Assert.assertEquals(60, ds.getRoll().intValue());
        Assert.assertEquals(30, ds.getYaw().intValue());
        Assert.assertEquals(20, ds.getSpeedX().intValue());
        Assert.assertEquals(20, ds.getSpeedY().intValue());
        Assert.assertEquals(20, ds.getSpeedZ().intValue());
        Assert.assertEquals(70, ds.getLowTemperature().intValue());
        Assert.assertEquals(100, ds.getHighTemperature().intValue());
        Assert.assertEquals(100, ds.getFlightDistance().intValue());
        Assert.assertEquals(50, ds.getHeight().intValue());
        Assert.assertEquals(70, ds.getBatteryPercentage().intValue());
        //Assert.assertEquals(0.0, ds.getBarometerMeasurement().doubleValue());
        Assert.assertEquals(50, ds.getMotorTime().intValue());
        //Assert.assertEquals(0.0, ds.getAccelerationX().doubleValue());
        //Assert.assertEquals(0.0, ds.getAccelerationY().doubleValue());
        //Assert.assertEquals(0.0, ds.getAccelerationZ().doubleValue());

    }
}
