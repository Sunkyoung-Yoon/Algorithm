import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>(); //N개의 문자열로 이루어진 집합S
		int count = 0; //집합S에 포함된 문자열 개수
		
		//집합S 문자열 해시맵에 저장
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 0);
		}
		
		//M개의 문자열이 해시맵에 존재하는지 확인
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			//set에 key값이 str인 문자열이 존재한다면 -> value값은 null이 아님 
			if(map.get(str)!=null)
				count++;
		}
		
		System.out.println(count);	
	}
}