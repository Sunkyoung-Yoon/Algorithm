import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] dist = new int[N+1][N+1]; // 사용자번호 1부터
			int[] result = new int[N+1]; // 사용자별 dist의 합
			
			// 초기 인접행렬 저장
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dist[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			// 이동 불가능한 값 1000+1로 세팅
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(dist[i][j] == 0) {
						dist[i][j] = 1001;
					}
				}
			}
			
			// i에서 j까지 최단 경로 저장
			for(int k=1; k<=N; k++) { // 중간다리로 사용될 번호
				for(int i=1; i<=N; i++) {
					if(i == k) continue; // 자기 자신을 중간다리로 삼는 경우 제외
					
					for(int j=1; j<=N; j++) {
						if(j == k || i == j) continue; // 자기자신으로부터 자기자신으로 가는 경로 제외
						
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			
			// 이동 불가능한 경우 다시 0으로 세팅
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i][j] == 1001) {
						dist[i][j] = 0;
					}
				}
			}
			
			
			// 사용자별 dist합 구하기
			int minDist = Integer.MAX_VALUE;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					result[i] += dist[i][j];
				}
				
				if(minDist > result[i]) {
					minDist = result[i];
				}
			}
			
			
			
			sb.append("#"+tc+" "+minDist).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void print(int[][] tmp) {
		for(int i=1; i<tmp.length; i++) {
			for(int j=1; j<tmp.length; j++) {
				System.out.print(tmp[i][j]);
			}
			System.out.println();
			
		}
		System.out.println();
	}

}