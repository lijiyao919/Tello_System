import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class Rotate360Test {
    @Test
    public void testDoAction(){
        byte[] expect = new byte[]{99, 119, 32, 51, 54, 48};
        byte[] result;
        Action act=new Rotate360();
        result = act.doAction();
        assertArrayEquals(expect, result);
    }

}