public class Solution {
    /**
     * Problem:
     *
     * You are given a method `isSubString` that takes in 2 string params and returns boolean based on whether 2nd param is
     * sub string of 1st param. By calling this method exactly once, write a function with 2 String inputs to determine
     * whether or not 2nd param is rotation of 1st param.
     *
     * Example of rotation:
     *
     * dog -> gdo (true)
     * cat -> clt (false)
     */

    public static void main(String... args) {
        System.out.println(isRotationConvoluted("waterbottle", "ttlewaterbo"));
        System.out.println(isRotationImproved("waterbottle", "ttlewaterbo"));
        System.out.println(isRotationConvoluted("waterbottle", "t0lewaterbo"));
        System.out.println(isRotationImproved("waterbottle", "t0lewaterbo"));
    }


    // Runtime: O(5N) = O(N)
    // Space: O(1)
    private static boolean isRotationConvoluted(final String original,
                                                final String rotation) {
        if (original.length() != rotation.length()) {
            return false;
        }

        int matchStartsAt = 0;
        int originalPointer = 0;
        for (int i = 0; i < rotation.length(); i++) { // O(N)
            if (original.charAt(originalPointer) == rotation.charAt(i)) {

                originalPointer++;

                if (matchStartsAt == 0) {
                    matchStartsAt = i;
                }

            } else {
                matchStartsAt = 0;
            }
        }

        final boolean partialStringisSub = isSubString(original, rotation.substring(matchStartsAt)); // O(N)

        if (partialStringisSub) {
            final String remaining = original.substring(original.length() - matchStartsAt); // O(N)
            final String remainPart2 = rotation.substring(0,matchStartsAt); // O(N)

            return remaining.equals(remainPart2); // O(N)
        } else {
            return false;
        }
    }

    // Runtime: O(N)
    // Space: O(1)
    private static boolean isRotationImproved(final String original,
                                              final String rotation) {
        if (original.length() != rotation.length()) {
            return false;
        }

        final String doubleOriginal = original + original; // O(N)
        return isSubString(doubleOriginal, rotation);
    }

    // O(input + sub)
    private static boolean isSubString(final String input,
                                       final String sub) {
        return input.contains(sub);
    }
}
