/**
 * Problem:
 */
public class Solution {
    public static void main(final String[] args) {
        System.out.println(checkOneRuleAway("pale", "ple"));   // True
        System.out.println(checkOneRuleAway("pales", "pale")); // True
        System.out.println(checkOneRuleAway("pale", "bale"));  // True
        System.out.println(checkOneRuleAway("pale", "pale"));  // True
        System.out.println(checkOneRuleAway("pale", "bake"));  // False
    }

    // Runtime complexity O(max(originalStr, newStr)) = O(N)
    private static boolean checkOneRuleAway(final String originalStr,
                                            final String newStr) {

        final int length = originalStr.length() - newStr.length(); // 1, then rule1, -1 then rule2, 0 then rule3

        if (length == 0) {
            boolean foundDiffChar = false;

            for (int i = 0; i < originalStr.length(); i++) {
                if (originalStr.charAt(i) != newStr.charAt(i)) {
                    if (foundDiffChar) {
                        return false;
                    }
                    foundDiffChar = true;
                }
            }
            return true;
        } else if (length == 1) {
            return checkCharInsert(originalStr, newStr);
        } else if (length == -1) {
            return checkCharInsert(newStr, originalStr);
        }

        return false;
    }

    private static boolean checkCharInsert(final String larger,
                                           final String smaller) {
        int i = 0;
        int j = 0;
        while (i < larger.length() && j < smaller.length()) {
            if (smaller.charAt(i) != larger.charAt(j)) {
                if (i != j) {
                    return false;
                }
            } else {
                i++;
            }
            j++;
        }
        return true;
    }
}
