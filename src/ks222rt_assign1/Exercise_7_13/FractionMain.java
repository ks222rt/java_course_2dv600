package ks222rt_assign1.Exercise_7_13;

/**
 * Created by Kristoffer on 2016-09-01.
 */
public class FractionMain {
    public static void main(String[] args){
        Fraction frac1 = new Fraction(1, 4);
        Fraction frac2 = new Fraction(1, 3);

        System.out.println("1/4 + 1/3 should be 7/12");
        Fraction frac3 = frac1.add(frac2);
        System.out.println(frac3.toString());

        frac1 = new Fraction(1, 5);
        frac2 = new Fraction(1, 7);

        System.out.println("1/5 - 1/7 should be 2/35");
        frac3 = frac1.subtract(frac2);
        System.out.println(frac3);

        frac1 = new Fraction(3, 7);
        frac2 = new Fraction(4, 5);

        System.out.println("3/7 * 4/5 should be 12/35");
        frac3 = frac1.multiply(frac2);
        System.out.println(frac3);

        frac1 = new Fraction(2, 5);
        frac2 = new Fraction(2, 3);

        System.out.println("2/5 / 2/3 should be 6/10");
        frac3 = frac1.divide(frac2);
        System.out.println(frac3);

        frac1 = new Fraction(2, 4);
        frac2 = new Fraction(4, 8);

        System.out.println("2/4 and 4/8 should have the same result");
        System.out.println(frac1.isEqualTo(frac2));

        frac1 = new Fraction(2, 4);
        frac2 = new Fraction(4, 5);

        System.out.println("2/4 and 4/5 should not have the same result");
        System.out.println(frac1.isEqualTo(frac2));

        frac1 = new Fraction(-1, 3);
        System.out.println("isNegative() should say that -1/3 is negative");
        System.out.println(frac1.isNegative());

        frac1 = new Fraction(3, 12);
        frac1.simplifyFraction();
        System.out.println("3/12 simplified should be 1/4");
        System.out.println(frac1);

        try{
            System.out.println("An error should be thrown when the denominator is zero!");
            frac1 = new Fraction(4, 0);
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}
