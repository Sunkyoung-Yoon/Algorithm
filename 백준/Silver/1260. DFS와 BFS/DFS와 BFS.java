import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited; //방문 체크
	static ArrayList<Integer>[] arrayList; //그래프 표현
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //정점 수
		int M = Integer.parseInt(st.nextToken()); //간선 수
		int V = Integer.parseInt(st.nextToken()); //탐색 시작점
		
		arrayList = new ArrayList[N+1];
		visited = new boolean[N+1];
		//arrayList 초기화
		for(int i=0; i<=N; i++) {
			arrayList[i] = new ArrayList<>();
		}
		
		//그래프 간선 정보 저장
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arrayList[a].add(b);
			arrayList[b].add(a);
		}
		
		//정점 번호가 작은 것부터 방문하기 위해 오름차순 정렬
		for(int i=1; i<=N; i++) {
			Collections.sort(arrayList[i]);
		}
		
		dfs(V);
		sb.append("\n");
		
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
	}
	
	//깊이우선탐색
	public static void dfs(int now) {
		visited[now] = true;
		sb.append(now+" ");
		
		//인접한 노드 탐색
		//방문안한 노드(n)가 있다면 dfs(n)
		for(int n : arrayList[now]) {
			if(!visited[n]) {
				dfs(n);
			}
		}
	}
	
	//너비우선탐색
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);
		
		//큐가 빌 때까지 탐색
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now+" ");
			
			//인접한 노드 탐색
			//방문하지 않은 노드 큐에 삽입
			for(int n : arrayList[now]) {
				if(!visited[n]) {
					queue.add(n);
					visited[n] = true;
				}
			}
		}
		
	}
}