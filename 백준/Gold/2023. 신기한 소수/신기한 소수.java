import java.io.*;
import java.util.*;

public class Main {
	//소수인 N자리 숫자나올 때마다 sb에 저장
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine()); //자릿수
		
		//숫자의 맨 앞 자리는 소수여야 함 -> 2,3,5,7만 가능
		dfs(2, N);
		dfs(3, N);
		dfs(5, N);
		dfs(7, N);
		
		System.out.println(sb);
		
	}
	
	
	public static void dfs(int num, int n) {
		//숫자의 자릿수가 N이 된다면
		if(n==1) {
			sb.append(num+"\n");
			return;
		}
		
		//0~9자리숫자 1,3,7,9중에 하나 붙여서 num으로 만든다.
		//마지막 자리가 짝수인 경우 소수가 아님
		for(int i=1; i<10; i+=2) {
			if(i==5) continue;
			
			//소수라면 다음숫자 붙이기
			if(isPrime(num*10+i)){
				dfs(num*10+i,n-1);
			}
		}
	}
	
	
	//소수판별
	public static boolean isPrime(int num) {
		for(int i=2; i<=Math.sqrt(num); i++) {
			//1과 자기자신이 아닌 다른 수로 나눠진다면 소수가 아님
			if(num%i==0) return false;
		}
		return true;
	}
}
