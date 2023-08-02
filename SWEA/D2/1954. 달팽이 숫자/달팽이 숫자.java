import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    StringBuilder sb = new StringBuilder();
	    
	    int t = sc.nextInt();
	    for(int tc=1; tc<=t; tc++) {
	        int n = sc.nextInt();
	        int[][] map = new int[n][n];
	        int[] di = {0,1,0,-1}; //우하좌상
	        int[] dj = {1,0,-1,0};
	        
	        int nexti = 0;
	        int nextj = 0;
	        int d = 0;
	        for(int i=0; i<n*n; i++) {
	        	map[nexti][nextj] = i+1;
	        	
	        	// 방향이 안 바뀌면 같은 방향으로 숫자 증가
	        	nexti += di[d];
                nextj += dj[d];
                
	        	// 방향이 바뀌게 되는 경우
                // 배열 범위 벗어나거나 이미 값이 채워진 경우는 갈 수 없음
                if(nexti<0 || nexti>=n || nextj<0 || nextj>=n
                		|| map[nexti][nextj] != 0) {
                	// 다시 이전으로 돌아가기
                	nexti -= di[d];
                	nextj -= dj[d];
                	
                	// 방향전환
                	d = (d+1)%4; // 0,1,2,3
                	
                	nexti += di[d];
                	nextj += dj[d];
                }
	            
	            
	        }
	        
	        sb.append("#"+tc).append("\n");
	        for(int i=0; i<n; i++) {
	            for(int j=0; j<n; j++) {
	                sb.append(map[i][j]+" ");
	            }
	            sb.append("\n");
	        }
	    }
	    
	    System.out.println(sb);
	}

}