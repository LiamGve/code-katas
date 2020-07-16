public class Solution {
    /**
     * Problem: Given an NxN matrix of integers, rotate 90 degrees
     */

    public static void main(String... args) {
        final int[][] output = rotateMatrixSpaceEfficient(new int[][]{
            new int[]{1, 1, 1, 1},
            new int[]{2, 2, 2, 2},
            new int[]{3, 3, 3, 3},
            new int[]{4, 4, 4, 4}
        });
        // Output should be:
        // 4, 3, 2, 1,
        // 4, 3, 2, 1,
        // 4, 3, 2, 1,
        // 4, 3, 2, 1

        for(int[] line : output) {
            for(int i : line) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * Runtime: O(N^2) where N is row length
     * Space: O(N) since we store in an output array the same as input
     */
    private static int[][] rotateMatrixSpaceInefficient(final int[][] input) {
        // matrices are perfect squares to row and col the same
        final int rowSize = input.length;

        final int[][] output = new int[rowSize][rowSize];

        for (int x = 0; x < rowSize; x++) {
            for (int y = 0; y < rowSize; y++) {
                output[y][rowSize - x - 1] = input[x][y];
            }
        }

        return output;
    }

    /**
     * Runtime: O(N^2) where N is row length
     * Space: O(1)
     */
    private static int[][] rotateMatrixSpaceEfficient(final int[][] input) {
        final int rowSize = input.length;

        for (int layer = 0; layer < rowSize / 2; layer ++) {
            final int end = rowSize - layer - 1;

            for(int x = layer; x < end; x++) {
                int offset = x - layer;

                // Can be further reduced but this is easier to read imo
                int top = input[layer][x];
                int right = input[x][end];
                int bottom = input[end][end - offset];
                int left = input[end - offset][layer];

                input[x][end] = top;
                input[end][end - offset] = right;
                input[end - offset][layer] = bottom;
                input[layer][x] = left;
            }
        }
        return input;
    }
}

