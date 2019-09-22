import org.junit.Assert;
import org.junit.Test;
import java.util.Date;

public class DroneStateTest {
    @Test
    public void testNonParametricConstructor(){
        DroneState ds = new DroneState();
        Date dt = new Date();

        Assert.assertEquals(Boolean.FALSE, ds.isVideoStreamOn());
        Assert.assertEquals(Boolean.FALSE, ds.hasTakenOff());
        Assert.assertEquals(dt, ds.getStateTimestamp());
        //Assert.assertEquals(0.0, ds.getCurrentFlightTime().doubleValue());
        //Assert.assertEquals(0.0, ds.getPositionX().doubleValue());
        //Assert.assertEquals(0.0, ds.getPositionY().doubleValue());
        //Assert.assertEquals(0.0, ds.getPositionZ().doubleValue());
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
        Assert.assertEquals(0, ds.getBatteryPercentage().intValue());
        //Assert.assertEquals(0.0, ds.getBarometerMeasurement().doubleValue());
        Assert.assertEquals(0, ds.getMotorTime().intValue());
        //Assert.assertEquals(0.0, ds.getAccelerationX().doubleValue());
        //Assert.assertEquals(0.0, ds.getAccelerationY().doubleValue());
        //Assert.assertEquals(0.0, ds.getAccelerationZ().doubleValue());
        Assert.assertEquals(0, ds.getOrientation());
    }

    @Test
    public void testSetCommandModeTrue(){
        DroneState ds = new DroneState();
        ds.setInCommandMode(Boolean.TRUE);
        Assert.assertEquals(Boolean.TRUE, ds.isInCommandMode());
    }

    @Test
    public void testSetHasTakenOffTrue(){
        DroneState ds = new DroneState();
        ds.setInCommandMode(Boolean.TRUE);
        ds.setHasTakenOff(Boolean.TRUE);
        Assert.assertEquals(Boolean.TRUE, ds.hasTakenOff());
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
        Assert.assertEquals(1.0, ds.getCurrentFlightTime().doubleValue());
    }

    @Test
    public void testMove(){
        DroneState ds = new DroneState();
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


}
