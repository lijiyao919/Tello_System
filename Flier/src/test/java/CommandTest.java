import org.junit.Test;
import static org.junit.Assert.*;

public class CommandTest {
    @Test
    public void testDoAction(){
        byte[] expect = new byte[]{99, 111, 109, 109, 97, 110, 100};
        byte[] result;
        Action act = new Command();
        result = act.doAction();
        assertArrayEquals(expect, result);
    }

}
