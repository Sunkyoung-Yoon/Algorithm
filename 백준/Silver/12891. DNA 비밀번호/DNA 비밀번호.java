import java.util.*;
import java.io.*;

public class Main {
	static int[] result;
	static int[] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		check = new int[4]; // {‘A’, ‘C’, ‘G’, ‘T’} 등장해야 하는 횟수
		int count = 0; // 비밀번호의 종류 개수
		
		String str = br.readLine(); //임의로 만든 DNA문자열
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		//처음 부분문자열 등장횟수 저장
		result = new int[4];
		for(int i=0; i<P; i++) {
			char ch = str.charAt(i);
			plus(ch);
		}
		
		int start = 0;
		for(int i=P; i<=S; i++) {
			if(check[0]<=result[0] && check[1]<=result[1] &&
					check[2]<=result[2] && check[3]<=result[3]) {
				count++;
			}
			if(i == S) break;
			
			plus(str.charAt(i));
			minus(str.charAt(start));
			start++;
		}
		
		System.out.println(count);
	}
	
	static void plus(char ch) {
		switch(ch) {
		case 'A':
			result[0]++;
			break;
		case 'C':
			result[1]++;
			break;
		case 'G':
			result[2]++;
			break;
		case 'T':
			result[3]++;
			break;
		default:
			break;
		}
	}
	
	static void minus(char ch) {
		switch(ch) {
		case 'A':
			result[0]--;
			break;
		case 'C':
			result[1]--;
			break;
		case 'G':
			result[2]--;
			break;
		case 'T':
			result[3]--;
			break;
		default:
			break;
		}
	}
}