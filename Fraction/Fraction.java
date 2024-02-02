package Fraction;

// Representing fractions of the form numerator and denominator
// The object should be immutable.


public interface Fraction extends Comparable<Fraction> {

    public Fraction add(Fraction f);
//    Returns a new Fraction that is the SUM of this and the parameter:
//    a/b + c/d = (ad + bc)/bd


    public Fraction subtract(Fraction f);
//    Returns a new Fraction that is the DIFFERENCE between this and the parameter:
//    a/b - c/d = (ad - bc)/bd

    public Fraction multiply(Fraction f);
//    Returns a new Fraction that is the PRODUCT between this and the parameter:
//    (a/b) * (c/d) = (a*c)/(b*d)

    public Fraction divide(Fraction f);
//    Returns a new Fraction that is the QUOTIENT between this and the parameter:
//    (a/b) / (c/d) = (a*d)/(b*c)

    public Fraction abs();
//    Returns a new Fraction that is the ABSOLUTE value of this fraction

    public Fraction negate();
//    Returns a new Fraction that has the same numeric value of this fraction, but the opposite sign.

    public Fraction inverse();
//    Return the inverse. The inverse of a/b is b/a.


    @Override
    public boolean equals(Object o);
//    Returns true if object o is a Fraction equal to this, and false in all other cases.


    @Override
    public int compareTo(Fraction f);
//    Returns:
//      - 1 if this is less than fraction o
//      0 if it's equal
//      1 if it's greater than fraction o

    //    Returns true if object o is a Fraction equal to this, and false in all other cases.
    boolean equals(Fraction f);

    @Override
    public String toString();
//    Returns a String of the form numerator/denominator (n/d). However, if d is equal to 1, just return n.
//    The returned String should not contain any blanks.
//    If the fraction represents a negative number, a minus sign should precede n.

}