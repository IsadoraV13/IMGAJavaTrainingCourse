package BasicConcepts.Array3;

// Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value.
// Return the number of clumps in the given array.
//
// CountClumps([1, 2, 2, 3, 4, 4]) → 2
// CountClumps([1, 1, 2, 1, 1]) → 2
// CountClumps([1, 1, 1, 1, 1]) → 1

public class CountClumps {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 2, 3, 4, 4};
        int[] array2 = {1, 1, 2, 1, 1};
        int[] array3 = {1, 1, 1, 1, 1};
        int[] array4 = {1, 2, 2, 3, 4, 4, 7, 7}; // 3
        int[] array5 = {1, 2, 2, 3, 4, 4, 7, 7, 7, 1}; // 3
        System.out.println(countClumps(array1));
        System.out.println(countClumps(array2));
        System.out.println(countClumps(array3));
        System.out.println(countClumps(array4));
        System.out.println(countClumps(array5));

    }

    public static int countClumps(int[] givenArray) {
        int counter = 0;
        for (int i = 0; i < givenArray.length-1; i++) {
            if (givenArray[i] == givenArray[i+1]) {
                counter ++;
                int j = i;
                while (j < givenArray.length-2 && givenArray[j+1] == givenArray[j+2]) {
                    j++;
                }
                i = j+1;
            }
        }
        return counter;
    }
}
