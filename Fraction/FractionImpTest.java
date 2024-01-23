package Fraction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FractionImpTest {
//    testing all object creation options of this class and its possible errors


    @Test
    public void testFractionImplTwoInt (){
        FractionImplement f1 = new FractionImplement(9, 15); // standard normalisation
        assertEquals(f1.toString(), "3/5");

        FractionImplement f2 = new FractionImplement(3, -5); // -ve denom
        assertEquals(f2.toString(), "-3/5");

        FractionImplement f3 = new FractionImplement(-3, 5); // -ve num
        assertEquals(f3.toString(), "-3/5");

        FractionImplement f4 = new FractionImplement(-3, -9); // both -ve + fraction simplification
        assertEquals(f4.toString(), "1/3");

        FractionImplement f5 = new FractionImplement(5, 3); // num > denom
        assertEquals(f5.toString(), "5/3");

        FractionImplement f6 = new FractionImplement(5, 5); // num = denom
        assertEquals(f6.toString(), "1/1");

        FractionImplement f7 = new FractionImplement(0, 2); // num = denom
        assertEquals(f7.toString(), "0/1");

        assertThrows(IllegalArgumentException.class,
                ()->{
                    FractionImplement f8 = new FractionImplement(1, 0); // num = denom
                });
    }

    @Test
    public void testFractionImplOneInt (){
        FractionImplement f1 = new FractionImplement(23);
        assertEquals(f1.toString(), "23/1");

        FractionImplement f2 = new FractionImplement(-5);
        assertEquals(f2.toString(), "-5/1");

        FractionImplement f3 = new FractionImplement(0);
        assertEquals(f3.toString(), "0/1");
    }

    @Test
    public void testFractionImplTwoStrings (){
        FractionImplement f1 = new FractionImplement("3/9"); // standard expected String
        assertEquals(f1.toString(), "1/3");

        FractionImplement f2 = new FractionImplement("3/-9"); // with negative denom
        assertEquals(f2.toString(), "-1/3");

        FractionImplement f3 = new FractionImplement("3/  -9"); // with space before negative number
        assertEquals(f3.toString(), "-1/3");

        FractionImplement f4 = new FractionImplement("3/  -  9"); // with space around number
        assertEquals(f4.toString(), "-1/3");

        /*
        It is debatable whether we should 'correct' for the user error in the next 2 scenarios or throw an error.
        If this was a real application, we would go back to the PO to clarify the requirements.
        In this case, I chose to implement an extra step to 'correct' the user error because it was more challenging!
         */
        FractionImplement f5 = new FractionImplement("3/  / -9"); // with an extra slash
        assertEquals(f5.toString(), "-1/3");

        FractionImplement f6 = new FractionImplement("3/ / / -9"); // with multiple extra slashes
        assertEquals(f6.toString(), "-1/3");

    }
}


