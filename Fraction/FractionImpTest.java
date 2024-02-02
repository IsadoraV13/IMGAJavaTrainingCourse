package Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionImpTest {
//    testing all object creation options of this class and its possible errors

    /* Was I not supposed to test the other methods? */


    /* I ran a simple toSTring test here, and given this works, but I assumed the toString method was being tested
    implicitly (and more widely) in all the other test scenarios below. Is that correct?"
     */
    @Test
    public void testToString() {
        FractionImplement f1 = new FractionImplement("2 / 3");
        assertEquals("2/3", f1.toString());

        FractionImplement f2 = new FractionImplement(-2, -3);
        assertEquals("2/3", f2.toString());

        FractionImplement f3 = new FractionImplement( -3);
        assertEquals("-3/1", f3.toString());
    }

    @Test
    public void testFractionImplTwoInt (){
        FractionImplement f1 = new FractionImplement(9, 15); // standard normalisation
        assertEquals( "3/5", f1.toString());

        FractionImplement f2 = new FractionImplement(3, -5); // -ve denom
        assertEquals("-3/5", f2.toString());

        FractionImplement f3 = new FractionImplement(-3, 5); // -ve num
        assertEquals("-3/5", f3.toString());

        FractionImplement f4 = new FractionImplement(-3, -9); // both -ve + fraction simplification
        assertEquals("1/3", f4.toString());

        FractionImplement f5 = new FractionImplement(5, 3); // num > denom
        assertEquals("5/3", f5.toString());

        FractionImplement f6 = new FractionImplement(5, 5); // num = denom
        assertEquals("1/1", f6.toString());

        FractionImplement f7 = new FractionImplement(0, 2); // num = denom
        assertEquals("0/1", f7.toString());

        assertThrows(IllegalArgumentException.class,
                ()->{
                    FractionImplement f8 = new FractionImplement(1, 0); // throws error
                });
    }

    @Test
    public void testFractionImplOneInt (){
        FractionImplement f1 = new FractionImplement(23);
        assertEquals("23/1", f1.toString());

        FractionImplement f2 = new FractionImplement(-5);
        assertEquals("-5/1", f2.toString() );

        FractionImplement f3 = new FractionImplement(0);
        assertEquals("0/1", f3.toString());

        FractionImplement f4 = new FractionImplement(0, 2); // num = denom
        assertEquals("0/1", f4.toString());

    }

    @Test
    public void testFractionImplString (){
        FractionImplement f0 = new FractionImplement("9"); // standard expected String
        assertEquals("9/1", f0.toString()); /* I initially did not have this first test and my code did not
        cater for a scenario where only a single number was passed as a string, so when I wrote this test it failed
        and that was my baby step into TDD :) */

        FractionImplement f1 = new FractionImplement("3/9"); // standard expected String
        assertEquals("1/3", f1.toString());

        FractionImplement f2 = new FractionImplement("3/-9"); // with negative denom
        assertEquals("-1/3", f2.toString());

        FractionImplement f3 = new FractionImplement("3/  -9"); // with space before negative number
        assertEquals("-1/3", f3.toString());

        FractionImplement f4 = new FractionImplement("3/  -  9"); // with space around number
        assertEquals("-1/3", f4.toString());

        assertThrows(IllegalArgumentException.class,
                ()->{
                    FractionImplement f5 = new FractionImplement("3/3/-9"); // throws error
                });

        /*
        For the next 2 scenarios, it is debatable whether we should 'correct' for the user error or throw an error.
        If this was a real application, we would go back to the PO to clarify the requirements.
        In this case, I chose to implement an extra step to 'correct' the user error because it gave me an extra
        challenge to figure out how to implement this!
        So the 'assumption' here is that there are extra forward slashes but only 2 numbers, then it's a typo and the
        'user' intended to pass a fraction with those 2 numbers
         */
        FractionImplement f6 = new FractionImplement("3/  / -9"); // with an extra slash
        assertEquals("-1/3", f6.toString());

        FractionImplement f7 = new FractionImplement("3/ / / -9"); // with multiple extra slashes
        assertEquals("-1/3", f7.toString());
    }


    @Test
    public void testAdd() {
        // adding 2 standard fractions
        FractionImplement f1 = new FractionImplement(1, 3);
        assertEquals("1/1", f1.add(new FractionImplement(2, 3)).toString());

        // adding a negative to a positive
        FractionImplement f2 = new FractionImplement(1, -3);
        assertEquals("0/1", f2.add(new FractionImplement(1, 3)).toString());

        // adding to create a fraction > 1
        FractionImplement f3 = new FractionImplement(1, 3);
        assertEquals("4/3", f3.add(new FractionImplement(3, 3)).toString());
    }

    @Test
    public void testSubtract() {
        // adding 2 standard fractions
        FractionImplement f1 = new FractionImplement(2, 3);
        assertEquals("1/3", f1.subtract(new FractionImplement(1, 3)).toString());

        // resulting in a negative
        FractionImplement f2 = new FractionImplement(1, 3);
        assertEquals("-1/3", f2.subtract(new FractionImplement(2, 3)).toString());

        // resulting in a fraction > 1 (with mixed input type & normalisation)
        FractionImplement f3 = new FractionImplement("2");
        assertEquals("4/3", f3.subtract(new FractionImplement(2, 3)).toString());

        // subtract a negative = addition
        FractionImplement f4 = new FractionImplement("2 / 3");
        assertEquals("1/1", f4.subtract(new FractionImplement("1/-3")).toString());
    }

    @Test
    public void testAbs() {
        FractionImplement f1 = new FractionImplement("-1 / 3");
        assertEquals("1/3", f1.abs().toString());

        FractionImplement f2 = new FractionImplement(1, -3);
        assertEquals("1/3", f2.abs().toString());

        FractionImplement f3 = new FractionImplement(-1, -3);
        assertEquals("1/3", f3.abs().toString());

        FractionImplement f4 = new FractionImplement(1, 3);
        assertEquals("1/3", f4.abs().toString());
    }

    @Test
    public void testNegate() {
        FractionImplement f1 = new FractionImplement(-1, 3);
        assertEquals("1/3", f1.negate().toString());

        FractionImplement f2 = new FractionImplement("1/ -3");
        assertEquals("1/3", f2.negate().toString());

        FractionImplement f3 = new FractionImplement(-3, -9);
        assertEquals("-1/3", f3.negate().toString());

        FractionImplement f4 = new FractionImplement(3, 9);
        assertEquals("-1/3", f4.negate().toString());

        FractionImplement f5 = new FractionImplement(9);
        assertEquals("-9/1", f5.negate().toString());
    }

    @Test
    public void testInverse() {
        FractionImplement f1 = new FractionImplement(-3, 9);
        assertEquals("-3/1", f1.inverse().toString());

        FractionImplement f2 = new FractionImplement(1, -3);
        assertEquals("-3/1", f2.inverse().toString());

        FractionImplement f3 = new FractionImplement("-3/-9");
        assertEquals("3/1", f3.inverse().toString());

        FractionImplement f4 = new FractionImplement(3, 9);
        assertEquals("3/1", f4.inverse().toString());

        FractionImplement f5 = new FractionImplement(9);
        assertEquals("1/9", f5.inverse().toString());
    }

    @Test
    public void testCompareTo() {
        // this is greater
        FractionImplement f1 = new FractionImplement(1, 2);
        assertEquals(1, f1.compareTo(new FractionImplement(1, 4)));

        // this is smaller
        FractionImplement f2 = new FractionImplement(1, 4);
        assertEquals(-1, f2.compareTo(new FractionImplement(1)));

        // this is equal
        FractionImplement f3 = new FractionImplement("3 / 9");
        assertEquals(0, f3.compareTo(new FractionImplement(-6, -18)));

    }

    @Test
    public void testEquals() {
        // these 2 values are equal
        FractionImplement f1 = new FractionImplement(1, 2);
        assertTrue(f1.equals(new FractionImplement(-2, -4)));

        // these 2 values are equal
        FractionImplement f2 = new FractionImplement(1, 2);
        assertTrue(f2.equals(new FractionImplement("-2/ -4")));

        // these 2 values are not equal
        FractionImplement f3 = new FractionImplement(1, 2);
        assertFalse(f3.equals(new FractionImplement("2/ -4")));

    }
}


