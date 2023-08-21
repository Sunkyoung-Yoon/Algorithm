import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static LinkedList<int[]>[] list;
	static boolean[] visited;
	static int[] answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());// 도시의 개수
		M = Integer.parseInt(br.readLine());// 버스의 개수
		
		list = new LinkedList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new LinkedList<>();
		}
		
		// 도시 간 버스 비용 저장
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			list[start].add(new int[] {end, dis}); // 시작 도시-도착도시 및 비용 저장
		}
		
		st = new StringTokenizer(br.readLine());
		int startNum = Integer.parseInt(st.nextToken()); // 출발 도시번호
		int endNum = Integer.parseInt(st.nextToken()); // 도착 도시 번호
		
		answer = new int[N+1]; // 해당 도시까지 가는 비용
		Arrays.fill(answer, Integer.MAX_VALUE);
		visited = new boolean[N+1];
		bfs(startNum,0);
		
		System.out.println(answer[endNum]);
	}
	
	
	static void bfs(int start, int cost) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 가중치 더 작은쪽을 먼저 탐색하도록 정렬 기준 설정
				if(o1[1]-o2[1] > 0)
					return 1;
				else
					return -1;
			}
		}); 
		
		queue.add(new int[] {start, cost});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			// 이미 저장한 최단거리보다 비용이 크다면 다음으로 넘어감
			if(now[1] > answer[now[0]]) continue;
			
			for(int[] s: list[now[0]]) {
				int answer_dis = now[1]+s[1]; //지금 지점까지 거리+거기서 연결된 도시까지 간 거리
				// 더 작은 비용이 들었다면 교체
				if(answer[s[0]] > answer_dis) {
					answer[s[0]] = answer_dis;
					queue.add(new int[] {s[0], answer_dis});
				}
					
			}
		}
		
	}
}