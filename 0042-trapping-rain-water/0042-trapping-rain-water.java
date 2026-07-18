// Two Pointer Approach
class Solution { 
    public int trap(int[] height) {
        int n = height.length;
        int l = 0; // left pointer
        int r = n-1; // right pointer
        int ans = 0;
        int lmax = 0;
        int rmax = 0;

        while(l < r) {
            // calculate LeftMax and RightMax
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            // Whichever poiter gives smaller update that because only smaller height decide the answer
            if(lmax < rmax) {
                ans += lmax - height[l];
                l++;
            } else {
                ans += rmax - height[r];
                r--;
            }
        }
        return ans;
    }
}