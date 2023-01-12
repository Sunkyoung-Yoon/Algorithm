import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap<>(); //A 집합
		int result = 0;
		
		//A 집합
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, 0);
		}
		
		int count1 = 0; //A교집합B의 개수
		int count2 = 0; //B-A 차집합 원소의 개수
		
		//B집합 A집합 비교
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.get(num)==null) // B-A
				count2++;
			else //A교집합B
				count1++;
				
		}
		
		result = map.size()-count1 + count2;
		System.out.println(result);
		
	}
}