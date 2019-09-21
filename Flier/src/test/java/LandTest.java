import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class LandTest {
    @Test
    public void testDoAction(){
        byte[] expect = new byte[]{108, 97, 110, 100};
        byte[] result;
        Action act=new Land();
        result = act.doAction();
        assertArrayEquals(expect, result);
    }

}