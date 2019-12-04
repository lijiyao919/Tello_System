import Import.ImportFromJSON;
import Import.ImportStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ImportFromJSONTest {
    @Test
    public void testLoad() throws Exception {
        ArrayList<Long> missions = new ArrayList<Long>();

        ImportStrategy ip = new ImportFromJSON();
        ip.load(missions);

        Assert.assertEquals(1, (long) missions.get(0));
        Assert.assertEquals(2, (long) missions.get(1));
        Assert.assertEquals(3, (long) missions.get(2));
    }
}
