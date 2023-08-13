import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] arrayList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수
		arrayList = new ArrayList[N+1];
		visited = new boolean[N+1];
		int count = 0; // 연결 요소의 개수
		
		// 인접리스트 초기화 - 연결 정점의 번호가 1부터라 1로 시작
		for(int i=1; i<=N; i++) {
			arrayList[i] = new ArrayList<>();
		}
				
		// 간선 정보 저장
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			// 무방향 그래프 -> 양방향으로 저장
			arrayList[u].add(v);
			arrayList[v].add(u);
		}
		
		for(int i=1; i<=N; i++) {
			// 아직 방문하지 않은 새로운 노드 발견시 탐색
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	static void dfs(int now) {
		visited[now] = true;
		
		// 인접한 노드 탐색
		for(int n: arrayList[now]) {
			if(!visited[n])
				dfs(n);
		}
	}

}