import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> str_map = new HashMap<>(); //key-포켓몬이름
		String[] str_arr = new String[N];
		
		//포켓몬이름,번호 문자열 해시맵에 저장
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			str_map.put(str, i);
			str_arr[i-1] = str; 
		}
				
		//M개의 문자열이 해시맵에 존재하는지 확인
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			
			if(isInteger(str)) { //숫자라면
				int num = Integer.parseInt(str);
				sb.append(str_arr[num-1]).append("\n");
			}
			else { //문자열이라면
				sb.append(str_map.get(str)).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
	//입력받은 str이 숫자인지 판별
	public static boolean isInteger(String str) {
		try { //숫자라면 true 리턴
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e){ //숫자가 아니라면 false 리턴
			return false;
		}
	}

}