package BasicConcepts.Logic2;

//We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and big bars (5 kilos each).
// Return the number of small bars to use, assuming we always use big bars before small bars. Return -1 if it can't be done.
//
//        MakeChocolate(4, 1, 9) → 4
//        MakeChocolate(4, 1, 10) → -1
//        MakeChocolate(4, 1, 7) → 2

/* I think there is missing info for this question. I have assumed that the parameters (a, b, c) are
(number of small bars, number of big bars, goal)
*/
public class MakeChocolate {
    public static void main(String[] args) {

        System.out.println(makeChoc(4, 1, 9));
        System.out.println(makeChoc(4, 1, 10));
        System.out.println(makeChoc(4, 1, 7));
    }

    public static int makeChoc(int small, int big, int goal) {
        int numberOfSmallBarsNeeded = goal - (big * 5);
        if (numberOfSmallBarsNeeded > small) {
            return -1;
        } else {
            return numberOfSmallBarsNeeded;
        }
    }
}
