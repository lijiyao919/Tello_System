import Mock.MockObserver;
import State.DroneState;
import State.StateObserver;
import Message.Status;
import org.junit.Assert;
import org.junit.Test;
import java.util.Date;

public class DroneStateTest {
    @Test
    public void testNonParametricConstructor(){
    //public static void main(String args[]){
        DroneState ds = new DroneState();
        Date dt = new Date();
        //System.out.println(ds.getCurrentFlightTime().doubleValue());

        Assert.assertEquals(Boolean.FALSE, ds.isVideoStreamOn());
        Assert.assertEquals(Boolean.FALSE, ds.hasTakenOff());
        Assert.assertEquals(dt, ds.getStateTimestamp());
        Assert.assertEquals(0.0, ds.getCurrentFlightTime().doubleValue(), 0.01);
        Assert.assertEquals(100.0, ds.getPositionX().doubleValue(), 0.01);
        Assert.assertEquals(150.0, ds.getPositionY().doubleValue(), 0.01);
        Assert.assertEquals(100.0, ds.getPositionZ().doubleValue(),0.01);
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
        Assert.assertEquals(0.0, ds.getBarometerMeasurement().doubleValue(), 0.01);
        Assert.assertEquals(0, ds.getMotorTime().intValue());
        Assert.assertEquals(0.0, ds.getAccelerationX().doubleValue(), 0.01);
        Assert.assertEquals(0.0, ds.getAccelerationY().doubleValue(),0.01);
        Assert.assertEquals(0.0, ds.getAccelerationZ().doubleValue(),0.01);
        Assert.assertEquals(0, ds.getOrientation());
    }

    @Test
    public void testSetCommandModeTrue(){
        DroneState ds = new DroneState();
        ds.setInCommandMode(Boolean.TRUE);
        Assert.assertEquals(Boolean.TRUE, ds.isInCommandMode());
    }

    @Test
    public void testSetCommandModeFalse(){
        DroneState ds = new DroneState();
        ds.setInCommandMode(Boolean.FALSE);
        Assert.assertEquals(Boolean.FALSE, ds.isInCommandMode());

        ds.setInCommandMode(Boolean.TRUE);
        ds.setInCommandMode(Boolean.FALSE);
        Assert.assertEquals(Boolean.FALSE, ds.isInCommandMode());
    }

    @Test
    public void testSetHasTakenOffSuccess(){
        DroneState ds = new DroneState();
        ds.setInCommandMode(Boolean.TRUE);
        ds.setHasTakenOff(Boolean.TRUE);
        Assert.assertEquals(Boolean.TRUE, ds.hasTakenOff());
    }

    @Test
    public void testSetHasTakenOffNotInCmdMode(){
        DroneState ds = new DroneState();
        ds.setInCommandMode(Boolean.FALSE);
        ds.setHasTakenOff(Boolean.TRUE);
        Assert.assertEquals(Boolean.FALSE, ds.hasTakenOff());
    }

    @Test
    public void testSetHasTakenOffDefault(){
        DroneState ds = new DroneState();
        ds.setHasTakenOff(Boolean.FALSE);
        Assert.assertEquals(Boolean.FALSE, ds.hasTakenOff());
    }


    @Test
    public void testConsumeBatteryNormal(){
        DroneState ds = new DroneState();
        ds.consumeBattery(5);
        Assert.assertEquals(95, ds.getBatteryPercentage().intValue());
    }

    @Test
    public void testConsumeBatteryAbnormal(){
        DroneState ds = new DroneState();
        ds.consumeBattery(150);
        Assert.assertEquals(0, ds.getBatteryPercentage().intValue());
    }

    @Test
    public void testUpdateFlyingInfoSuccess(){
        DroneState ds = new DroneState();
        ds.setInCommandMode(true);
        String stat = "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:10;roll:60;yaw:30;"+
                "vgx:20;vgy:20;vgz:20;"+
                "templ:70;temph:100;"+
                "tof:100;h:50;"+
                "bat:70;baro:30.00;"+
                "time:50;"+
                "agx:10.00;agy:10.00;agz:10.10";
        Status status= new Status(stat);
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
        //Assert.assertEquals(0.0, ds.getBarometerMeasurement().doubleValue());
        Assert.assertEquals(50, ds.getMotorTime().intValue());
        //Assert.assertEquals(0.0, ds.getAccelerationX().doubleValue());
        //Assert.assertEquals(0.0, ds.getAccelerationY().doubleValue());
        //Assert.assertEquals(0.0, ds.getAccelerationZ().doubleValue());
    }

    @Test
    public void testUpdateFlyingInfoFailure() {
        DroneState ds = new DroneState();
        Status status = null;
        ds.updateFlyingInfo(status);
    }

    @Test
    public void testSetVideoStreamOn(){
        DroneState ds = new DroneState();
        ds.setInCommandMode(Boolean.TRUE);
        ds.setVideoStreamOn(Boolean.TRUE);
        Assert.assertEquals(Boolean.TRUE, ds.isVideoStreamOn());
    }

    @Test
    public void testSetCurrentFlightTime(){
        DroneState ds = new DroneState();
        ds.setInCommandMode(Boolean.TRUE);
        ds.setCurrentFlightTime(1.0);
        //Assert.assertEquals(1.0, ds.getCurrentFlightTime().doubleValue());
    }

    @Test
    public void testMove(){
        DroneState ds = new DroneState();
        ds.setInCommandMode(Boolean.TRUE);
        ds.setHasTakenOff(Boolean.TRUE);
        ds.move(1.0,1.0,1.0);
        //Assert.assertEquals(1.0, ds.getPositionX().doubleValue());
        //Assert.assertEquals(1.0, ds.getPositionY().doubleValue());
        //Assert.assertEquals(1.0, ds.getPositionZ().doubleValue());
    }

    @Test
    public void testRotate(){
        DroneState ds = new DroneState();
        ds.setInCommandMode(Boolean.TRUE);
        ds.setHasTakenOff(Boolean.TRUE);
        ds.rotate(1);
        Assert.assertEquals(1, ds.getOrientation());
    }

    @Test
    public void testRegisterAndRemoveObserver(){
        DroneState ds = new DroneState();
        StateObserver obs = new MockObserver();

        ds.registerObserver(obs);
        ds.removeObserver(obs);
    }

    @Test
    public void testNotifyObserver(){
        DroneState ds = new DroneState();
        StateObserver obs = new MockObserver();
        Status status=null;
        ds.registerObserver(obs);
        ds.notifyObserver(status);
    }



}
