import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		//최소공배수
		System.out.println(A*B/GCD(A,B));
	}
	
	//최대공약수
	public static long GCD(long a, long b) {
		if(a%b==0)
			return b;
		else
			return GCD(b,a%b);
	}
		
}
