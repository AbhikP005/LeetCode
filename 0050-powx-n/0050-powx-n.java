class Solution {
    public double myPow(double x, int n) {
        long binform = n; // Convert n to long

        if(n < 0) { // If n is negative 
            x = 1/x; // 3^-5 = 1/3^5
            binform = -binform; // -5 becomes 5
        }

        double ans = 1; // Innitialization

        while(binform > 0) { // Loop until binform > 0 
            if(binform % 2 == 1) {
                ans *= x;
            }
            x*=x;
            binform /= 2;
        }

        return ans;
    }

    public static void main(String args[]) {
        Solution newSol = new Solution();
        double result = newSol.myPow(3,5);
        System.out.println(result);
    }
}