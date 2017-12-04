import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class CalculatorTest {
    @Test
    public void canAddPositiveIntegers() {
        Assert.assertEquals(Calculator.add(1, 2), 3, 0);
    }

    @Test
    public void canSubtractPositiveIntegers() {
        Assert.assertEquals(Calculator.subtract(3, 2), 1, 0);
    }

    @Test
    public void canDividePositiveIntegers() {
        Assert.assertEquals(Calculator.divide(6, 2), 3, 0);
    }

    @Test
    public void canDivideByZero() {
        Assert.assertTrue( Double.isInfinite(Calculator.divide(6, 0)));
    }

    @Test
    public void canMultiplyPositiveIntegers() {
        Assert.assertEquals(Calculator.multiply(3, 4), 12, 0);
    }

}