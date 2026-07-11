class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        // to mitigate edge cases we start from 1 and end to n-2
        int st = 1; 
        int end = n-2;

        while(st <= end) {
            int mid = st + (end - st) / 2;

            if(arr[mid-1] < arr[mid] && arr[mid]> arr[mid+1]) { // if mid is the largest then return
                return mid;
            }

            if(arr[mid-1] < arr[mid]) { // Mid is at increasing part the -> BS on decreasing part
                st = mid + 1;
            } else { // Mid is at decreasing part then -> BS on increasing part
                end = mid - 1;
            }
        }

        return -1;
    }
}