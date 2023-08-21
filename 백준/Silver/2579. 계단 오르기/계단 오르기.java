import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		int[] score = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		score[1] = arr[1]; 
		if(N>=2)
			score[2] = arr[1]+arr[2];
		if(N>=3)
			score[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]);
		
		if(N >=4) {
			// 예를 들어 N이 4라면 연속 3번은 안되기 때문에
			// 1,3,4 또는 2,4만 가능 -> N-3,N-1,N 또는 N-2,N 
			for(int i=4; i<=N; i++) {
				// 2칸+1칸 또는 2칸씩
				score[i] = Math.max(score[i-3]+arr[i-1]+arr[i], score[i-2]+arr[i]);
			}
		}
			
		System.out.println(score[N]);
	}
	
}