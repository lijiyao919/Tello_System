import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
    @Test
    public void testFormatIntegerWithNull(){
        Assert.assertEquals("0", StringUtils.formatInteger(null));
    }

    @Test
    public void testFormatIntegerWithoutNull(){
        Assert.assertEquals("3", StringUtils.formatInteger(3));
    }

    @Test
    public void testFormatDoubleWithNull(){
        Assert.assertEquals("0.00", StringUtils.formatDouble(null));
    }

    @Test
    public void testFormatDoubleWithoutNull(){
        Assert.assertEquals("3.12", StringUtils.formatDouble(3.123));
    }
}
