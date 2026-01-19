class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        // Step 1: Build prefix sum matrix
        int[][] pref = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1]
                           + pref[i - 1][j]
                           + pref[i][j - 1]
                           - pref[i - 1][j - 1];
            }
        }

        // Step 2: Binary search on side length
        int low = 0, high = Math.min(m, n);
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (existsSquare(pref, mid, threshold)) {
                ans = mid;        // valid size
                low = mid + 1;    // try bigger
            } else {
                high = mid - 1;   // try smaller
            }
        }

        return ans;
    }

    private boolean existsSquare(int[][] pref, int k, int threshold) {
        if (k == 0) return true;

        int m = pref.length - 1;
        int n = pref[0].length - 1;

        for (int i = k; i <= m; i++) {
            for (int j = k; j <= n; j++) {
                int sum = pref[i][j]
                        - pref[i - k][j]
                        - pref[i][j - k]
                        + pref[i - k][j - k];

                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
