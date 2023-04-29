import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		char[][] ch = new char[5][15];
		
		int max = 0; //가장 긴 글자 길이
		for(int i=0; i<5; i++) {
			String word = br.readLine();
			max = Math.max(max, word.length());
			
			for(int j=0; j<word.length(); j++) {
				ch[i][j] = word.charAt(j);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		//세로 글자 읽기
		for(int i=0; i<max; i++) {
			for(int j=0; j<5; j++) {
				if(ch[j][i]=='\0') continue;
				sb.append(ch[j][i]);
			}
		}
		
		System.out.println(sb);
	}
}