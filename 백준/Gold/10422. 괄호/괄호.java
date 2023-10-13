import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		
		
		for(int t=0; t<T; t++) {
			int L = Integer.parseInt(br.readLine()); // 길이
			
			long[] dp = new long[2501];
			dp[0] = 1;
			dp[1] = 1;
			if(L%2==0) { // 길이가 짝수라면 괄호가 짝이 맞음
				
				if(dp[L/2]==0) { // 아직 안 구한 결과는 0, 이미구했다면 바로 sb에 저장
					for(int i=2; i<=(L/2); i++) {
						for(int j=0; j<i; j++) {
							dp[i] = (dp[i] + dp[i-j-1]*dp[j])%1000000007;
						}
					}
				}
				
				sb.append(dp[L/2]).append("\n");
			}
			else { // 길이가 홀수라면 괄호 짝이 맞지 않으므로 올바른 괄호 문자열x
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}