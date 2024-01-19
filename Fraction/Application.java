package Fraction;

import java.util.List;

public class Application {
    public static void main(String[] args) {
//        new FractionImplement(1, 2);
        new FractionImplement(2, 4); // normalise
//        new FractionImplement(2, 3); // no change
//        new FractionImplement(3, 2); // no change, num > denom
//        new FractionImplement(-2, 4);
//        new FractionImplement(2, -4);
//        new FractionImplement(-2, -4);
//        FractionImplement test1 = new FractionImplement("2/4");
//        FractionImplement test2 = new FractionImplement("2/4");
//        new FractionImplement("   2/  / 4  ");
//        new FractionImplement("-2/-4");
//        gcd(-2, 4);

//        System.out.println(test1.add((Fraction) test2));

        Fraction ff = new FrenchFraction();
        Fraction fi = new FractionImplement(1, 2);

        List<Fraction> fractions = List.of(ff, fi);

        fi.add(ff);
    }
}
