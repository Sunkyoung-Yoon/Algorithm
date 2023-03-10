import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int result = GCD(A,B);
		
		System.out.println(result);
		//최소공배수
		System.out.println(A*B/result);
	}
	
	//최대공약수
	public static int GCD(int a, int b) {
		if(a%b==0)
			return b;
		else
			return GCD(b,a%b);
	}
		
}