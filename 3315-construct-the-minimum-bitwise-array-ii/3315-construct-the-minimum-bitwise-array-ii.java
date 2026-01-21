class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            // Even numbers are impossible
            if ((num & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            int k = 0;
            int temp = num;

            // Count trailing 1s
            while ((temp & 1) == 1) {
                k++;
                temp >>= 1;
            }

            // Subtract 2^(k-1)
            ans[i] = num - (1 << (k - 1));
        }

        return ans;
    }
}
