import org.junit.Assert;
import org.junit.Test;


public class DroneControlTest {
    @Test
    public void testDoMissions() throws Exception{
        DroneState ds = new DroneState();
        DroneControl dc = new DroneControl(ds);
        int[] MissionChoice = {1,2,3};
        Boolean result = dc.doMissions(3,MissionChoice);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
