import java.io.*;
import java.util.*;

public class Main {
	static String str;
	static boolean[] select;
	static boolean[] bracketSelect;
	static List<bracket> bracketList = new ArrayList<>(); // 괄호쌍의 인덱스 저장
	static StringBuilder sb = new StringBuilder();
	static List<String> result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine(); // 원본 수식
		
		// 괄호 쌍 인덱스 저장
		List<Integer> leftList = new ArrayList<>();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '(') {
				leftList.add(i);
				
			}
			// 짝을 찾았으니 괄호리스트에 넣고 왼쪽리스트에서 짝 찾은 애 제거
			else if(ch == ')') {
				bracketList.add(new bracket(leftList.get(leftList.size()-1), i));
				leftList.remove(leftList.size()-1);
			}
		}
		
		
		select = new boolean[str.length()];
		
		reset();
		
		bracketSelect = new boolean[bracketList.size()];
		result = new ArrayList<>();
		comb(0, 0);
		
		Collections.sort(result); // 사전순 정렬
		
		// 사전순 1번 저장
		sb.append(result.get(0)).append("\n");
		String pre = result.get(0);
		
		// 중복된 경우는 sb에 저장x
		for(int i=1; i<result.size(); i++) {
			if(pre.equals(result.get(i))) {
				continue;
			}
			
			sb.append(result.get(i)).append("\n");
			pre = result.get(i);
		}
		
		System.out.println(sb);
	}
	
	// 중복없이 순서의미없이 선택
	static void comb(int idx, int cnt) {
		// 괄호리스트를 모두 탐색했다면
		if(idx == bracketList.size()) {
			
			// 괄호 모두 선택 경우는 제외
			if(cnt == bracketList.size()) {
				return;
			}
				
			// 선택된 괄호쌍 true 처리
			for(int i=0; i<bracketList.size(); i++) {
				if(bracketSelect[i]) {
					bracket b = bracketList.get(i);
					select[b.l] = true;
					select[b.r] = true;
				}
			}
			
			
			// 괄호쌍 선택완료 문자열 sb에 저장
			StringBuilder stringB = new StringBuilder();
			for(int i=0; i<select.length; i++) {
				if(select[i]) {
					stringB.append(str.charAt(i));
				}
			}
			
			result.add(stringB.toString());
			
			
			reset();
			return;
		}
		
		bracketSelect[idx] = true;
		comb(idx+1, cnt+1);
		bracketSelect[idx] = false;
		comb(idx+1, cnt);
	}
	
	
	// select 배열 다시 체크를 위한 상태로 초기화
	static void reset() {
		Arrays.fill(select, false);
		
		// 원본문자열에서 '('와 ')'제외 인덱스도 true처리해주기
		for (int i = 0; i < select.length; i++) {
			char ch = str.charAt(i);
			if (ch != '(' && ch != ')') {
				select[i] = true;
			}
		}
	}
	
	static class bracket{
		int l; // 괄호 왼쪽 인덱스
		int r;
		
		public bracket(int l, int r) {
			this.l = l;
			this.r = r;
		}
	}
	
	static void print() {
		for(int i=0; i<str.length(); i++) {
			if(select[i])
				System.out.print(str.charAt(i));
		}
		System.out.println();
		System.out.println();
	}
}