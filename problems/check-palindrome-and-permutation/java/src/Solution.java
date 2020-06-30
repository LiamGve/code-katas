/**
 * Problem: check if any of a string's permutations are a palindrome
 * e.g.
 *  Input: rraceca
 *  Output: true ('racecar' is a palindrome and permutation of input)
 */
public class Solution {
    public static void main(final String[] args) {
        System.out.println(hasPalindromePermutation("rraceca")); // true
        System.out.println(hasPalindromePermutation("tactcoa")); // true
        System.out.println(hasPalindromePermutation("eeeeopa")); // false
    }

    // O(N) Runtime
    // O(1) Space complexity
    private static boolean hasPalindromePermutation(final String input) {
        final int[] asciiChars = new int[128]; // ASCII bounds

        for (int i = 0; i < input.length(); i++) {
            asciiChars[input.charAt(i)]++;
        }

        boolean onlyOneOddFound = false;

        for (int i : asciiChars) {
            if (i % 2 != 0) {
                if (onlyOneOddFound) {
                    return false;
                }
                onlyOneOddFound = true;
            }
        }
        return true;
    }
}

