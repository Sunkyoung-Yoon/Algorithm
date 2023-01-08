import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		//상근이가 가지고 있는 숫자 카드
		HashMap<Integer, Integer> map = new HashMap<>(); 
		
		
		//카드 숫자,개수 해시맵에 저장
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.get(num)==null) {
				map.put(num, 1);
			}
			else {
				int count = map.get(num);
				map.put(num, ++count);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.get(num)==null)
				sb.append(0+" ");
			else
				sb.append(map.get(num)+" ");
		}
		System.out.println(sb);
		
	}
}