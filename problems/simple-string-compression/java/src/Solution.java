public class Solution {
    /**
     * See python solution for problem statement
     */
    public static void main(String... args) {
        System.out.println(compress("aaaabbbbccccddddeeeef")); // a4b4c4d4e4f1
        System.out.println(compress("aaaabbbbccccddddeeeefgggijjjppp")); // a4b4c4d4e4f1g3i1j3p3
        System.out.println(compress("gg")); // gg
        System.out.println(compress("ggg")); // g3
        System.out.println(compress("abcd")); // abcd
    }

    /**
     * O(N + K) Where N is the input string and K is the number of sequences
     */
    private static String compress(final String input) {
        final StringBuilder builder = new StringBuilder();

        char current = '_';
        int amount = 0;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != current) {
                if (current != '_') {
                    builder.append(current).append(amount);
                }
                current = c;
                amount = 1;
            } else {
                amount++;
            }
        }

        builder.append(current).append(amount);

        final String output = builder.toString();

        if (output.length() >= input.length()) {
            return input;
        }

        return output;
    }
}
