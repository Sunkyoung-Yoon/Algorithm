import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //카드의 개수
		int M = Integer.parseInt(st.nextToken()); //3장 카드의 합
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(blackjack(arr, N, M));
	}
	
	public static int blackjack(int[] arr, int N, int M) {
		int bestCase = 0;
		
		for(int i = 0; i<N; i++) {			
			for(int j = i+1; j<N; j++) {
				for(int k = j+1; k<N; k++) {
					
					int sum = arr[i]+arr[j]+arr[k];
					if(sum>M) //3장 카드의 합이 M보다 큰 경우 제외
						continue;
					
					//같다면 가장 최적의 경우이므로 반복문 종료
					if(sum==M) {
						bestCase=sum;
						return bestCase;
					}
					//
					bestCase = Math.max(bestCase, sum);
				}
			}
		}
		
		return bestCase;
	}
	
}