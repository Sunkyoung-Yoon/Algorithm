import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		
		//행렬 A 2차원배열에 저장
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//행렬 B 2차원배열에 저장
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				B[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//더한 행렬
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append((A[i][j]+B[i][j])+" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}
}