public class Solution {

    public static void main(final String[] args) {
        System.out.println(checkPermutationSlow("abc", "cab"));            // True
        System.out.println(checkPermutationFaster("abc", "cba"));          // True
        System.out.println(checkPermutationSlow("abcd", "ab"));            // False
        System.out.println(checkPermutationFaster("abcd", "abcdeeee"));    // False
        System.out.println(checkPermutationSlow("abcd", "abcddcba"));      // False
        System.out.println(checkPermutationFaster("zxy", "zzxyx"));        // False
    }

    /*
     * Runtime complexity = O(N^2) since permutation and word are same length by definition of permutation
     * Space complexity = O(1)
    */
    private static boolean checkPermutationSlow(final String word,
                                                final String permutation) {
        if (permutation.length() != word.length()) { // O(1)
            return false;
        }

        final int wordLen = word.length();

        for (int j = 0; j < wordLen; j++) { // O(K)
            if (permutation.indexOf(word.charAt(j)) == -1) { // O(P)
                return false;
            }
        }

        return true;
    }

    /*
     * Runtime complexity = O(N), where N is word or permutation since word and permutation have equal length
     * Space complexity = O(1) since array for ascii is always fixed length of 128
     * If we make assumption that only ascii characters then we can speed up algo slightly
    */
    private static boolean checkPermutationFaster(final String word,
                                                  final String permutation) {
        if (permutation.length() != word.length()) {
            return false;
        }

        int letters[] = new int[128]; // ASCII

        for(int i = 0; i < word.length(); i++) {
            letters[word.charAt(i)]++;
        }

        for(int i = 0; i < permutation.length(); i++) {
            char c = permutation.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}