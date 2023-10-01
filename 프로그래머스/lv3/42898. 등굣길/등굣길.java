import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n+1][m+1];  
        int[][] puddle = new int[n+1][m+1];  
        
        // 물웅덩이 위치 따로 저장 - 문제와 달리 물웅덩이 위치 가로 세로 반대로 되어있음
        for(int i=0; i<puddles.length; i++){
            puddle[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        // 해당 칸에 도달하는 최단 거리 저장
        dp[1][1] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                // 시작점 제외
                if(i==1 && j==1) continue;
                
                if(puddle[i][j] == -1) continue; // 물웅덩이라면
                
                // 위와 왼쪽에서 오는 경우를 더한다
                dp[i][j] += (dp[i][j-1]+dp[i-1][j])%1000000007;
                
            }
        }
        
        return dp[n][m];     
    }
}