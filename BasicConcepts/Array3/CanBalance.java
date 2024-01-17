package BasicConcepts.Array3;

// Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side
// is equal to the sum of the numbers on the other side.
//
// CanBalance([1, 1, 1, 2, 1]) → true
// CanBalance([2, 1, 1, 2, 1]) → false
// CanBalance([10, 10]) → true

import java.util.Arrays;

public class CanBalance {
    public static void main(String[] args) {
        int [] array1 = {1, 1, 1, 2, 1};
        int [] array2 = {2, 1, 1, 2, 1};
        int [] array3 = {10, 10};
        int [] array4 = {2, 1, 2, 3, 1, 1, 1, 4, 7};
        int [] array5 = {7};
        System.out.println(canBalanceCheck(array1));
        System.out.println(canBalanceCheck(array2));
        System.out.println(canBalanceCheck(array3));
        System.out.println(canBalanceCheck(array4));
        System.out.println(canBalanceCheck(array5));
    }

    public static boolean canBalanceCheck(int [] givenArray) {
        int sumLeft = 0;
        Integer sumRight = Arrays.stream(givenArray).sum();

        for (int i = 0; i < givenArray.length-1; i++) {
            sumLeft += givenArray[i];
            sumRight -= givenArray[i];
            if (sumLeft == sumRight) {
                System.out.println(i);
                return true;
            }

        }
        return false;
    }
}
