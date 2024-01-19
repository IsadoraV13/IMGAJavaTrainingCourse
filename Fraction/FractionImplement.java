package Fraction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class FractionImplement implements Fraction{

//    Parameters can be:
//    1- the numerator and the denominator (ints)
//    2- whole number (a int representing the numerator and the denominator is implicit 1)
//    3 - a string containing the numerator and the denominator OR a whole number

    private final int numerator;
    private final int denominator;

    //    The constructor should throw an ArithmeticException if the denominator is zero.
    //    Normalize the fraction as you create it.
    /* 
    I thought it might be better to throw an IllegalArgumentException - happy to get feedback
     */
    public FractionImplement(int numerator, int denominator) throws IllegalArgumentException {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator cannot be zero");
        }
        int[] fractionArray = normalise(numerator, denominator);
        this.numerator = fractionArray[0];
        this.denominator = fractionArray[1];
    }

    // overloaded constructor to take a single int as numerator
    public FractionImplement(int numerator)  {
        this.numerator = numerator;
        this.denominator = 1;
    }

    // overloaded constructor to take strings
    /*
    I'm learning about streams and still struggling, so wanted to try to use it here.
    I'm still not entirely comfortable with method references so although IntelliJ suggested using that instead of
    lambdas, I stuck with lambdas
     */
    public FractionImplement(String fractionNumsAsStrings) throws IllegalArgumentException {
        //Todo: currently doesn't work for "2 / / 4"
        int [] intArray = Stream.of(fractionNumsAsStrings.split("/", 0))
                .map(s -> s.strip())
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

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    //    Normalize the fraction as you create it.
    //    For instance, if the parameters are (8, -12), create a Fraction with numerator -2 and denominator 3.
    //    Create a HELPER to reduce the fraction form, finding the greatest common divisor and returning the new numbers.
    //    Two integers arguments are needed, and they must be given in the correct order - numerator, and denominator.



    // find greatest common denominator
    /*
    I found this code online. In the past, I struggled to re-use code because I felt like I needed to either write it
    myself or fully understand
     */
    private int reduce(int num, int denom)
    {
        if (denom == 0) {
            if (num < 0) {
                num *= -1;
            }
            return num;
        }
        return reduce(denom, num % denom);

    }
    public int[] normalise(int num, int denom) {
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
        greatestCommonDenom = reduce(num, denom);

        num = num / greatestCommonDenom;
        denom = denom / greatestCommonDenom;
        int[] intArray = {num, denom};

        System.out.println("num = " + num + ", denom = " + denom);
        return intArray;
    }


    //    Returns a new Fraction that is the SUM of this and the parameter:
    //    a/b + c/d = (ad + bc)/bd
    @Override
    public Fraction add(Fraction f) {
        FractionImplement fImpl = (FractionImplement) f; /*  Struggled with this part, thankfully Rudy helped me :) */
        int computeNum = (numerator * fImpl.getDenominator()) + (denominator * fImpl.getNumerator());
        System.out.println("num: " + computeNum);
        int computeDenom = this.denominator * fImpl.getDenominator();
        System.out.println("den: " + computeDenom);
        return new FractionImplement(computeNum, computeDenom);
    }


    //    Returns a new Fraction that is the DIFFERENCE between this and the parameter:
    //    a/b - c/d = (ad - bc)/bd
    public Fraction subtract(Fraction f) {
        FractionImplement fImpl = (FractionImplement) f;
        int computeNum = (this.numerator * fImpl.getDenominator()) - (this.denominator * fImpl.getNumerator());
        int computeDenom = this.denominator * this.numerator;
        return new FractionImplement(computeNum, computeDenom);
    }


    //    Returns a new Fraction that is the PRODUCT between this and the parameter:
    //    (a/b) * (c/d) = (a*c)/(b*d)
    @Override
    public Fraction multiply(Fraction f) {
        FractionImplement fImpl = (FractionImplement) f;
        int computeNum = (this.numerator * this.denominator) / (fImpl.getNumerator() * fImpl.getDenominator());
        int computeDenom = this.denominator * fImpl.getDenominator();
        return new FractionImplement(computeNum, computeDenom);
    }


    //    Returns a new Fraction that is the QUOTIENT between this and the parameter:
    //    (a/b) / (c/d) = (a*d)/(b*c)
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    //    Returns a new Fraction that is the ABSOLUTE value of this fraction
    @Override
    public Fraction abs() {
        return null;
    }


    //    Returns a new Fraction that has the same numeric value of this fraction, but the opposite sign.
    @Override
    public Fraction negate() {
        return null;
    }


    //    Return the inverse. The inverse of a/b is b/a.
    @Override
    public Fraction inverse() {
        return null;
    }

    @Override
    public int compareTo(Fraction f) {
        return 0;
    }

    //    Returns true if object o is a Fraction equal to this, and false in all other cases.
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return numerator +
                "/" + denominator;
    }
}
