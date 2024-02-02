package Fraction;

import java.util.Arrays;
import java.util.stream.Stream;

public class FractionImplement implements Fraction{

//    Parameters can be:
//    1- the numerator and the denominator (ints)
//    2- whole number (a int representing the numerator and the denominator is implicit 1)
//    3 - a string containing the numerator and the denominator OR a whole number

    /*
    I have made this class Immutable by not having setters. I've used final for the instance variables
     */
    private final int numerator;
    private final int denominator;

    //    The constructor should throw an ArithmeticException if the denominator is zero.
    //    Normalize the fraction as you create it.
    /* 
    I thought it might be better to throw an IllegalArgumentException as opposed to going one step further and trying
    a computation that we know would result in an ArithmeticException - happy to get feedback/discuss.
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

    /*
    1) I'm learning about streams and still struggling, so wanted to try to use it here.
    2) I'm still not entirely comfortable with method references so although IntelliJ suggested using that instead of
    lambdas, I stuck with lambdas as they are easier for me to read at this stage
    3) I mentioned to Rich that my code was not yet solving for scenarios like "   2/  /  / 4  " and he suggested I
    explore regex - he did not help me solve it, so I went and researched it. I implemented in stages (i.e. initially
    it worked for one edge case, but not the next one, so I did it various iterations)
     */
    // overloaded constructor to take strings
    public FractionImplement(String fractionNumsAsStrings) throws IllegalArgumentException {
        int[] intArray = convertStringInputToIntArray(fractionNumsAsStrings);
        int num  = intArray[0];
        int denom = 1;
        if (intArray.length == 2) {
            denom = intArray[1];
        }

        int[] fractionArray = normalise(num, denom);
        this.numerator = fractionArray[0];
        this.denominator = fractionArray[1];
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }


    // find greatest common denominator
    /*
    I found this code online. In the past, I struggled to re-use code because I felt like I needed to either write it
    myself or fully understand. So it felt like a positive step forward that I was able to take the code, sanity check
    it, incorporate in my code and move on.
     */
    //    Create a HELPER to reduce the fraction form, finding the greatest common divisor and returning the new numbers.
    //    Two integers arguments are needed, and they must be given in the correct order - numerator, and denominator.
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


    //    Normalize the fraction as you create it.
    //    For instance, if the parameters are (8, -12), create a Fraction with numerator -2 and denominator 3.
    private int[] normalise(int num, int denom) {
        // deal with negatives first
        System.out.println("Before normalisation, num: " + num + ", denom: " + denom);
        if (num < 0) {
            if (denom < 0) { // i.e. if both are negative
                num *= -1;
                denom *= -1;
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

        System.out.println("After normalisation, num: " + num + ", denom: " + denom);
        return intArray;
    }


    private int[] convertStringInputToIntArray(String fractionNumsAsStrings) {
        int [] intArray = Stream.of(fractionNumsAsStrings.replaceAll("\\s","") // remove whitespace
                        .replaceAll("/{2,}", "/") // remove any "//" left after whitespace removed
                        .split("/", 0))// split to get numbers on either side of "/"
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();
        if (intArray.length > 2)  {
            throw new IllegalArgumentException("please only specify two numbers separated by '/' ");
        }
        return intArray;
    }


    //    Returns a new Fraction that is the SUM of this and the parameter:
    //    a/b + c/d = (ad + bc)/bd
    @Override
    public Fraction add(Fraction f) {
        FractionImplement fImpl = (FractionImplement) f; /*  Struggled with this part, thankfully Rudy helped me :) */
        int computeNum = (this.getNumerator() * fImpl.getDenominator()) + (this.getDenominator() * fImpl.getNumerator());
        int computeDenom = this.getDenominator() * fImpl.getDenominator();
        return new FractionImplement(computeNum, computeDenom);
    }


    //    Returns a new Fraction that is the DIFFERENCE between this and the parameter:
    //    a/b - c/d = (ad - bc)/bd
    public Fraction subtract(Fraction f) {
        FractionImplement fImpl = (FractionImplement) f;
        int computeNum = (this.getNumerator() * fImpl.getDenominator()) - (this.getDenominator() * fImpl.getNumerator());
        int computeDenom = this.getDenominator() * fImpl.getDenominator();
        return new FractionImplement(computeNum, computeDenom);
    }


    //    Returns a new Fraction that is the PRODUCT between this and the parameter:
    //    (a/b) * (c/d) = (a*c)/(b*d)
    @Override
    public Fraction multiply(Fraction f) {
        FractionImplement fImpl = (FractionImplement) f;
        int computeNum = this.getNumerator() * fImpl.getNumerator();
        int computeDenom = this.getDenominator() * fImpl.getDenominator();
        return new FractionImplement(computeNum, computeDenom);
    }


    //    Returns a new Fraction that is the QUOTIENT between this and the parameter:
    //    (a/b) / (c/d) = (a*d)/(b*c)
    @Override
    public Fraction divide(Fraction f) {
        FractionImplement fImpl = (FractionImplement) f;
        int computeNum = this.getNumerator() * fImpl.getDenominator();
        int computeDenom = this.getDenominator() * fImpl.getNumerator();
        return new FractionImplement(computeNum, computeDenom);
    }

    //    Returns a new Fraction that is the ABSOLUTE value of this fraction
    @Override
    public Fraction abs() { /* */
        int num = this.getNumerator();
        if (this.getNumerator() < 0) {
            num = this.getNumerator() * -1;
        }
        return new FractionImplement(num, this.getDenominator());
    }


    //    Returns a new Fraction that has the same numeric value of this fraction, but the opposite sign.
    @Override
    public Fraction negate() {
        int num = this.getNumerator() * -1;
        return new FractionImplement(num, this.getDenominator());
    }


    //    Return the inverse. The inverse of a/b is b/a.
    @Override
    public Fraction inverse() { /*/ my understanding is that passing (a, -b) to the constructor returns -a/b, and that
    therefore the inverse is -b/a */
        int num = this.getDenominator();
        int denom = this.getNumerator();
        return new FractionImplement(num, denom);
    }

    //    Returns:
    //      - 1 if this is less than fraction o
    //      0 if it's equal
    //      1 if it's greater than fraction o

    /*
    I was not sure how to implement this - what are the different ways?
     */
    @Override
    public int compareTo(Fraction o) {
        Fraction difference = this.subtract(o);
        if (difference.toString().charAt(0) == '-') {
            return -1;
        } else if (difference.toString().equals("0/1")) {
            return 0;
        } else {
            return 1;
        }
    }

    //    Returns true if object o is a Fraction equal to this, and false in all other cases.
    @Override
    public boolean equals(Fraction f) {
        Fraction difference = this.subtract(f);
        if (difference.toString().equals("0/1")) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return numerator +
                "/" + denominator;
    }
}
