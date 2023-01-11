import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		int[] S = new int[N+1]; //구간합을 저장할 배열
		
		st = new StringTokenizer(br.readLine());
		//구간 합 배열 S에 저장
		for(int i=1; i<=N; i++) {
			S[i] = S[i-1]+Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//ex) (1,3)구간은 S[3]-S[0]과 같음
			sb.append(S[b]-S[a-1]).append("\n");
		}
		
		System.out.println(sb);
		
	}
}