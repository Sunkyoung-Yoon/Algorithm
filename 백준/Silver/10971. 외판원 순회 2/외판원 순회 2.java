import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int[][] minCost; // 도시 i에서 j로 가는 최소 비용
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시의 수
		
		// 지도 저장
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		minCost = new int[N][N];
		visited = new boolean[N];
		
		// 시작점이 안 정해졌으므로 시작점에 따라 탐색 새로 하기
		for(int i=0; i<N; i++) {
			visited[i] = true;
			dfs(0,i,1,0);
		}
		
		System.out.println(min);
	}
	
	
	// 도시 start ~ now로 가는 방법(비용) 탐색
	// 모든 도시를 다 거쳐야 한다.
	static void dfs(int start, int now, int cnt, int cost) {
		// 모든 도시를 다 거쳤다면
		if(cnt == N) {
			//다시 처음으로 돌아갈 수 있는 경우만 계산
			if(map[now][start]!=0) {
				// 다시 처음 도시로 돌아와야 하기 때문에 now에서start로 가는 비용 더하기
				cost += map[now][start];
				min = Math.min(min, cost);
			}
			
			return;
		}
		
		// 인접한 도시 탐색
		for(int i=0; i<N; i++) {
			// 이미 방문했거나 
			// 비용이 0(갈 수 없다면) 패스
			if(visited[i] || map[now][i]==0) continue; 
			
			visited[i] = true;
			dfs(start, i, cnt+1, cost+map[now][i]);
			visited[i] = false;
		}
	}
}