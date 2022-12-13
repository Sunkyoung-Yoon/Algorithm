import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//단어의 개수
		int N = Integer.parseInt(br.readLine());
		int count=0;

		for(int i=0; i<N; i++) {
			boolean[] check = new boolean[26];//알파벳 등장여부 확인 배열
            int flag=1; //그룸단어여부 체크할 변수
            
			String str = br.readLine();
            
			//시작 문자 저장
			int pre = str.charAt(0)-'a';
			check[pre]=true; //시작문자에 해당하는 check배열 true로 변경
			
			for(int j=1; j<str.length(); j++) {
				for(int c=0; c<check.length; c++) { 
					int ch = str.charAt(j)-'a';
					if(pre==ch) { //이전 알파벳과 같은 경우 -> 연속으로 같은 알파벳
						break;
					}
					else { //이전과 다른 알파벳 등장
						//이미 등장한 알파벳
						if(check[ch]==true) {
							flag=0;
							break;
						}//새로 등장한 알파벳
						else {
							check[ch]=true;
							pre=str.charAt(j)-'a';
							break;
						}
					}
				}
			}
			if(flag==1)
				count++;
		}
		System.out.println(count);
	}	
}