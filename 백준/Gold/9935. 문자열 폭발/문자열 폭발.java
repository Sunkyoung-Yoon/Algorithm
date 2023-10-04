import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine(); // 문자열
		String bomb = br.readLine(); // 폭발 문자열
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			stack.add(str.charAt(i));
			
			// 스택에 들어간 글자사 bomb길이 이상이 되면 폭발문자열 검사
			if(stack.size() >= bomb.length()) {
				
				// bomb과 일치하는 문자열이 있는지 검사
				boolean flag = true;
				for(int j=0; j<bomb.length(); j++) {
					// 뒤에서부터 비교
					if(stack.get(stack.size()-1-j) != bomb.charAt(bomb.length()-1-j)) {
						flag = false;
						break;
					}
				
				}
				
				// 폭발 문자열이 있다면 그 문자열 스택에서 제거
				if(flag) {
					for(int j=0; j<bomb.length(); j++) {
						stack.pop();
					}
				}
				
			}
		}
		
		// 완료 문자열 sb에 저장
		int size = stack.size();
		for(int i=0; i<size; i++) {
			sb.append(stack.pop());
		}
		
		if(sb.length() == 0) System.out.println("FRULA");
		else System.out.println(sb.reverse().toString());
	}

}