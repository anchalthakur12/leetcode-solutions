class Solution {
    public int minimumPairRemoval(int[] nums) {
        // Convert array to list for easy removal/insertion
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        int operations = 0;

        // Keep performing operations until array is non-decreasing
        while (!isNonDecreasing(list)) {

            int minSum = Integer.MAX_VALUE;
            int index = 0;

            // Find leftmost adjacent pair with minimum sum
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            // Replace the pair with their sum
            list.remove(index);       // remove first element of pair
            list.set(index, minSum);  // replace second with sum

            operations++;
        }

        return operations;
    }

    // Helper function to check if list is non-decreasing
    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    
}