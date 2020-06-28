public class Solution {

    public static void main(final String[] args) {
        System.out.println(urlifyConcise("some new input     "));
    }

    // O(N)
    private static String urlifyConcise(final String rawInput) {
        return rawInput
                .trim()                                      // O(N)
                .replaceAll(" ", "%20");  // O(N)
    }
}