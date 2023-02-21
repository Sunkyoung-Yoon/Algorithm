import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); //가치의 합
		int count = 0; //동전 개수
		
		int[] A = new int[N]; //동전의 가치
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		//큰 수부터 K를 나눠서 K가 0이 될 때까지 반복
		for(int i=N-1; i>=0; i--) {
			//동전가치가 K보다 큰 경우에는 K원을 만드는데 쓰일 수 없음
			if(K<A[i]) continue;
			
			//K를 A[i]로 나눈 몫 count에 더함
			count += K/A[i];
			//K를 A[i]로 나눈 나머지 K에 저장
			K = K%A[i];
			
		}
		
		System.out.println(count);
	}
}