
//https://leetcode.com/problems/perfect-squares/description/
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
         dp[0]=0;
         dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=i;
            for(int k=2;k*k<=i;k++){
                dp[i]=Math.min(dp[i],dp[i-k*k]+1);
            }
        }
        return dp[n];
    }
}