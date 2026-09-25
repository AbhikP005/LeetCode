class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        int rme = 0;

        // Finding pivot
        for(int i=n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                pivot = i;
                break;
            }
        }

        // Edge case -- if pivot is not found e.g. example 2
            if(pivot == -1) {
                Arrays.sort(nums);
                return;
            }

        // Find the right most element
        for(int i=n-1; i>=pivot; i--) {
            if(nums[i] > nums[pivot]) {
                rme = i;
                break;
            }
        }

        // Swap the pivot and right most element
        int temp = nums[pivot];
        nums[pivot] = nums[rme];
        nums[rme] = temp;
        
        // reverse pivot+1 to n-1
        int st = pivot+1;
        int end = n-1;
        while(st < end) {
            int temps = nums[st];
            nums[st] = nums[end];
            nums[end] = temps;

            st++;
            end--;
        }
    }
}