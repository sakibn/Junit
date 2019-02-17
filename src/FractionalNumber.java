/**
 * Created by debmduke on 2/7/19.
 */
public class FractionalNumber {
    private int numerator;
    private int denominator;

    /*
     *   Sets default values for numerator & denominator */
    public FractionalNumber() {
        numerator = 1;
        denominator = 1;
    }

    /*
        Precondition: denominator cannot be 0
        @param num      the numerator of the fraction
        @param denom    the denominator of the fraction, may not be 0 */
    public FractionalNumber(int num, int denom) {
        numerator = num;
        if (denom != 0)
            denominator = denom;
        else
            throw new IllegalArgumentException("Denominator cannot be 0.");
    }

    /*
     *   Adjusts the sign of the numerator and denominator so the
     *   denominator is positive, if necessary */
    private void normalize(int nume, int denom) {
        if (denom < 0) {
            denominator = Math.abs(denom);
            numerator = numerator * (-1);
        }

    }

    /*
     *   Adds the paramter to this fractional number
     *   Precondition: this and otherNum are valid FractionalNumbers
     *   Postcondition: this is the sum of the two fractions
     *   Class Invariant: otherNum is not changed
     *   @param  otherNum    a FractionalNumber*/
    public void add(final FractionalNumber otherNum) {
//        a/b + c/d = (a*d + b*c) / b*d
        int a = this.getNumerator();
        int b = this.getDenominator();
        normalize(a, b);
        int c = otherNum.getNumerator();
        int d = otherNum.getDenominator();
        normalize(c, d);
        numerator = (a * d + b * c);
        denominator = b * d;

    }

    public void subtract(final FractionalNumber otherNum) {
//        a/b – c/d = (a*d – b*c) / b*d
        int a = this.getNumerator();
        int b = this.getDenominator();
        normalize(a, b);
        int c = otherNum.getNumerator();
        int d = otherNum.getDenominator();
        normalize(c, d);
        numerator = (a * d) - (b * c);
        denominator = b * d;
    }

    public void multiply(final FractionalNumber otherNum) {
//        a/b * c/d = a*c / d*b
        int a = this.getNumerator();
        int b = this.getDenominator();
        normalize(a, b);
        int c = otherNum.getNumerator();
        int d = otherNum.getDenominator();
        normalize(c, d);
        numerator = (a * c);
        denominator = (d * b);
    }

    public void divide(final FractionalNumber otherNum) {
//        (a/b) / (c/d) = a*d / b*c
        int a = this.getNumerator();
        int b = this.getDenominator();
        normalize(a, b);
        int c = otherNum.getNumerator();
        int d = otherNum.getDenominator();
        normalize(c, d);
        numerator = (a * d);
        denominator = (b * c);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {

        return denominator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public void setDenominator(int denom) {
        if (denom == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        } else {
            denominator = denom;
        }
    }

    /*
     *   @return     true if this fraction and other would reduce to the
     *               same numerator and denominator, false otherwise
     *   @param      other       a FractionalNumber  */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof FractionalNumber)) return false;
        FractionalNumber otherNum = (FractionalNumber) other;
        return numerator * otherNum.getDenominator() == otherNum.getNumerator()
                * denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
