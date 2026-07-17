class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int[] left = new int[n]; // Array to sore left smaller nearest elements
        int[] right = new int[n]; // Array to store right smaller nearest elements

        // Loop to calculate left smaller nearest elements
        for(int i=0; i<n; i++) {
            while(!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                s.pop();
            }

            if(s.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = s.peek();
            }

            s.push(i);
        }

        // Loop to make the stack empty after one pass
        while(!s.isEmpty()) {
            s.pop();
        }

        // Loop to calculate right smaller nearest elements
        for(int i=n-1; i>=0; i--) {
            while(!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                s.pop();
            }

            if(s.isEmpty()) {
                // right[i] = -1; // right smaller can not be -1
                right[i] = n;
            } else {
                right[i] = s.peek();
            }

            s.push(i);
        }

        // Loop to calculate the max Area 
        int ans = 0;
        for(int i=0; i<n; i++) {
            int width = right[i] - left[i] -1;
            int currArea = heights[i] * width;
            ans = Math.max(ans, currArea);
        }

        return ans;
    }
}