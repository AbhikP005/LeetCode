class Solution {
    public int majorityElement(int[] nums) {
        int ans = 0;
        int freq = 0;

        for (int i = 0; i < nums.length; i++) {
            if (freq == 0) {
                ans = nums[i];
            }

            // Moore's Voting Algorithm
            if (ans == nums[i]) {
                freq ++;
            } else freq --;

        }
        return ans;
    }

    public static void main(String args[]) {
        int nums[] = {2,2,1,1,1,2,2};
        Solution sol = new Solution();
        int result = sol.majorityElement(nums);
        System.out.println(result);
    }
}