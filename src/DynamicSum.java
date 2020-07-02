import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * CISC 380
 * Algorithms Assignment 4
 * <p>
 * Implements dynamic programming solutions to see if a subset adds up to a value.
 *
 * @author Daniel Taufiq
 * Due Date: 4/3/2020
 */


public class DynamicSum
{
    ArrayList<Integer> list;
    boolean[][] T;

    public DynamicSum()
    {
        list = new ArrayList<Integer>();    // used to store our output
    }//constructor

    /**
     * Checks to see if a subset of arr adds up to exactly t with an iterative solution.
     *
     * @param arr the array of integers to take subsets from.
     * @param t   the value the subset could add up to.
     * @return True, if a subset adds up to t, false otherwise.
     */

    /*
        Big-O Analysis: Our code uses one for-loop giving O(n) time. Although, this is not the
                        dominating term. We use 2 for-loops in our method to fill out the table.
                        the number of rows correspond to the length of the input array. The number
                        of columns is the size from 0 to total. So, both row and column will vary in
                        length. Everything inside is constant O(1) since they are accessing array
                        indices. Our overall runtime gives us: O(n*m) --> m = total
     */
    public boolean isSum(int[] arr, int t)
    {
        // make sure we have a non-empty array
        if(arr == null)
        {
            return false;
        }

        // this creates our (# of elements (y-axis) by sum (x-axis)) table
        this.T = new boolean[arr.length + 1][t + 1];

        // array list will hold our subset
        list = new ArrayList<Integer>();

        /*
            INITIALIZE FIRST COLUMN:
            the first column is true because by looking
            at sum = 0 (first column), we either exclude element (element being
            whatever row we look at) or include it. If we include element i,
            we won't get sum = 0, but excluding (empty set) we get
            sum = 0. That's why we say the first column is all true because
            it ends up as (T || F) for all of column 1. T being excluding,
            F being including and we take T
         */
        for (int i = 0; i <= arr.length; i++)
        {
            T[i][0] = true;
        }

        /*
            We want to check if we can form sum at i = __
            using whatever array element we are looking at.
            First case:
            If we include our current element, can we form the sum
            using this element + any elements above it. We do this
            by going up a row and subtracting by the array element
            to see if that (i-1, j - arr[i - 1]) element is T. If so,
            we can form the sum that includes the current element
            Second case:
            if we exclude this element, we check if we can form the sum.
            We can check this by looking at the row above our current row,
            if it is true, we say that we can still form the sum by
            excluding this current element.

            i = array length
            j = length from 0 to total

         */
        for (int i = 1; i <= arr.length; i++)
        {
            for (int j = 1; j <= t; j++)
            {
                // if column j is less than value of arr[i], grab the element above it
                if (arr[i - 1] > j)
                {
                    T[i][j] = T[i - 1][j];
                }
                else
                {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - arr[i - 1]];
                }
            }
        }

        /*
            return maximum value (bottom right table answer). Returning
            true means we can form a sum using some subset of these numbers.
            Returning false means there's no possibility of forming a subset
            to equal the sum
         */
        return T[arr.length][t];

    }//isSum

    /**
     * Recovers the subset of arr that adds up to t, if it exists.
     *
     * @param arr the array of integers to take subsets from.
     * @param t   the value the subset could add up to.
     * @return a subset of arr that adds up to t, null otherwise.
     */
    /*
        Big-O Analysis: We call our isSum method which we know has a running time
                        of O(n*m). Then, we call our recursive method (recovery())
                        which recurses on a 2d table in a loop-like fashion that gives
                        us O(m+n) since we only go through a select path of the table.
                        O(n*m) is the dominant factor so this is our running time.
     */
    public int[] getSubset(int[] arr, int t)
    {
        boolean canBeSummed = false;
        int[] arrayToReturn;

        // check to see if we can get a subset summing to the total
        canBeSummed = isSum(arr, t);

        // special case for array with 0 and sum is 0
        if((arr != null && arr.length == 1) && arr[0] == 0 && t  == 0)
        {
            list.add(0);
        }
        else if (canBeSummed)
        {
            // call recovery that will add values to the arraylist
            recovery(arr.length, t, arr);
        }
        else
        {
            return null;
        }

        // below code converts ArrayList to array and resets the ArrayList
        arrayToReturn = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
        {
            arrayToReturn[i] = list.get(i);
        }
        list = new ArrayList<Integer>();
        return arrayToReturn;

    }//getSubset

    /*
        Big-O Analysis: We get a running time of O(n+m) since
        we go through a select path in our table during recursion.
     */
    public void recovery(int i, int j, int[] arr)
    {
        // base case
        if (i == 0 || j == 0)
        {
            return;
        }

        // if the above cell is true, this means that we
        // don't want to add our array value to the answer
        // so keep going up the table until we hit false
        if (T[i][j] == true && T[i - 1][j] == true)
        {
            i = i - 1;
            recovery(i, j, arr);
        }
        else
        {
            // add our value to the table and then
            // go left by the value of the array element
            // at that row
            list.add(arr[i - 1]);
            j = j - arr[i - 1];
            i = i - 1;
            recovery(i, j, arr);
        }
    }

    /**
     * Checks to see if a subset of arr adds up to exactly t with a memoizied solution.
     *
     * @param arr the array of integers to take subsets from.
     * @param t   the value the subset could add up to.
     * @return True, if a subset adds up to t, false otherwise.
     */
    /*
        Big-O Analysis: We have a few options while recursing, either include
        or do not include the current element. We will make recursion calls and
        will continue until we hit a base case of either top row (false) or
        left column (true). This gives us O(n*m) n -> array length and m -> sum
     */
    public boolean isSumMem(int[] arr, int t)
    {
        // make sure we have a non-empty array
        if(arr == null)
        {
            return false;
        }
        // this creates our (# of elements (y-axis) by sum (x-axis)) table
        this.T = new boolean[arr.length + 1][t + 1];

        int i = arr.length;
        int j = t;
        boolean ans = memoization(false, i, j, arr);
        return ans;

    }//isSumMem

    /*
        Big-O Analysis: Just like it is stated in the wrapper method called
        isSumMem(), we find this method is the dominating term since we are
        doing most of the work here in O(n*m) time.
     */
    private boolean memoization(boolean result, int i, int j, int[] arr)
    {
        // we hit top row and top column, we were able to get the sum
        if(i == 0 && j == 0)
        {
            return true;
        }
        // top row reached, we cannot reach the sum with this array
        if(i == 0)
        {
            return false;
        }
        // left column reached, we hit the sum
        if(j == 0)
        {
            return true;
        }

        // check if answer is already solved
        if(T[i][j] == true)
        {
            return true;
        }

        // don't try to include it if you overshoot where sum = 0 (first column in table)
        if(arr[i-1] > j)
        {
            // don't include array element
            result = memoization(T[i - 1][j], i-1, j, arr);
        }
        else
        {
            // try to include it first, else don't include it
            result = memoization(T[i - 1][j - arr[i-1]], i-1, j-arr[i-1], arr) || memoization(T[i - 1][j], i-1, j, arr);
        }
        return result;
    }

}//class