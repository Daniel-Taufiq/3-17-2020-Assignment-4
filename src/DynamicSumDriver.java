import java.util.Arrays;

/**
 * CISC 380
 * Algorithms Assignment 4
 * <p>
 * Tests the methods of the DynamicSum class.
 *
 * @author Daniel Taufiq
 * Due Date: 4/3/2020
 * <p>
 * This driver file contains a single example test case to get you started.
 * You should include more test cases to ensure that your implementation works correctly.
 * You do NOT need to submit this file.
 */


public class DynamicSumDriver
{

    public static void main(String[] args)
    {

        DynamicSum dSum = new DynamicSum();

        // test with out-of-range
        int[] testArr = {3, 1, 4, 1, 5, 9, 2, 6};   // t = 14
        System.out.println("Sum: " + 35);
        System.out.println("original Array: " + Arrays.toString(testArr));
        System.out.println("iteration: " + dSum.isSum(testArr, 35));
        System.out.println("memoization: " + dSum.isSumMem(testArr, 35));
        System.out.println("subset: " + Arrays.toString(dSum.getSubset(testArr, 35))+"\n");

        // test valid solution odd size array
        int[] testArr2 = {2, 3, 7, 8, 10};
        System.out.println("Sum: " + 11);
        System.out.println("original Array: " + Arrays.toString(testArr2));
        System.out.println("iteration: " + dSum.isSum(testArr2, 11));
        System.out.println("memoization: " + dSum.isSumMem(testArr2, 11));
        System.out.println("subset: " + Arrays.toString(dSum.getSubset(testArr2, 11))+"\n");

        // test valid solution even size array
        int[] testArr3 = {5, 8, 2, 4};
        System.out.println("Sum: " + 12);
        System.out.println("original Array: " + Arrays.toString(testArr3));
        System.out.println("iteration: " + dSum.isSum(testArr3, 12));
        System.out.println("memoization: " + dSum.isSumMem(testArr3, 12));
        System.out.println("subset: " + Arrays.toString(dSum.getSubset(testArr3, 12))+"\n");

        // test no solution odd size array
        int[] testArr4 = {2, 3, 7, 8, 10};
        System.out.println("Sum: " + 6);
        System.out.println("original Array: " + Arrays.toString(testArr4));
        System.out.println("iteration: " + dSum.isSum(testArr4, 6));
        System.out.println("memoization: " + dSum.isSumMem(testArr4, 6));
        System.out.println("subset: " + Arrays.toString(dSum.getSubset(testArr4, 6))+"\n");

        // test no solution even size array
        int[] testArr5 = {5, 8, 2, 4};
        System.out.println("Sum: " + 6);
        System.out.println("original Array: " + Arrays.toString(testArr5));
        System.out.println("iteration: " + dSum.isSum(testArr5, 6));
        System.out.println("memoization: " + dSum.isSumMem(testArr5, 6));
        System.out.println("subset: " + Arrays.toString(dSum.getSubset(testArr5, 6))+"\n");

        // test small array
        int[] testArr6 = {5, 5};
        System.out.println("Sum: " + 10);
        System.out.println("original Array: " + Arrays.toString(testArr6));
        System.out.println("iteration: " + dSum.isSum(testArr6, 10));
        System.out.println("memoization: " + dSum.isSumMem(testArr6, 10));
        System.out.println("subset: " + Arrays.toString(dSum.getSubset(testArr6, 10))+"\n");

        // test one element
        int[] testArr7 = {10};
        System.out.println("Sum: " + 10);
        System.out.println("original Array: " + Arrays.toString(testArr7));
        System.out.println("iteration: " + dSum.isSum(testArr7, 10));
        System.out.println("memoization: " + dSum.isSumMem(testArr7, 10));
        System.out.println("subset: " + Arrays.toString(dSum.getSubset(testArr7, 10))+"\n");

        // test empty array
        int[] testArr8 = {};
        System.out.println("Sum: " + 10);
        System.out.println("original Array: " + Arrays.toString(testArr8));
        System.out.println("iteration: " + dSum.isSum(testArr8, 10));
        System.out.println("memoization: " + dSum.isSumMem(testArr8, 10));
        System.out.println("subset: " + Arrays.toString(dSum.getSubset(testArr8, 10))+"\n");

        // test empty array
        int[] testArr9 = null;
        System.out.println("Sum: " + 10);
        System.out.println("original Array: " + Arrays.toString(testArr9));
        System.out.println("iteration: " + dSum.isSum(testArr9, 10));
        System.out.println("memoization: " + dSum.isSumMem(testArr9, 10));
        System.out.println("subset: " + Arrays.toString(dSum.getSubset(testArr9, 10))+"\n");

        // this special case test is needed if we have sum = 0 and our array
        // contains an element 0, to return 0
        int[] testArr10 = {0};
        System.out.println("Sum: " + 0);
        System.out.println("original Array: " + Arrays.toString(testArr10));
        System.out.println("iteration: " + dSum.isSum(testArr10, 0));
        System.out.println("memoization: " + dSum.isSumMem(testArr10, 0));
        System.out.println("subset: " + Arrays.toString(dSum.getSubset(testArr10, 0))+"\n");

        // Extra tests
        int[] testArr11 = {1,2,3,4,5,6,7,8};
        System.out.println("Sum: " + 10);
        System.out.println("original Array: " + Arrays.toString(testArr11));
        System.out.println("iteration: " + dSum.isSum(testArr11, 10));
        System.out.println("memoization: " + dSum.isSumMem(testArr11, 10));
        System.out.println("subset: " + Arrays.toString(dSum.getSubset(testArr11, 10))+"\n");

        int[] testArr12 = {4,5,6,8,2,1,3};
        int t = 7;
        System.out.println("Sum: " + t);
        System.out.println("original Array: " + Arrays.toString(testArr12));
        System.out.println("iteration: " + dSum.isSum(testArr12, t));
        System.out.println("memoization: " + dSum.isSumMem(testArr12, t));
        System.out.println("subset: " + Arrays.toString(dSum.getSubset(testArr12, t))+"\n");

    }//main

}//class