package BasicConcepts.Logic2;

//Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. Return 0 if they both go over.
//
//        Blackjack(19, 21) → 21
//        Blackjack(21, 19) → 21
//        Blackjack(19, 22) → 19

public class Blackjack {
    public static void main(String[] args) {
        System.out.println(checkFor21(19,21));
        System.out.println(checkFor21(21,19));
        System.out.println(checkFor21(19,22));
        System.out.println(checkFor21(17,18));
        System.out.println(checkFor21(23,24));
    }

    public static int checkFor21(int num1, int num2) {
        if (num1 > 21 & num2 > 21) {
            return 0;
        } else if (num1 > 21) {
            return num2;
        } else if (num2 > 21) {
            return num1;
        } else {
            if (21-num1 < 21-num2) {
                return num1;
            } else {
                return num2;
            }
        }
    }
}
