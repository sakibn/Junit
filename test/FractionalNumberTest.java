//////////////////////////////////////////////////////////////////
//
//	File		:FractionalNumberTest
//	Description	:This is test file for fractionalNumber.java to test addition, substraction, mutiplication,
//	             equals and toString method
//
//	Author		:Nazmus Saqib
//	Created		:2/16/2018

import org.junit.Test;

import static org.junit.Assert.*;
public class FractionalNumberTest {
    FractionalNumber num1;
    FractionalNumber num2;

    @org.junit.Before
    public void setUp() throws Exception {
        num1 = new FractionalNumber(1, 2);
        num2 = new FractionalNumber(1, 4);
    }

    @org.junit.Test
    public void add_positive() throws Exception {
        num1.add(num2);
        FractionalNumber num3 = new FractionalNumber(3, 4);
        assertEquals(num1, num3);
    }

    /**
     * Adding positive with negative fractions
     *
     * @throws Exception when denom is 0
     */
    @Test
    public void add_positive_with_negative_value() throws Exception {
        num1.setNumerator(-1);//setting -1 from the FractionalNumber.java
        num1.setDenominator(2);
        num2.setNumerator(-1);
        num2.setDenominator(4);
        num2.add(num1);
        FractionalNumber num3 = new FractionalNumber(1, -2);
        assertEquals(num1, num3);
    }

    /**
     * adding with 0 values
     *
     * @throws Exception when denom is zero
     */
    @Test
    public void add_positive_with_zero_value() throws Exception {
        num1.setNumerator(0);
        num1.setDenominator(2);
        num2.setNumerator(-1);
        num2.setDenominator(4);
        num2.add(num1);
        FractionalNumber num3 = new FractionalNumber(0, -4);
        assertEquals(num1, num3);
    }

    /**
     * adding with a negative fraction     *
     * @throws Exception when denom is zero
     */
    @Test
    public void add_negative() throws Exception {
        num1.setNumerator(-9);
        num1.add(num2);
        FractionalNumber num3 = new FractionalNumber(-17, 4);
        assertEquals(num1, num3);
    }

    /**
     * Substracting number with positive values
     * @throws Exception when denominator is zero
     */
    @org.junit.Test
    public void subtract_positive() throws Exception {
        num1.setNumerator(22);
        num1.setDenominator(4);
        num2.setNumerator(6);
        num2.setDenominator(4);
        num1.subtract(num2);
        FractionalNumber num3 = new FractionalNumber(4, 1);
        assertEquals(num1, num3);
    }

    /**
     * substract with the same fractions (num1 and num2 value are the same)
     * @throws Exception when denominator is zero
     */
    @org.junit.Test
    public void subtract_same() throws Exception {
        num2.setNumerator(1);
        num2.setDenominator(2);
        num1.subtract(num2);
        FractionalNumber num3 = new FractionalNumber(0, 1);
        assertEquals(num1, num3);
    }

    /**
     * substracting with fractions that gives negative result
     * @throws Exception when the denominator is zero
     */
    @org.junit.Test
    public void subtract_negative_result() throws Exception {
        num1.setNumerator(1);
        num1.setDenominator(8);
        num1.subtract(num2);
        FractionalNumber num3 = new FractionalNumber(-1, 8);
        assertEquals(num1, num3);
    }

    /**
     * Num2 is subtract with num1
     * @throws Exception when denom is zero
     */
    @org.junit.Test
    public void subtract_reverse() throws Exception {
        num2.setNumerator(1);
        num2.setDenominator(8);
        num2.subtract(num1);
        FractionalNumber num3 = new FractionalNumber(-3, 8);
        assertEquals(num2, num3);
    }

    /**
     * multiplying with previous setup value
     * num1 =1/2, num2 =1/4
     * @throws Exception when denom of any fractions is zero
     */
    @org.junit.Test
    public void multiply_with_eqauls() throws Exception {
        num1.multiply(num2);
        FractionalNumber num3 = new FractionalNumber(1, 8);
        assertEquals(num1, num3);
    }

    /**
     * multiply a fraction with 0
     * @throws Exception when denom is zero for any fractions
     */
    @Test
    public void multiply_with_zero() throws Exception {
        num1.setNumerator(0);
        num1.multiply(num2);
        FractionalNumber num3 = new FractionalNumber(0, 2);
        assertEquals(num1, num3);
    }

    /**
     * multiply a fractional number with a negative fractional number
     * @throws Exception when any fraction's denominator is zero
     */
    @Test
    public void multiply_with_negative() throws Exception {
        num1.setDenominator(-1);
        num2.setDenominator(4);
        num1.multiply(num2);
        FractionalNumber num3 = new FractionalNumber(-1, 4);
        assertEquals(num1, num3);
    }

    /**
     *multiply a fractional number with fractional number with 0 in denominator
     * @throws Exception divide something by zero (Junit catch it and pass the the test)
     */
    @Test(expected = IllegalArgumentException.class)
    public void multiply_with_denom_zero() throws Exception {
        num1.setDenominator(-1);
        num2.setDenominator(0);
        num1.multiply(num2);
        FractionalNumber num3 = new FractionalNumber(-1, 0);
        assertEquals(num1, num3);
    }

    /** divide a number with zero
     * @throws Exception when zero appear in any denominator but it will pass the test
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void divide_with_zero() throws Exception {
        num2.setDenominator(0);
    }

    /**
     * divided a positive fractions with a negative fraction
     * @throws Exception when the denom of any fractions is negative
     */
    @Test
    public void divide_with_neg() throws Exception {
        num2.setDenominator(-9);
        num1.setDenominator(1);
        num1.divide(num2);
        FractionalNumber num3 = new FractionalNumber(-9, 1);
        assertEquals(num1, num3);
    }

    /**
     * divide two postive fractions
     * @throws Exception when any of the denominator is negative
     */
    @Test
    public void divide_with_positive() throws Exception {
        num2.setDenominator(9);
        num1.setDenominator(1);
        num1.divide(num2);
        FractionalNumber num3 = new FractionalNumber(9, 1);
        assertEquals(num1, num3);
    }

    /**
     * set num1 denominator == 0
     * @throws Exception when the denom is zero. (the test pass because Junit catch the Illegal Argument)
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void setDenominator_with_zero() throws Exception {
        num1.setDenominator(0);
    }

    /**
     * set num1 denominator to a negative value
     * @throws Exception when denominator of any rational number is negative
     */
    @org.junit.Test
    public void setDenominator_with_negative() throws Exception {
        num1.setDenominator(-1);
        FractionalNumber num3 = new FractionalNumber(1, -1);
        assertEquals(num1, num3);
    }

    /**
     *Put two positive fractional number to equals method
     * @throws Exception when denom is 0
     */
    @org.junit.Test
    public void equals_positive() throws Exception {
        num1.setDenominator(2);
        num2.setDenominator(2);
        assertEquals(num1, num2);
    }

    /**
     * put two negtaive fraction to equals method
     * @throws Exception when something divide by 0
     */
    @org.junit.Test
    public void equals_negative() throws Exception {
        num1.setDenominator(-2);
        num2.setDenominator(2);
        num2.setNumerator(-1);
        assertEquals(num1, num2);
    }

    /**
     * make num1 to divide with zero itself
     *@throw exception when num1 is causing math error
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void equals_zero() {
        num1.setDenominator(0);
    }

    /**
     * This is looking for toString to share same result
     */
    @org.junit.Test
    public void toStringtest() throws Exception {
        String stringstest = num1.getNumerator() + "/" + num1.getDenominator();
        assertEquals(stringstest, num1.toString());
    }
}
