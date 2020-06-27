public class Solution {
    // Assumption: All strings are in ASCII

    public static void main(String[] args) {
        System.out.println(slowHasAllUniqueCharacters("hello"));                  // False
        System.out.println(slowHasAllUniqueCharacters("world"));                  // True

        System.out.println(fastHasAllUniqueCharacters("uniqe"));                  // True
        System.out.println(fastHasAllUniqueCharacters("not a unique string...")); // False
    }


    // O(n^2)
    // n + n-1 + n-2 + ... n-(n-1)
    private static boolean slowHasAllUniqueCharacters(final String word) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // O(n)
    private static boolean fastHasAllUniqueCharacters(final String word) {
        if (word.length() > 128) {
            return false; // only 128 different chars in ASCII
        }

        boolean[] charBeenSeen = new boolean[128];

        for (int i = 0; i < word.length(); i++) {
            if (charBeenSeen[word.charAt(i)]) {
                return false;
            }
            charBeenSeen[word.charAt(i)] = true;
        }
        return true;
    }
}