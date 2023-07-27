import java.util.*;
import java.io.*;

public class Main {
	private static int L, C;
	private static char[] arr = {'a', 'e', 'i', 'o', 'u'};
	private static char[] ch;
	private static StringBuilder sb = new StringBuilder();
	private static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ch = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			ch[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(ch);
		
		for(int i=0; i<=C-L; i++) {
			dfs(i+1, 1, String.valueOf(ch[i]));
		}
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int start, int len, String s) {
		if(len == L) {
			if(check(s)) {
				sb.append(s).append("\n");
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			String word = s + ch[i];
			dfs(i+1, len+1, word);
		}
	}
	
	public static boolean check(String s) {
		count = 0;
		for(int i=0; i< arr.length; i++) {
			for(int j=0; j<s.length(); j++) {
				if(arr[i] == s.charAt(j)) count++;
			}
		}
		
		if(count >= 1 && L-count >= 2) {
			return true;
		}
			
		return false;
	}

}