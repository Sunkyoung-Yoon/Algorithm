import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>(); //듣도 못한 사람
		ArrayList<String> list = new ArrayList<>(); //듣도 보도 못한 사람
		
		
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 0);
		}
		
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			if(map.get(s)!=null) { //map에 있는 사람이면
				list.add(s);
			}
		}
		
		//사전순 출력을 위해 오름차순 정렬
		Collections.sort(list);
		
		sb.append(list.size()).append("\n");
		for(String s : list) { //리스트 전체 순회
			sb.append(s).append("\n");
		}
		
		System.out.println(sb);
		
	}
}