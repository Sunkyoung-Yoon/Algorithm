import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] D = new int[N+1][N+1]; //합을 저장할 배열
		
		
		//배열 S에 합 저장
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int num = Integer.parseInt(st.nextToken());
				D[i][j] = D[i-1][j]+D[i][j-1]-D[i-1][j-1]+num;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			//ex) (1,2) (3,4)까지의 합 -> (3,4)-(0,3)-(1,4)+(0,1)
			sb.append(D[x2][y2]-D[x1-1][y2]-D[x2][y1-1]+D[x1-1][y1-1]).append("\n");
		}
		
		System.out.println(sb);
		
	}
}