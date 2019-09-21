import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class Left200Test {
    @Test
    public void testDoAction(){
        byte[] expect = new byte[]{108, 101, 102, 116, 32, 50, 48, 48};
        byte[] result;
        Action act=new Left200();
        result = act.doAction();
        assertArrayEquals(expect, result);
    }

}