class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int mid = 0;
        int low = 0;
        int high = n-1;

        while(mid <= high) {
            // condition when mid == 0
            if(nums[mid] == 0) { 
                //swap(low,mid)
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            }
            // condition when mid == 1
            else if(nums[mid] == 1) { 
                mid++;
            }
            // condition when mid == 2
            else { 
                //swap(high,mid)
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;

                high--;
            }
        }
    }
}