class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int st = 0;
        int end = n - 1;

        if(n == 1) return nums[0];

        while(st <= end) {
            int mid = st + (end - st) / 2;

            // edge cases
            if(mid == 0 && nums[0] != nums[1]) return nums[mid];
            if(mid == n-1 && nums[n-1] != nums[n-2]) return nums[mid];

            // Main condtion check
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) {
                return nums[mid];
            }

            // Check left or right of MID is EVEN or ODD
            if(mid % 2 == 0) { // EVEN 
                if(nums[mid] == nums[mid-1]) {
                    end = mid - 1; // BS on left
                } else {
                    st = mid + 1; // BS on right
                }
            } else { // ODD
                if(nums[mid] == nums[mid-1]) {
                    st = mid + 1; // BS on Right
                } else {
                    end = mid -1; // BS on left
                }
            }
        }

        return -1;
    }
}