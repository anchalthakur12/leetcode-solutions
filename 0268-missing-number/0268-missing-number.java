class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;

        int expectedSum = n*(n+1)/2;
        int avgSum = 0;

        for(int i = 0; i<n ;i++){
            avgSum += nums[i];
        }
        
        int ans = expectedSum - avgSum;
        return ans;
    }
}