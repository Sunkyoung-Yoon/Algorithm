import java.io.*;

public class Main {
	static int count = 0; //함수 호출횟수 저장할 변수
	
	//팰린드롬 확인함수 호출
	public static int isPalindrome(String s) {
			return recursion(s, 0, s.length()-1);
	}
	//팰린드롬 여부 확인함수	
	public static int recursion(String s, int l, int r) {
		count++;
		if(l>=r) return 1;
		else if(s.charAt(l)!=s.charAt(r)) return 0;
		else return recursion(s,l+1,r-1); 
	}
		
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			count=0;
			sb.append(isPalindrome(br.readLine())+" "+count).append("\n");
		}
		System.out.print(sb);
		
	}	
}