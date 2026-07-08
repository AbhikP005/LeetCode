class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int st = 0;
        int end = n-1;

        while(st <= end) {
            // Find mid
            int mid = st + (end - st) / 2; 
            if(nums[mid] == target) {
                return mid;
            } // if target got in mid return

            // find if the left part of the rotated array is sorted or right part
            if(nums[st] <= nums[mid]) { // -> left sorted
                // BS on left part
                if(nums[st] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }                    
            } else { // -> Right Sorted 
                // BS on right part
                if(nums[mid] <= target && target <= nums[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}