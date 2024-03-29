import Message.Message;
import Message.Status;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class StatusTest {
    @Test
    public void testConstructorStatusMsg(){
        String msg = "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:10;roll:60;yaw:30;"+
                     "vgx:20;vgy:20;vgz:20;"+
                     "templ:70;temph:100;"+
                     "tof:100;h:50;"+
                     "bat:70;baro:30;"+
                     "time:50;"+
                     "agx:10;agy:10;agz:10";

        Status sta = (Status) Message.decode(msg.getBytes(), 0, 1000);

        Assert.assertEquals(10, sta.getPitch().intValue());
        Assert.assertEquals(60, sta.getRoll().intValue());
        Assert.assertEquals(30, sta.getYaw().intValue());
        Assert.assertEquals(20, sta.getSpeedX().intValue());
        Assert.assertEquals(20, sta.getSpeedY().intValue());
        Assert.assertEquals(20, sta.getSpeedZ().intValue());
        Assert.assertEquals(70, sta.getLowTemperature().intValue());
        Assert.assertEquals(100, sta.getHighTemperature().intValue());
        Assert.assertEquals(100, sta.getFlightDistance().intValue());
        Assert.assertEquals(50, sta.getHeight().intValue());
        Assert.assertEquals(70, sta.getBatteryPercentage().intValue());
        Assert.assertEquals(30.0, sta.getBarometerMeasurement(), 0);
        Assert.assertEquals(50, sta.getMotorTime().intValue());
        Assert.assertEquals(10.0, sta.getAccelerationX(), 0);
        Assert.assertEquals(10.0, sta.getAccelerationY(),0);
        Assert.assertEquals(10.0, sta.getAccelerationZ(),0);
        Assert.assertEquals("mid", Status.getKeyWord());
        Assert.assertEquals("status", sta.getMessageType());
        Assert.assertEquals("Status mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:10;roll:60;yaw:30;vgx:20;vgy:20;vgz:20;templ:70;temph:100;tof:100;h:50;bat:70;baro:30.00;time:50;agx:10.00;agy:10.00;agz:10.00", sta.toString());
    }


    @Test
    public void testConstructorWithFieldValueNull(){
        String msg = "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:;;ya:30;"+
                "vgx:20;vgy:20;vgz:20;"+
                "templ:70;temph:100;"+
                "tof:100;h:50;"+
                "bat:70;baro:;"+
                "time:50;"+
                "agx:10;agy:10;agz:null";
        Status sta = (Status) Message.decode(msg.getBytes(), 0, 1000);
        Assert.assertEquals(null, sta.getPitch());
        Assert.assertEquals(null, sta.getBarometerMeasurement());
        Assert.assertEquals(null, sta.getRoll());
        Assert.assertEquals(null, sta.getYaw());
    }

    @Test
    public void testGetMessageTextByConstructorWithMultipleParameters(){
        Status sta = new Status(10,60,30,20,20,20,70,
                100,100,50,70,30.0,
                50,10.0,10.0,10.0);
        String expectedResult = "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:10;roll:60;yaw:30;"+
                "vgx:20;vgy:20;vgz:20;"+
                "templ:70;temph:100;"+
                "tof:100;h:50;"+
                "bat:70;baro:30.00;"+
                "time:50;"+
                "agx:10.00;agy:10.00;agz:10.00";
        Assert.assertEquals(expectedResult, sta.getMessageText());
    }

    @Test
    public void testEncodeStatusMsg(){
        String msg = "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:10;roll:60;yaw:30;"+
                "vgx:20;vgy:20;vgz:20;"+
                "templ:70;temph:100;"+
                "tof:100;h:50;"+
                "bat:70;baro:30.00;"+
                "time:50;"+
                "agx:10.00;agy:10.00;agz:10.00";

        Status status1 = (Status) Message.decode(msg.getBytes(), 0, 1000);

        Status status2 = new Status(10,60,30,20,20,20,70,
                100,100,50,70,30.0,
                50,10.0,10.0,10.0);

        Assert.assertEquals(Arrays.toString(status1.encode()), Arrays.toString(status2.encode()));
    }
}
