import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		
		// 상근이가 가지고 있는 카드 map <카드, 개수>
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0)+1);
		}
		
		// 개수를 구해야할  카드
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			// 상근이가 가지고 있다면 개수 저장, 없다면 0 저장
			if(map.containsKey(key)) {
				sb.append(map.get(key)+" ");
			}
			else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb);
	}
}