class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Try sizes from largest to smallest
        for (int k = Math.min(m, n); k >= 1; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (isMagic(grid, i, j, k)) {
                        return k;
                    }
                }
            }
        }
        return 1; // at least 1x1 always exists
    }

    // Check if subgrid starting at (row, col) of size k is magic
    private boolean isMagic(int[][] grid, int row, int col, int k) {

        int targetSum = 0;

        // First row sum
        for (int j = 0; j < k; j++) {
            targetSum += grid[row][col + j];
        }

        // Check all row sums
        for (int i = 0; i < k; i++) {
            int rowSum = 0;
            for (int j = 0; j < k; j++) {
                rowSum += grid[row + i][col + j];
            }
            if (rowSum != targetSum) return false;
        }

        // Check all column sums
        for (int j = 0; j < k; j++) {
            int colSum = 0;
            for (int i = 0; i < k; i++) {
                colSum += grid[row + i][col + j];
            }
            if (colSum != targetSum) return false;
        }

        // Main diagonal
        int diag1 = 0;
        for (int i = 0; i < k; i++) {
            diag1 += grid[row + i][col + i];
        }
        if (diag1 != targetSum) return false;

        // Anti-diagonal
        int diag2 = 0;
        for (int i = 0; i < k; i++) {
            diag2 += grid[row + i][col + k - 1 - i];
        }
        if (diag2 != targetSum) return false;

        return true;
    }
}
