import java.util.*;
import java.io.*;

public class Main {
	static int V, E;
	static LinkedList<int[]>[] graph; // 방향 그래프라 방문배열  사용x
	static int[] answer; // 각 정점별 최소비용
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호
		
		graph = new LinkedList[V+1]; // 정점 번호 1~V
		for(int i=1; i<=V; i++) {
			graph[i] = new LinkedList<>();
		}
		
		// 간선 정보 저장
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); //u->v 가중치 w
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new int[] {v, w});
		}
		
		answer = new int[V+1];
		Arrays.fill(answer, Integer.MAX_VALUE); // int형 최댓값으로 초기화
		answer[K] = 0; //시작점 자신은 비용이 0
		bfs(K, 0); //K를 시작점으로 탐색
		
		for(int i=1; i<=V; i++) {
			// Integer.MAX_VALUE라면 K에서 갈 수 없는 정점
			if(answer[i]==Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(answer[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int start, int cost) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]-o2[1]>0) //가중치가 작은 쪽이 앞으로 가도록 정렬기준 작성
					return 1;
				else 
					return -1;
			}
		});
		queue.add(new int[] {start, 0});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			// 최소 비용을 이미 넘는 경우는 탐색x
			if(now[1] > answer[now[0]]) continue;
			
			for(int[] n : graph[now[0]]) { // 인접한 정점 조회
				int result_cost = now[1] + n[1];
				if(answer[n[0]] > result_cost) { //n까지 가는 최소 비용 저장
					answer[n[0]] = result_cost; // 최소 비용 업데이트
					queue.add(new int[] {n[0], result_cost}); // 정점과 바뀐 가중치를 큐에 삽입
				}
				
			}
		}
	}
}