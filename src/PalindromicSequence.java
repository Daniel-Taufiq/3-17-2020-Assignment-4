/**
 * CISC 380
 * Algorithms Assignment 4 EXTRA CREDIT
 * <p>
 * Implements a dynamic programming solution to find the length of the longest palindromic subsequence.
 *
 * @author Daniel Taufiq
 * Due Date: 4/3/2020
 */


public class PalindromicSequence
{

    /**
     * Implements a dynamic programming solution to find the length of the longest Palindromic subsequence of the given string.
     *
     * @param x the string that may contain a palindromic subsequence
     * @return the length of the longest palindromic subsequence, or 0 if there is none.
     */
    public static int getLengthLongestPalindrome(String x)
    {
        // check to see if string is null or empty
        if (x == null || x.length() < 1)
        {
            return 0;
        }

        // create 2-D array using length of String
        int[][] T = new int[x.length()][x.length()];

        // initialize the diagonal cell 1 because every character that
        // matches each other represent length 1
        for (int i = 0; i < x.length(); i++)
        {
            T[i][i] = 1;
        }

        // we are looping diagonally in O(n^2)
        for (int diag = 1; diag < x.length(); diag++)
        {
            for (int i = 0; i + diag < x.length(); i++)
            {
                // if two characters match, take the previous diagonal element
                // plus 2 because if it's a palindrome, it will contain those 2 pairs in answer
                if (x.charAt(i) == x.charAt(i + diag))
                {
                    T[i][i + diag] = T[i + 1][i + diag - 1] + 2;
                }
                else
                {
                    // if characters aren't equal, take the max of the cell
                    // to the left or down.
                    T[i][i + diag] = Math.max(T[i + 1][i + diag], T[i][i + diag - 1]);
                }
            }
        }
        // our answer is in the top right of the table
        return T[0][x.length() - 1];
    }//longestPalindrome

    /**
     * Implements a dynamic programming solution to return the longest palindromic subsequence of the given string
     *
     * @param x the string that may contain a palindromic subsequence
     * @return the string of the longest palindrome, or null if there is none
     */
    public static String getLongestPalindrome(String x)
    {
        // must have non-empty string
        if (x == null || x.length() < 1)
        {
            return null;
        }

        // table
        int[][] T;

        // create our table and fill the values
        T = fillTable(x);

        // start top left
        int size = T[0][x.length() - 1];

        // check if our answer in the table has value greater than 1, if not, there's no palindrome
        if (T[0][x.length() - 1] == 1 && x.length() > 1)
        {
            // because our palindrome doesn't have an answer beyond a size of
            // 2, just return any letter, we will return the first character.
            return x.charAt(0) + "";
        }
        // if palindrome is small (1 or 2 characters) return it since it's always a palindrome
        if (size < 2)
        {
            return x;
        }
        // must have some sequence to recover
        if (size > 0)
        {
            char[] sequence = new char[size];   // used to fill in our subsequence answer
            String ans = recovery(0, x.length() - 1, 0, size - 1, sequence, T, x);
            return ans;
        } else
        {
            return null;
        }
    }

    // i and j represent T row and column
    // s and e represent our char[] table to fill
    // sequence is the table to fill
    // x and y represent the table string x-axis and y-axis
    private static String recovery(int i, int j, int s, int e, char[] sequence, int[][] T, String x)
    {
        // if we have odd string and we hit base case while matching chars
        if (sequence.length % 2 == 1 && x.charAt(i) == x.charAt(j) && T[i][j] == 1 || T[i][j] == 0)
        {
            sequence[e] = x.charAt(i);  // add char to the end
            return "";
        }
        // if our chars match and we're near the end, we might either hit our base
        // case or miss it, so this check ensures we catch both.
        if (x.charAt(i) == x.charAt(j) && T[i][j] == 1 || T[i][j] == 0)
        {
            return "";
        }

        // if both characters match, we came from the diagonal
        // add character on both start and end pointers in sequence
        // recurse down the bottom left diagonal
        if (x.charAt(i) == x.charAt(j))
        {
            sequence[s] = x.charAt(i);  // add char to start
            sequence[e] = x.charAt(i);  // add char to end
            i = i + 1;                  // row down
            j = j - 1;                  // column left
            s = s + 1;                  // move pointer right
            e = e - 1;                  // move pointer left
            recovery(i, j, s, e, sequence, T, x);
        }
        // if we don't have a match, check if both bottom
        // and left are the same, then it doesn't matter our direction
        else if (T[i + 1][j] == T[i][j - 1])
        {
            // choose to move left (but we could go down too)
            j = j - 1;
            recovery(i, j, s, e, sequence, T, x);
        }
        // we find where the current value came from and recurse that direction (left or down)
        else
        {
            // if max is on the bottom, recurse bottom
            if (T[i + 1][j] > T[i][j - 1])
            {
                i = i + 1;  // move down one row
            }
            // max is on the left
            else if (T[i + 1][j] < T[i][j - 1])
            {
                j = j - 1; // move one column left
            }
            recovery(i, j, s, e, sequence, T, x);
        }

        // convert our char array to String and return
        String text = String.valueOf(sequence);
        return text;
    }

    private static int[][] fillTable(String x)
    {
        int[][] T = new int[x.length()][x.length()];

        // initialize the diagonal cell 1 because every character that
        // matches each other represent length 1
        for (int i = 0; i < x.length(); i++)
        {
            T[i][i] = 1;
        }

        // we are looping diagonally in O(n^2)
        for (int diag = 1; diag < x.length(); diag++)
        {
            for (int i = 0; i + diag < x.length(); i++)
            {
                // if two characters match, take the previous diagonal element
                // plus 2 because if it's a palindrome, it will contain those 2 pairs in answer
                if (x.charAt(i) == x.charAt(i + diag))
                {
                    T[i][i + diag] = T[i + 1][i + diag - 1] + 2;
                }
                else
                {
                    // if characters aren't equal, take the max of the cell
                    // to the left or down.
                    T[i][i + diag] = Math.max(T[i + 1][i + diag], T[i][i + diag - 1]);
                }
            }
        }
        // return table
        return T;
    }


}//class