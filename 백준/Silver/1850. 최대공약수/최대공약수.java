import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		StringBuffer sb = new StringBuffer();
		long result = GCD(A,B);
		for(int i=0; i<result; i++) {
			sb.append("1");
		}
		
		System.out.println(sb);
	}
	
	//최대공약수
	public static long GCD(long a, long b) {
		if(a%b==0)
			return b;
		else
			return GCD(b,a%b);
	}
		
}