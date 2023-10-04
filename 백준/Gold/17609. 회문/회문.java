import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 문자열의 개수
		String[] s = new String[T]; // 문자열들을 저장할 배열
		int[] result = new int[T]; // 결과를 저장할 배열  0:회문, 1:유사회문, 2:모두해당x 
		
		// 문자열 저장
		for(int i=0; i<T; i++) {
			s[i] = br.readLine();
		}
		Arrays.fill(result, -1);
		
		// 문자열 검사
		for (int i = 0; i < T; i++) {

			// 문자 하나 제거없이 회문이라면 0 그대로
			if (check(s[i])) {
				result[i] = 0;
				continue;
			}
			
			int left = 0;
			int right = s[i].length()-1;
			while(left < right) {
				// 다른 글자가 나왔을 때
				if(s[i].charAt(left) != s[i].charAt(right)) {
					// 왼, 오 각각 한 글자씩 제거한 문자열 
					String leftStr = s[i].substring(left+1, right+1); // left+1 ~ right
					String rightStr = s[i].substring(left, right); // left ~ right-1
					
					// 둘 중 하나가 가능하면 유사회문
					if(check(leftStr) || check(rightStr)) {
						result[i] = 1;
					}
					break;
				}
				
				left++;
				right--;
				
			}
			
			// 해당 사항 없다면 -1 그대로
			if(result[i] == -1) result[i] = 2;
		}
		
		for(int i=0; i<T; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	// 회문 검사
	static boolean check(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s);

		// s와 뒤집은 s가 일치한다면 회문
		if (s.equals(sb.reverse().toString())) {
			return true;
		} else {
			return false;
		}
	}
}