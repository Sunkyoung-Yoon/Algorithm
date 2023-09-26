import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게
		int[] W = new int[N+1]; // 물품별 무게를 저장할 배열
		int[] V = new int[N+1]; // 물품별 가치를 저장할 배열
		int[][] dp = new int[N+1][K+1]; // 무게별 배낭에 최대로 담을 수 있는 가치
		
		// 물품의 무게와 가치를 저장
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				dp[i][j] = dp[i-1][j]; // 바로 이전 값 저장
				
				// 현재 담을 수 있는 무게에서 지금 i번째 물품의 무게를 빼고 남는 무게가 있거나 같다면
				// -> 이전 값 말고 다른 값도 저장 시도 가능
				if(j - W[i] >= 0) {
					// 이전 값이랑 이전 물품이 처음 담긴 가치에다가 내 가치를 더한 것
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}

}