import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] check = new boolean[N+1];
		
		
		//M이 1인경우도 있으므로 소수가 아닌수라는 의미로 true로 변경
		check[1] = true;
		
		//소수가 아닌 수 true
		for(int i=2; i<=Math.sqrt(N); i++) {
			for(int j=i*i; j<=N; j+=i) {
				//이미 소수가 아니라고 판별된 수는 continue
				if(check[j]) continue;
				
				check[j] = true;
			}
		}
		
		
		//소수 한줄에 하나씩 출력
		for(int i=M; i<=N; i++) {
			if(!check[i]) {
				System.out.println(i);
			}
		}
		
	}	
}