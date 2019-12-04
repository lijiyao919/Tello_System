import Message.Message;
import Mock.MockObserver;
import State.DroneState;
import State.StateObserver;
import Message.Status;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DroneStateTest {
    @Test
    public void testA_NonParametricConstructor(){
        DroneState ds = DroneState.getInstance();
        Date dt = new Date();
        Assert.assertEquals(dt, ds.getStateTimestamp());

        DroneState ds1 = DroneState.getInstance();
        Assert.assertEquals(ds, ds1);
        Assert.assertEquals(Boolean.FALSE, ds.isVideoStreamOn());
        Assert.assertEquals(Boolean.FALSE, ds.hasTakenOff());
        Assert.assertEquals(0, ds.getCurrentFlightTime(), 0);
        Assert.assertEquals(100, ds.getPositionX(), 0);
        Assert.assertEquals(150, ds.getPositionY(), 0);
        Assert.assertEquals(100, ds.getPositionZ(),0);
        Assert.assertEquals(0, ds.getPitch().intValue());
        Assert.assertEquals(0, ds.getRoll().intValue());
        Assert.assertEquals(0, ds.getYaw().intValue());
        Assert.assertEquals(0, ds.getSpeedX().intValue());
        Assert.assertEquals(0, ds.getSpeedY().intValue());
        Assert.assertEquals(0, ds.getSpeedZ().intValue());
        Assert.assertEquals(0, ds.getLowTemperature().intValue());
        Assert.assertEquals(0, ds.getHighTemperature().intValue());
        Assert.assertEquals(0, ds.getFlightDistance().intValue());
        Assert.assertEquals(0, ds.getHeight().intValue());
        Assert.assertEquals(100, ds.getBatteryPercentage().intValue());
        Assert.assertEquals(0, ds.getBarometerMeasurement(), 0);
        Assert.assertEquals(0, ds.getMotorTime().intValue());
        Assert.assertEquals(0, ds.getAccelerationX(), 0);
        Assert.assertEquals(0, ds.getAccelerationY(),0);
        Assert.assertEquals(0, ds.getAccelerationZ(),0);
        Assert.assertEquals(0, ds.getOrientation());
    }

    @Test
    public void testB_SetCommandModeTrue(){
        DroneState ds = DroneState.getInstance();
        ds.setInCommandMode(Boolean.TRUE);
        Assert.assertEquals(Boolean.TRUE, ds.isInCommandMode());
    }

    @Test
    public void testC_SetCommandModeFalse(){
        DroneState ds = DroneState.getInstance();
        ds.setInCommandMode(Boolean.FALSE);
        Assert.assertEquals(Boolean.FALSE, ds.isInCommandMode());

        ds.setInCommandMode(Boolean.TRUE);
        ds.setInCommandMode(Boolean.FALSE);
        Assert.assertEquals(Boolean.FALSE, ds.isInCommandMode());
    }

    @Test
    public void testD_SetHasTakenOffSuccess(){
        DroneState ds = DroneState.getInstance();
        ds.setInCommandMode(Boolean.TRUE);
        ds.setHasTakenOff(Boolean.TRUE);
        Assert.assertEquals(Boolean.TRUE, ds.hasTakenOff());
    }

    @Test
    public void testE_SetHasTakenOffNotInCmdMode(){
        DroneState ds = DroneState.getInstance();
        ds.setInCommandMode(Boolean.FALSE);
        ds.setHasTakenOff(Boolean.TRUE);
        Assert.assertEquals(Boolean.FALSE, ds.hasTakenOff());
    }

    @Test
    public void testF_SetHasTakenOffDefault(){
        DroneState ds = DroneState.getInstance();
        ds.setHasTakenOff(Boolean.FALSE);
        Assert.assertEquals(Boolean.FALSE, ds.hasTakenOff());
    }


    @Test
    public void testG_ConsumeBatteryNormal(){
        DroneState ds = DroneState.getInstance();
        ds.consumeBattery(5);
        Assert.assertEquals(95, ds.getBatteryPercentage().intValue());
    }

    @Test
    public void testH_ConsumeBatteryAbnormal(){
        DroneState ds = DroneState.getInstance();
        ds.consumeBattery(150);
        Assert.assertEquals(0, ds.getBatteryPercentage().intValue());
    }

    @Test
    public void testI_UpdateFlyingInfoSuccess(){
        DroneState ds = DroneState.getInstance();
        ds.setInCommandMode(true);
        String stat = "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:10;roll:60;yaw:30;"+
                "vgx:20;vgy:20;vgz:20;"+
                "templ:70;temph:100;"+
                "tof:100;h:50;"+
                "bat:70;baro:30.00;"+
                "time:50;"+
                "agx:10.00;agy:10.00;agz:10.10";
        Status status = (Status) Message.decode(stat.getBytes(), 0, 1000);
        ds.updateFlyingInfo(status);

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
        Assert.assertEquals(30, ds.getBarometerMeasurement(), 0);
        Assert.assertEquals(50, ds.getMotorTime().intValue());
        Assert.assertEquals(10, ds.getAccelerationX(),0);
        Assert.assertEquals(10, ds.getAccelerationY(), 0);
        Assert.assertEquals(10.1, ds.getAccelerationZ(), 0);
    }

    @Test
    public void testJ_UpdateFlyingInfoFailure() {
        DroneState ds = DroneState.getInstance();
        Status status = null;
        ds.updateFlyingInfo(status);
    }

    @Test
    public void testK_SetVideoStreamOn(){
        DroneState ds = DroneState.getInstance();
        ds.setInCommandMode(Boolean.TRUE);
        ds.setVideoStreamOn(Boolean.TRUE);
        Assert.assertEquals(Boolean.TRUE, ds.isVideoStreamOn());
    }

    @Test
    public void testL_SetCurrentFlightTime(){
        DroneState ds = DroneState.getInstance();
        ds.setInCommandMode(Boolean.TRUE);
        ds.setCurrentFlightTime(1.0);
        Assert.assertEquals(1.0, ds.getCurrentFlightTime(), 0);
    }

    @Test
    public void testM_Move(){
        DroneState ds = DroneState.getInstance();
        ds.setInCommandMode(Boolean.TRUE);
        ds.setHasTakenOff(Boolean.TRUE);
        ds.move(1.0,1.0,1.0);
        Assert.assertEquals(101, ds.getPositionX(),0);
        Assert.assertEquals(151, ds.getPositionY(),0);
        Assert.assertEquals(101, ds.getPositionZ(),0);
    }

    @Test
    public void testN_Rotate(){
        DroneState ds = DroneState.getInstance();
        ds.setInCommandMode(Boolean.TRUE);
        ds.setHasTakenOff(Boolean.TRUE);
        ds.rotate(1);
        Assert.assertEquals(1, ds.getOrientation());
    }

    @Test
    public void testO_RegisterAndRemoveObserver(){
        DroneState ds = DroneState.getInstance();
        StateObserver obs = new MockObserver();

        ds.registerObserver(obs);
        ds.removeObserver(obs);
    }

    @Test
    public void testP_NotifyObserver(){
        DroneState ds = DroneState.getInstance();
        StateObserver obs = new MockObserver();
        Status status=null;
        ds.registerObserver(obs);
        ds.notifyObserver(status);
    }



}
