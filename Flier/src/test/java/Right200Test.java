import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class Right200Test {
    @Test
    public void testDoAction(){
        byte[] expect = new byte[]{114, 105, 103, 104, 116, 32, 50, 48, 48};
        byte[] result;
        Action act=new Right200();
        result = act.doAction();
        assertArrayEquals(expect, result);
    }

}