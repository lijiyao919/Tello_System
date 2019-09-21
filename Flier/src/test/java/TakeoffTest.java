import org.junit.Test;
import static org.junit.Assert.*;

public class TakeoffTest {
    @Test
    public void testDoAction(){
        byte[] expect = new byte[]{116, 97, 107, 101, 111, 102, 102};
        byte[] result;
        Action act = new Takeoff();
        result = act.doAction();
        assertArrayEquals(expect, result);
    }

}