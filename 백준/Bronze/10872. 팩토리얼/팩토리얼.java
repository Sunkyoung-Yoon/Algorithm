import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		
		System.out.print(factorial(N));
		
	}
	//N!구하는 함수
	public static int factorial(int n) {
		if(n<=1) //재귀 호출 종료
			return 1;
		return n*factorial(n-1);
	
	}
}