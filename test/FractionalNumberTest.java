import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by debmduke on 2/7/19.
 */
public class FractionalNumberTest {
    FractionalNumber num1;
    FractionalNumber num2;

    @org.junit.Before
    public void setUp() throws Exception {
        num1 = new FractionalNumber(1, 2);
        num2 = new FractionalNumber(1, 4);
    }

    @org.junit.Test
    public void add() throws Exception {
        num1.add(num2);
        FractionalNumber num3 = new FractionalNumber(3, -4);
        assertEquals(num1, num3); //worked

    }

    @org.junit.Test
    public void subtract() throws Exception {
    }

    @org.junit.Test
    public void multiply_with_eqauls() throws Exception {
        num1.multiply(num2);
        FractionalNumber num3 = new FractionalNumber(1, 8);
        assertEquals(num1, num3);
    }

    /**
     * @throws Exception
     */
    @Test
    public void multiply_with_zero() throws Exception {
        num1.setNumerator(0);
        num1.multiply(num2);
        FractionalNumber num3 = new FractionalNumber(0, 2);
        assertEquals(num1, num3);
    }

    @Test
    public void multiply_with_negative() throws Exception {
        num1.setDenominator(-1);
        num2.setDenominator(4);
        num1.multiply(num2);
        FractionalNumber num3 = new FractionalNumber(-1, 4);
        assertEquals(num1, num3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiply_with_denom_zero() throws Exception {
        num1.setDenominator(-1);
        num2.setDenominator(0);
        num1.multiply(num2);
        FractionalNumber num3 = new FractionalNumber(-1, 0);
        assertEquals(num1, num3);
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void divide_with_zero() throws Exception {
        num2.setDenominator(0);
    }

    @Test
    public void divide_with_neg() throws Exception {
        num2.setDenominator(-9);
        num1.setDenominator(1);
        num1.divide(num2);
        FractionalNumber num3 = new FractionalNumber(-9, 1);
        assertEquals(num1, num3);
    }

    @Test
    public void divide_with_positive() throws Exception {
        num2.setDenominator(9);
        num1.setDenominator(1);
        num1.divide(num2);
        FractionalNumber num3 = new FractionalNumber(9, 1);
        assertEquals(num1, num3);
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setDenominator_with_zero() throws Exception {
        num1.setDenominator(0);
    }
    @org.junit.Test
    public void setDenominator_with_positive() throws Exception {
        num1.setDenominator(-1);
        FractionalNumber num3 =new FractionalNumber(1,-1);
        assertEquals(num1,num3);
    }

    @org.junit.Test
    public void equals_positive() throws Exception {
        num1.setDenominator(2);
        num2.setDenominator(2);
        assertEquals(num1, num2);
    }
    @org.junit.Test
    public void equals_negative() throws Exception {
        num1.setDenominator(-2);
        num2.setDenominator(2);
        num2.setNumerator(-1);
        assertEquals(num1, num2);
    }
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void equals_zero() {
        num1.setDenominator(0);
    }

    @org.junit.Test
    public void toStringtest() throws Exception {
        String stringstest = num1.getNumerator() + "/" + num1.getDenominator();
        assertEquals(stringstest, num1.toString());
    }


}
