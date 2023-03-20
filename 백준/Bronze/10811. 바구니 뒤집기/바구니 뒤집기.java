import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] basket = new int[N+1]; //바구니
		int[] temp = new int[N+1];
		for(int i=1; i<=N; i++) {
			basket[i] = i;
		}
		
		for(int n=0; n<M; n++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			//basket 공 바꿨을 때, 공번호 temp에 저장
			int idx = j;
			for(int k=i; k<=j; k++) {
				temp[k] = basket[idx--];
			}
			//바꾼 공번호 basket 저장
			for(int k=i; k<=j; k++) {
				basket[k] = temp[k]; 
			}
		}
		
		//바구니에 든 공 출력
		for(int i=1; i<=N; i++) {
			System.out.print(basket[i]+" ");
		}
	}
}