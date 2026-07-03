public class Solution {
    public int maxSubArray(int[] nums) {
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE; // innitialize*

        for(int i=0; i<nums.length; i++) {
            currsum += nums[i]; // calculating the currsum
            maxsum = Math.max(currsum, maxsum); // Finding the maximum sum

            if(currsum < 0) { // Kadanes Algo
                currsum = 0;
            }
        }

        return maxsum;
    }

    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        Solution k = new Solution(); // Object creation
        System.out.println(k.maxSubArray(nums)); // Call
    }
}