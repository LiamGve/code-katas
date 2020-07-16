public class Solution {
    /**
     * Problem:
     *
     * Given an NxM Matrix of type int[][], if any position in matrix has 0 then all entries in
     * same row and column must too become 0.
     *
     * Example:
     *
     * 11111
     * 11111
     * 10111
     * ->
     * 10111
     * 10111
     * 00000
     */
    public static void main(String... args) {
        int[][] output = zeroOutRowAndColSpaceEfficient(new int[][]{
                new int[] {1, 2, 3, 4, 0},
                new int[] {1, 2, 2, 2, 2},
                new int[] {3, 4, 5, 6, 7}
        });
        // Output should be:
        // 0,0,0,0,0
        // 1,2,2,2,0
        // 3,4,5,6,0

        for(int[] rows : output) {
            for(int i : rows) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    // Runtime: O(M * N)
    // Space: O(max(M, N))
    private static int[][] zeroOutRowAndColSpaceInefficient(int[][] input) {

        final int rows = input.length;
        final int cols = input[0].length;

        final boolean[] rowsFlag = new boolean[rows];
        final boolean[] colsFlag = new boolean[cols];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (input[x][y] == 0) {
                   rowsFlag[x] = true;
                   colsFlag[y] = true;
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            if (rowsFlag[i]) {
                input[i] = new int[cols]; // int arrays initialise to 0
            }
        }

        for(int i = 0; i < cols; i++) {
            if (colsFlag[i]) {
                for (int j = 0; j < rows; j++) {
                    input[j][i] = 0;
                }
            }
        }

        return input;
    }

    // Runtime: O(M * N)
    // Space: O(1)
    private static int[][] zeroOutRowAndColSpaceEfficient(final int[][] input) {
        // Since a matrix NxM is valid so too is a matrix of size (N-1)x(M-1)
        // With this in mind we can re-purpose a row and col in place of our flag arrays
        // that are used in space inefficient approach

        boolean firstRowHasZeros = false;
        boolean firstColHasZeros = false;

        int rows = input.length;
        int cols = input[0].length;

        for (int i = 0; i < cols; i++) {
            if (input[0][i] == 0) {
                firstRowHasZeros = true;
                break;
            }
        }

        for (int[] row : input) {
            if (row[0] == 0) {
                firstColHasZeros = true;
                break;
            }
        }

        // We can now think of row & col 1 as follows
        // final int[] rowsFlag = input[0]
        // final int[] colsFlag = input[...][0];

        for (int x = 1; x < rows; x++) {
            for (int y = 1; y < cols; y++) {
                if (input[x][y] == 0) {
                    input[0][y] = 0;
                    input[x][0] = 0;
                }
            }
        }


        for (int i = 1; i < rows; i++) {
            if (input[i][0] == 0) {
                input[i] = new int[cols];
            }
        }

        for (int i = 1; i < cols; i++) {
            if (input[0][i] == 0) {
                for (int j = 0; j < rows; j++) {
                    input[j][i] = 0;
                }
            }
        }

        if (firstRowHasZeros) {
            input[0] = new int[cols];
        }

        if (firstColHasZeros) {
            for(int i = 0; i < cols; i++) {
                input[0][i] = 0;
            }
        }

        return input;
    }

}
