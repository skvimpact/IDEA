import sun.misc.DoubleConsts;
import java.lang.Double;
/**
 * Created by KSafonov on 08/09/2017.
 */
import java.lang.Double;
public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof ComplexNumber)) return false;
        return (this.im == ((ComplexNumber)other).im) && (this.re == ((ComplexNumber)other).re);
    }

    @Override
    public int hashCode() {
        return new Long(((long)Double.hashCode(this.re))<< 32 + Double.hashCode(this.im)).hashCode();
    }

    public int hashCode2() {
        return Double.hashCode(this.re);
    }

    /**
     * Returns a hash code for a {@code double} value; compatible with
     * {@code Double.hashCode()}.
     *
     * @param value the value to hash
     * @return a hash code value for a {@code double} value.
     * @since 1.8
     */
/*
    public static int hashCode2(double value) {
        long bits = doubleToLongBits(value);
        return (int)(bits ^ (bits >>> 32));
    }

    public static long doubleToLongBits(double value) {
        long result = value.
        // Check for NaN based on values of bit fields, maximum
        // exponent and nonzero significand.
        if ( ((result & DoubleConsts.EXP_BIT_MASK) ==
                DoubleConsts.EXP_BIT_MASK) &&
                (result & DoubleConsts.SIGNIF_BIT_MASK) != 0L)
            result = 0x7ff8000000000000L;
        return result;
    }
    */
}