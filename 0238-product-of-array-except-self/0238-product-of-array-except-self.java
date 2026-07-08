class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length]; // The ans array       
        int n = nums.length;

        // Prefix loop
        ans[0] = 1;
        for(int i=1; i<n; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }

        // suffix Loop
        int suffix = 1;
        for(int i=n-2; i>=0; i--) {
            suffix *= nums[i+1];
            ans[i] *= suffix;
        }

        return ans;
    }
}