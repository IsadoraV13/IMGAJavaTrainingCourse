package Fraction;

import java.util.stream.Stream;

public class FractionImplement implements Fraction{

    public static void main(String[] args) {
//        new FractionImplement(1, 2);
//        new FractionImplement(2, 4); // normalise
//        new FractionImplement(2, 3); // no change
//        new FractionImplement(3, 2); // no change, num > denom
//        new FractionImplement(-2, 4);
//        new FractionImplement(2, -4);
//        new FractionImplement(-2, -4);
        new FractionImplement("2/4");
        new FractionImplement("-2/4");
        new FractionImplement("2/-4");
        new FractionImplement("-2/-4");
//        gcd(-2, 4);
    }

//    Parameters can be:
//    1- the numerator and the denominator (ints)
//    2- whole number (a int representing the numerator and the denominator is implicit 1)
//    3 - a string containing the numerator and the denominator OR a whole number

    private final int numerator;
    private final int denominator;


    //    The constructor should throw an ArithmeticException if the denominator is zero.
    //    Normalize the fraction as you create it.
    public FractionImplement(int numerator, int denominator) throws IllegalArgumentException {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator cannot be zero");
        }
        int [] fractionArray = normalise(numerator, denominator);
        this.numerator = fractionArray[0];
        this.denominator = fractionArray[1];
    }

    // overloaded constructor to take a single int as numerator
    public FractionImplement(int numerator)  {
        this.numerator = numerator;
        this.denominator = 1;
    }

    // overloaded constructor to take strings
    public FractionImplement(String fractionNumsAsStrings) throws IllegalArgumentException {
        int [] intArray = Stream.of(fractionNumsAsStrings.split("/", 0))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();
        if (intArray.length > 2)  {
            throw new IllegalArgumentException("please only specify two numbers separated by '/' ");
        }
        int num = intArray[0];
        int denom = intArray[1];
        int [] fractionArray = normalise(num, denom);
        this.numerator = fractionArray[0];
        this.denominator = fractionArray[1];
    }



//    Normalize the fraction as you create it.
//    For instance, if the parameters are (8, -12), create a Fraction with numerator -2 and denominator 3.
//    Create a HELPER to reduce the fraction form, finding the greatest common divisor and returning the new numbers.
//    Two integers arguments are needed, and they must be given in the correct order - numerator, and denominator.


    // find greatest common denominator
    private static int gcd(int num, int denom)
    {
//        System.out.println("num = " + num + ", denom = " + denom);
        if (denom == 0) {
            if (num < 0) {
                num *= -1;
            }
//            System.out.println("returning num = " + num);
            return num;
        }
        return gcd(denom, num % denom);

    }
    public static int[] normalise(int num, int denom) {
        // deal with negatives first
        if (num < 0) {
            if (denom < 0) { // i.e. if both are negative
                num = num * -1;
                denom = denom * -1;
            } // no else statement as we do not need to do anything if only the num is negative
        } else if (denom < 0) { // i.e. num is positive (or zero) and only denom is -ve
            num = num * -1;
            denom = denom * -1;
        }
        int greatestCommonDenom;
        greatestCommonDenom = gcd(num, denom);

        num = num / greatestCommonDenom;
        denom = denom / greatestCommonDenom;

        int[] intArray = {num, denom};

        System.out.println("num = " + num + ", denom = " + denom);
        return intArray;
    }


    @Override
    public Fraction add(Fraction f) {
        return null;
    }

    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    @Override
    public Fraction abs() {
        return null;
    }

    @Override
    public Fraction negate() {
        return null;
    }

    @Override
    public Fraction inverse() {
        return null;
    }

//    @Override
//    public int compareTo(Fraction f) {
//        return 0;
//    }

    @Override
    public String toString() {
        return numerator +
                "/" + denominator;
    }
}
