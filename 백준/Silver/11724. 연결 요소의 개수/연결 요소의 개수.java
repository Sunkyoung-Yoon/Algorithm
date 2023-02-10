import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] arrayList; //그래프를 표현할 인접리스트
	static boolean[] visited; //방문체크할 배열
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//정점(노드)의 개수
		int N = Integer.parseInt(st.nextToken());
		//간선의 개수
		int M = Integer.parseInt(st.nextToken());
		int count = 0; //연결 요소의 개수
		arrayList = new ArrayList[N+1]; //정점은 1부터 시작하므로 N+1크기로 생성
		visited = new boolean[N+1];
		
		
		//인접리스트의 ArrayList 각각 생성 및 초기화
		for(int i=0; i<N+1; i++) {
			arrayList[i] = new ArrayList<Integer>(); 
		}
		
		
		//간선 정보(연결된 정점 정보) 저장
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//양방향으로 연결되어 있으므로 노드 양쪽 모두 저장
			arrayList[u].add(v);
			arrayList[v].add(u);
		}
		
		//노드는 1번부터 시작
		for(int i=1; i<=N; i++) {
			//방문하지않은 노드라면 dfs 시작 - 연결된 노드들을 방문
			//방문하지않은 노드라면 연결 요소의 개수 증가
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static void dfs(int now) {
		visited[now] = true; //방문표시
		
		//인접한 노드 개수만큼 반복
		for(int n : arrayList[now]) {
			//방문하지 않은 인접노드 중에 방문
			if(!visited[n]) {
				dfs(n);
			}
		}
	}
}
