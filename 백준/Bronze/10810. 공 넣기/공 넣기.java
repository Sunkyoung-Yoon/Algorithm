import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] basket = new int[N]; //바구니
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			//바구니에 공넣기
			for(int j=s-1; j<t; j++) {
				basket[j] = n;
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(basket[i]+" ");
		}
	}
}