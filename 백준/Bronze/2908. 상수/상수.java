import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//공백을 기준으로 토큰 구분하여 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		num1 = num1%10*100 + (num1%100)/10*10 + num1/100;
		num2 = num2%10*100 + (num2%100)/10*10 + num2/100;
		
		System.out.println(Math.max(num1, num2));
		
		
	}
	
}