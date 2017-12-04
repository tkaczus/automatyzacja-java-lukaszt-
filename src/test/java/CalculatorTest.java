import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class CalculatorTest {
    private double a;
    private double b;

    @Test
    public void canAddPositiveIntegers() {
        a = 1.0;
        b = 2.0;
        Assert.assertEquals("Adding 1+2", 3, Calculator.add(a, b), 0);
    }

    @Test
    public void canAddNegativeIntegers() {
        a = -11.0;
        b = -2.0;
        Assert.assertEquals("Adding -11+-2", -13, Calculator.add(a, b), 0);
    }

    @Test
    public void canSubtractPositiveIntegers() {
        a = 3.0;
        b = 2.0;
        Assert.assertEquals("Substract 3-2", 1, Calculator.subtract(a, b), 0);
    }

    @Test
    public void canSubtractNegativeIntegers() {
        a = -3.0;
        b = -2.0;
        Assert.assertEquals("Substract -3--2", -1, Calculator.subtract(a, b), 0);
    }

    @Test
    public void canDividePositiveIntegers() {
        a = 6.0;
        b = 4.0;
        Assert.assertEquals("Divide 6/2", 1.5, Calculator.divide(a, b), 0);
    }

    @Test
    public void canDivideByZero() {
        a = 6.0;
        b = 0.0;
        Assert.assertTrue("Divide 6 by 0", Double.isInfinite(Calculator.divide(a, b)));
        Assert.assertTrue("Divide 6 by 0", Calculator.divide(a, b)==Double.POSITIVE_INFINITY);
    }

    @Test
    public void canMultiplyPositiveIntegers() {
        a = 3.0;
        b = 4.0;
        Assert.assertEquals("Multiply 3*4", 12, Calculator.multiply(a, b), 0);
    }

    @Test
    public void canMultiplyNegativeIntegers() {
        a = -3.0;
        b = 4.0;
        Assert.assertEquals("Multiply -3*4", -12, Calculator.multiply(a, b), 0);
    }

}