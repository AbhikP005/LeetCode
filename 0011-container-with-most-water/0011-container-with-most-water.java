class Solution {
    public int maxArea(int[] height) {
        int lp = 0; // left pointer starts from the first
        int rp = height.length-1; // right pointer starts from the end
        int maxArea = 0;

        while(lp < rp) { // Loop until lp and rp collapse
            int wt = rp - lp; // width 
            int ht = Math.min(height[lp], height[rp]); //height

            int area = ht * wt; //area

            maxArea = Math.max(maxArea, area); //maxArea update

            // update the pointer whose height is smaller
            if(height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxArea;
    }
}