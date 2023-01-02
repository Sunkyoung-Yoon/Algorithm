import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fibonacci(N));
		
	}
	//n번째 피보나치 구하는 함수
	public static int fibonacci(int n) {
		//재귀 호출 종료 
		if(n==0) 
			return 0;
		if(n==1) 
			return 1;
		
		return fibonacci(n-1)+fibonacci(n-2);
	
	}
}