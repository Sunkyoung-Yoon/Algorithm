import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] arrayList; //친구관계를 인접리스트로 표현
	static boolean[] visited; //방문체크(관계 연결되어 있는지 체크)
	static int depth = 0; //깊이(관계)
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); //사람의 수
		int M = Integer.parseInt(st.nextToken()); //친구 관계의 수
		int result = 0;
		
		arrayList = new ArrayList[N];
		visited = new boolean[N];
		
		//인접리스트 ArrayList 초기화
		for(int i=0; i<N; i++) {
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
		
		for(int i=0; i<N; i++) {
			//dfs 시작 - 연결된 노드 방문
			dfs(i,1);
			
			//관계의 깊이 5라면
			if(depth==5) {
				result=1;
				break;
			}
		}
		System.out.println(result);
		
	}
	
	//dfs - 깊이가 5가 되는지 체크 (=문제에 제시된 관계 존재)
	public static void dfs(int now, int d) {
		
		if(d==5) {
			depth=5;
			return;
		}
	
		//방문체크
		visited[now] = true;
		
		//노드 탐색
		for(int i : arrayList[now]) {
			//인접한 노드 중 연결된 노드가 있다면
			//깊이 더하고 다음 노드로
			if(!visited[i]) dfs(i,d+1);
		}
		
		//d가 5가 안되었다면 다시 깊이 체크하기 위해 방문한 정점들 다 false로 변경
		visited[now] = false;
	}
}
