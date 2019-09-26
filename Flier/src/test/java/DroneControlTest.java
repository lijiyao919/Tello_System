import org.junit.Assert;
import org.junit.Test;


public class DroneControlTest {
    @Test
    public void testDoMissions() throws Exception{
        DroneControl dc = new DroneControl();
        int[] MissionChoice = {1,2,3};
        Boolean result = dc.doMissions(3,MissionChoice);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
