/**
 * CISC 380
 * Algorithms Assignment 4
 * <p>
 * Tests the methods of the PalindromicSubsequence class.
 *
 * @author Daniel Taufiq
 * Due Date: 4/3/2020
 * <p>
 * This driver file contains a single example test case to get you started.
 * You should include more test cases to ensure that your implementation works correctly.
 * You do NOT need to submit this file.
 */


public class PalindromicSequenceDriver
{
    public static void main(String[] args)
    {
        String x = "AACGAA";
        String y = "racecar";
        String z = "";
        String a = null;
        String b  = "a";
        String c = "aa";
        String d = "ab";
        String e = "gkg";
        String f = "agffca";
        String g = "saippuakivikauppias";

        // test even size palindrome
        System.out.println("Expected : 5" + " Actual: " + PalindromicSequence.getLengthLongestPalindrome(x));
        System.out.println("original: " + x + " Result: " + PalindromicSequence.getLongestPalindrome(x)+"\n");
        // test odd size palindrome and whole word sequence is a palindrome
        System.out.println("Expected : 7" + " Actual: " + PalindromicSequence.getLengthLongestPalindrome(y));
        System.out.println("original: " + y + " Result: " + PalindromicSequence.getLongestPalindrome(y)+"\n");
        // test empty string
        System.out.println("Expected : 0" + " Actual: " + PalindromicSequence.getLengthLongestPalindrome(z));
        System.out.println("original: " + z + " Result: " + PalindromicSequence.getLongestPalindrome(z)+"\n");
        // test null String
        System.out.println("Expected : 0" + " Actual: " + PalindromicSequence.getLengthLongestPalindrome(a));
        System.out.println("original: " + a + " Result: " + PalindromicSequence.getLongestPalindrome(a)+"\n");
        // test one letter palindrome
        System.out.println("Expected : 1" + " Actual: " + PalindromicSequence.getLengthLongestPalindrome(b));
        System.out.println("original: " + b + " Result: " + PalindromicSequence.getLongestPalindrome(b)+"\n");
        // test two letter palindrome
        System.out.println("Expected : 2" + " Actual: " + PalindromicSequence.getLengthLongestPalindrome(c));
        System.out.println("original: " + c + " Result: " + PalindromicSequence.getLongestPalindrome(c)+"\n");
        // test two letter non-palindrome
        System.out.println("Expected : 1" + " Actual: " + PalindromicSequence.getLengthLongestPalindrome(d));
        System.out.println("original: " + d + " Result: " + PalindromicSequence.getLongestPalindrome(d)+"\n");
        // test three letter palindrome
        System.out.println("Expected : 3" + " Actual: " + PalindromicSequence.getLengthLongestPalindrome(e));
        System.out.println("original: " + e + " Result: " + PalindromicSequence.getLongestPalindrome(e)+"\n");
        // rest of the tests are just random examples
        System.out.println("Expected : 4" + " Actual: " + PalindromicSequence.getLengthLongestPalindrome(f));
        System.out.println("original: " + f + " Result: " + PalindromicSequence.getLongestPalindrome(f)+"\n");
        System.out.println("Expected : 19" + " Actual: " + PalindromicSequence.getLengthLongestPalindrome(g));
        System.out.println("original: " + g + " Result: " + PalindromicSequence.getLongestPalindrome(g)+"\n");

        String h = "sfsdadfsd";
        System.out.println("Expected : 4" + " Actual: " + PalindromicSequence.getLengthLongestPalindrome(h));
        System.out.println("original: " + h + " Result: " + PalindromicSequence.getLongestPalindrome(h)+"\n");
    }//main
}//class