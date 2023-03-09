import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			sb.append(A*B/GCD(A,B)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	//최대공약수
	public static int GCD(int a, int b) {
		if(a%b==0)
			return b;
		else
			return GCD(b,a%b);
	}
}