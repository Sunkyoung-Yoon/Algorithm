import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] nums; // 칠판에 적은 수들을 저장할 배열
	static boolean[][] dp; // 각 구간 별로 팰린드롬인지 판별 결과를 저장할 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 수열의 크기
		
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N+1]; 
		dp = new boolean[N+1][N+1];
		for(int i=1; i<=N; i++) {
			nums[i]  = Integer.parseInt(st.nextToken());
		}
		
		isPalindrome(); // 각 구간 별 팰린드롬 여부 판별
			
		int M = Integer.parseInt(br.readLine()); // 홍준이가 한 질문의 개수
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			
			if(dp[S][E]) { // 팰린드롬이라면
				sb.append("1").append("\n");
			}
			else {
				sb.append("0").append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}
	
	private static void isPalindrome() {
		
		// 길이가 1인 경우 - 모두 팰린드롬
		for(int i=1; i<=N; i++) {
			dp[i][i] = true;
		}
		
		// 길이가 2인 경우 - 처음,끝 한번 비교후 같으면 팰린드롬
		for(int i=1; i<N; i++) {
			if(nums[i] == nums[i+1]) {
				dp[i][i+1] = true;
			}
		}
		
		// 길이가 3이상인 경우 - 좁혀가면서 비교 (바깥쪽이 팰린드롬이려면 안쪽도 팰린드롬이어야 함)
		// 길이가 3이상인거 먼저 다 확인하고 그 다음 길이가 4인거 확인하는 방식
		for(int i=2; i<N; i++) {
			for(int j=1; j<=N-i; j++) {
				// ex) i=2, j=1이라면 nums[1]==nums[3] && nums[2]==nums[2]
				if(nums[j] == nums[j+i] && dp[j+1][j+i-1]) { 
					dp[j][j+i] = true;
				}
			}
		}
	}

}