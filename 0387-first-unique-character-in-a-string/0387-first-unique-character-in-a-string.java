class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            m.put(ch, m.getOrDefault(ch, 0) + 1);

            if (m.get(ch) == 1) {
                q.offer(i);
            }

            while (!q.isEmpty() && m.get(s.charAt(q.peek())) > 1) {
                q.poll();
            }
        }

        if(q.isEmpty()) return -1;
        
        return q.peek();
    }
}