class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {

        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);
            int found = -1;

            // Try all possible x from 0 to p-1
            for (int x = 0; x < p; x++) {
                if ((x | (x + 1)) == p) {
                    found = x;
                    break; // smallest found
                }
            }

            ans[i] = found;
        }

        return ans;
    }
}
