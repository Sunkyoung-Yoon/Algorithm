import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		int[] num = new int[N.length()];
        //입력받은 숫자 자리수별로 저장
		for(int i=0; i<N.length(); i++) {
			num[i]=N.charAt(i)-'0';
		}
		
		Arrays.sort(num); //오름차순 정렬
		
		//뒤에서부터 sb에 저장 내림차순
		for(int i=0; i<N.length(); i++) {
			sb.append(num[N.length()-1-i]);
		}
		
		System.out.print(sb);
		
	}
}