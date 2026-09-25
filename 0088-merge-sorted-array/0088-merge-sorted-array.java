class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // innitialization
        int idx = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        // Traverse backwards
        while(i>=0 && j>=0){
            // Find which element is bigger
            if(nums1[i] >= nums2[j]){
                // Swap the bigger element with nums1[idx]
                nums1[idx] = nums1[i];
                idx--;
                i--;
            } else {
                // Swap the bigger element with nums1[idx]
                nums1[idx] = nums2[j];
                idx--;
                j--;
            }
        }

        // Now if i < 0
        // Traverse the element of nums2 backwards
        while(j>=0){
            // Swap the nums2 elements with nums1[idx]
            nums1[idx] = nums2[j];
            idx--;
            j--;
        }
    }
}