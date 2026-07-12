class Solution {
    boolean isValid(int nums[], int k, int n, int mid) { //isValid method
        int stu = 1; // member
        int pages = 0;

        for(int i = 0; i<n; i++) {
            if(nums[i] > mid) { // Important edge case check
                return false;
            }

            if(pages + nums[i] <= mid) {
                pages += nums[i];
            } else {
                stu++;
                pages = nums[i];
            }

            if(stu > k) return false;
            // if(stu <= k) return true;
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int st = 0;
        int sum = 0;
        // calculating sum of the elements of the array
        for(int i=0; i<n; i++) { 
            sum += nums[i];
        }
        int end = sum;
        int ans =-1;

        while(st <= end) {
            int mid = st + (end - st) / 2;
            if(isValid(nums, k, n, mid)) { // valid
                ans = mid;
                end = mid - 1;
            } else { // Invalid
                st = mid + 1;
            }
        }

        return ans;
    }
}