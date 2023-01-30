import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine()); //수열의 개수
		Stack<Integer> stack = new Stack<>();
		int count = 1; //가장 마지막에 push한 값
		
		for(int i=0; i<n; i++) { 
			//입력받은 수열 값
			int num = Integer.parseInt(br.readLine());
			
			//count<=num일 때는 스택 top위치 값이 num이 될 때까지
			while(count<=num) {
				stack.push(count);
				sb.append("+\n");
				count++;
			}
			
			
			//count>num일 때,
			//top위치에 num이라면 pop()
			if(stack.peek()==num) {
				stack.pop();
				sb.append("-\n");
			}
			//top위치에 num이 아니라면
			//pop()하는 값이 num이 될 수 없음 (LIFO으로 입력받은 수열 표현 불가)
			else {
				sb.delete(0, sb.length()); //이전에 입력한 문자열 제거
				sb.append("NO");
				break;
			}
		}
		
		System.out.println(sb);
		
	}
}
