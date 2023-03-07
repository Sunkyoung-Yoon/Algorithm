import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		//10^7+1 크기의 배열 생성
		boolean[] check = new boolean[10000001];
		
		//소수가 아닌수 true로 변경
		check[0]=check[1]=true;
		for(int i=2; i<=Math.sqrt(check.length-1); i++) {
			//이미 소수가 아니라고 판별된 수는 continue
			if(check[i]) continue;
			
			for(int j=i*i; j<=check.length-1; j+=i) {
				check[j] = true;
			}
		}
		
		
		int count = 0;
		//check배열을 탐색하며 범위내에 거의 소수 개수 확인
		for(int i=2; i<=check.length-1; i++) {
			
			if(check[i]) continue;
			
			long result = i;
			
			//N제곱한 결과가 result*i <= B인 동안 반복
			while(result <= B/i) {
				//N제곱
				result*=i;
				
				//A <= result <=B라면 거의 소수 존재 count증가
				if(result>=A) count++;
				
			}
		}	
		
		System.out.println(count);
	}	
}