import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		
		for(int i=0; i<K; i++) {
			int n = Integer.parseInt(br.readLine());
			
			//0 입력시 가장 최근에 입력된 값 제거
			if(n==0) {
				sum -= stack.pop();
				continue;
			}
			stack.push(n);
			sum += n;
		}
		
		System.out.println(sum);
	}
}