class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        HashMap<Integer, Integer> m = new HashMap<>(); // Hashmap to store the values
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[nums1.length];

        for(int i = n-1; i >=0; i--) { // reverse loop
            // If lesser elements are there in stack pop them
            while(!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }

            //If stack is empty then ans is -1
            if(s.isEmpty()) {
                m.put(nums2[i], -1);
            }else {
                // else the ans is the top element
                m.put(nums2[i], s.peek());
            }

            s.push(nums2[i]); 
        }

        // Traverse the nums1 to get the Next Greater elements of nums1 seeing the hashmap
        for(int i=0; i<nums1.length; i++) {
            ans[i] = m.get(nums1[i]);
        }

        return ans;
    }
}