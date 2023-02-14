import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<Integer>[] arrayList; //그래프를 표현할 인접리스트
	public static boolean[] visited; //방문체크할 배열
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); //정점(노드) 수
		int M = Integer.parseInt(st.nextToken()); //간선 수
		int V = Integer.parseInt(st.nextToken()); //시작 노드번호
		
		arrayList = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		//인접리스트 ArrayList 초기화
		for(int i=1; i<=N; i++) {
			arrayList[i] = new ArrayList<>();
		}
		
		//관계 양쪽으로 저장 (양쪽 다 연결되어 있으므로)
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arrayList[a].add(b);
			arrayList[b].add(a);
		}
		
		
		/*
		노드 번호가 작은 것부터 방문하기 위해 
		노드와 인접한 노드들 오름차순으로 정렬 
		*/
		for(int i=1; i<=N; i++) {
			Collections.sort(arrayList[i]);
		}
		
		dfs(V); 
		System.out.println();
		
		//다시 탐색하기 위해 방문배열 초기화
		visited = new boolean[N+1];
		bfs(V);
		
	}
	
	
	//깊이우선탐색
	public static void dfs(int now) {
		visited[now] = true; //방문표시
		
		System.out.print(now+" "); //방문한 노드 출력
		
		//현재 노드의 인접한 노드 방문체크
		for(int n : arrayList[now]) {
			//방문하지 않은 인접노드라면
			if(!visited[n]) {
				dfs(n);
			}
		}
	}
	
	
    //너비우선탐색
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true; //방문표시
		queue.add(start); //시작노드 큐에 삽입
		
		//큐가 빌 때까지
		while(!queue.isEmpty()) {
			//현재 노드 
			int now = queue.poll();
			
			System.out.print(now+" "); //현재 노드 출력
			
			//현재 노드의 인접한 노드 방문체크
			for(int n : arrayList[now]) {
				//방문하지 않은 인접노드라면
				if(!visited[n]) {
					queue.add(n); //방문하지 않은 인접노드 큐에 삽입
					visited[n] = true; //노드 방문표시
				}
			}
			
		}
	}
}
