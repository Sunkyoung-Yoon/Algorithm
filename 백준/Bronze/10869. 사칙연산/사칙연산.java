import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		System.out.println(A+B); //덧셈
		System.out.println(A-B); //뺄셈
		System.out.println(A*B); //곱셈
		System.out.println(A/B); //몫
		System.out.println(A%B); //나머지
	}
}
