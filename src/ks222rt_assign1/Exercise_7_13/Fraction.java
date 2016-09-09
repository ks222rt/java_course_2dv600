package ks222rt_assign1.Exercise_7_13;

/**
 * Created by Kristoffer on 2016-09-01.
 */
public class Fraction {
    private int n;
    private int d;

    public Fraction(int n, int d){
        if (d == 0){
            throw new IllegalArgumentException("Denominator cannot be equal to zero!");
        }
        this.n = n;
        this.d = d;
    }

    public int getNumerator(){
        return this.n;
    }

    public int getDenominator(){
        return this.d;
    }

    public boolean isNegative(){
        return (double)this.n/this.d < 0;
    }

    public Fraction add(Fraction fraction){
        return new Fraction((getNumerator()*fraction.getDenominator()) + (fraction.getNumerator() * getDenominator()), (getDenominator() * fraction.getDenominator()));
    }

    public Fraction subtract(Fraction fraction){
        return new Fraction((getNumerator()*fraction.getDenominator()) - (fraction.getNumerator() * getDenominator()), (getDenominator() * fraction.getDenominator()));
    }

    public Fraction multiply(Fraction fraction){
        return new Fraction((getNumerator() * fraction.getNumerator()), (getDenominator() * fraction.getDenominator()));
    }

    public Fraction divide(Fraction fraction){
        return new Fraction((getNumerator() * fraction.getDenominator()), (getDenominator() * fraction.getNumerator()));
    }

    public boolean isEqualTo(Fraction fraction){
        return (double)this.n/this.d == (double) fraction.n/fraction.d;
    }

    public String toString(){
        return this.n + "/" + this.d;
    }

    public void simplifyFraction(){
        int num = this.n;
        int dem = this.d;

        while (dem != 0) {
            int t = dem;
            dem = num % dem;
            num = t;
        }
        int gcd = num;
        this.n /= gcd;
        this.d /= gcd;
    }



}
