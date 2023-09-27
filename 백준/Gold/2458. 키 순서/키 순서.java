import java.io.*;
import java.util.*;

public class Main {
	static int INF = 500*500;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 학생들의 수
		int M = Integer.parseInt(st.nextToken()); // 학생 키를 비교한 횟수
		int[][] dp = new int[N+1][N+1];
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp.length; j++) {
				dp[i][j] = INF;
			}
		}
		
		// start -> end 정보 저장
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			dp[start][end] = 1;
		}
		
		// 최단 경로 저장
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {

					// 중간 다리가 있는 경로와 아닌 경로 중 최솟값을 저장 - INF가 아닌 다른 수가 저장되면 비교 가능하다는 의미
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}

		
		int result = 0; // 자신이 키가 몇번째인지 알 수 있는 학생 수
		
		// 자신이 키가 몇번째인지 알려면 다른 학생의 키와 비교를 할 수 있어야 함
		for(int i=1; i<=N; i++) {
			int count = 0;
			for(int j=1; j<=N; j++) {
				// 작은쪽 큰쪽 모두 봐야하기 떄문에 역방향도 고려해줘야 함
				if(dp[i][j] != INF || dp[j][i] != INF)
					count++;
			}
			
			// count == N-1이라면 자기자신을 제외하고 모두 비교가능하다는 의미
			if(count == N-1) result++;
		}
		
		System.out.println(result);
	}
	
}