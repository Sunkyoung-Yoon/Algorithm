import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//대소문자로 이루어진 문자열 ->대문자로 변경
		String s = br.readLine().toUpperCase(); 
		
		int[] count = new int[26];
		
		for(int i=0; i<s.length(); i++) { //문자에 해당하는 순서에 저장
			count[s.charAt(i)-65]++;
		}
		
		int max=0; 
		char c = '?'; 
		
		for(int i=0; i<26; i++) {
			if(max<count[i]) { //등장횟수가 더 큰 문자 등장
				max=count[i];
				c = (char)(i+65); //대문자출력
			}
			else if(max==count[i]){ //최대 등장횟수가 동일한 다른 문자존재
				c='?';
			}
		}
		System.out.println(c);
		
	}
	
}



 
