class Solution {
    public long solution(int n) {
        int[] dp = new int[n+2];
        
        /*
        n=1이면 (1)                 1
        n=2이면 (1+1),(2)           2
        n=3이면 (1+1+1),(2+1),(1+2) 3
        n=4이면 (1+1+1+1),(2+1+1),(1+2+1),(1+1+2),(2,2) 5
        n칸을 뛰는 방법의 수는 dp[i] = dp[i-1] + dp[i-2] ex) 4 = 2 + 3
        -> 피보나치 수열 
        */
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1]+dp[i-2])%1234567;
        }
        return dp[n];
    }
}