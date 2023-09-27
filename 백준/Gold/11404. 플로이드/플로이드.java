import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 도시의 개수
		int m = Integer.parseInt(br.readLine()); // 버스의 개수
		int[][] dp =new int[n+1][n+1]; // 도시번호는 1부터
		
		// 버스 정보 저장
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); // 시작 도시 번호
			int end = Integer.parseInt(st.nextToken()); // 도착 도시 번호
			int weight = Integer.parseInt(st.nextToken()); // 이동 비용
			
			if(dp[start][end] != 0) {
				dp[start][end] = Math.min(dp[start][end], weight);
			}
			else {
				dp[start][end] = weight;
			}
		}
		
		// 못 가는 경우 100000*100+1로 세팅 - 최대 가능한 경우가 100000 * 100 이기 때문에 불가능하다는 의미로
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i == j) continue; // 자기자신은 0으로
				
				if(dp[i][j] == 0) { // 못가는 경우 
					dp[i][j] = 100000*100+1; // 최대 비용+1로 초기화
				}
			}
		}		
		
		// 최단 경로 저장
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				if(k == i) continue; // 중간 다리를 k로 정한 것이기 때문에 i와 같다면 그건 패스
				for(int j=1; j<=n; j++) {
					if(k == j || i == j) continue; // i == j인 경우-> 자기자신으로 가는 경우는 없기에 이것도 패스
					
					// 중간 다리가 있는 경로와 아닌 경로 중 최솟값을 저장
					dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);					
				}
			}
		}
		
		
		// 100000*100+1이 남아있는 경우 못 간다는 의미로 0으로 다시 수정해주기
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(dp[i][j] == (100000*100+1))
					dp[i][j] = 0;
			}
		}
		
		
		print(dp); // 결과 출력
	}

	
	static void print(int[][] dp) {
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp.length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}