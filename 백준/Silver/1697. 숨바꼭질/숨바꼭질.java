import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] map;
	static boolean[] visited;
	static int count = 0;
	static int[] di = {-1, 1, 2}; // di[3]은 곱하기
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치
		
		map = new int[100001];
		
		// 수빈이가 동생보다 뒤에 있다면 N>K
		visited = new boolean[100001];
		bfs(N);
		
		System.out.println(map[K]);
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(now == K) break; // 동생 위치로 갔다면 더이상 탐색할 필요없음 -> 종료
			
			for(int d=0; d<3; d++) {
				int nexti = now+di[d]; // di[0], di[1] : 걷기
				
				if(d==2) nexti = now*di[2]; // di[2]: 순간이동
				
				// 수빈이 원래 위치와 같거나 크고 동생위치와 같거나 작아야 한다
				// 이미 방문한 곳은 방문하지 않는다
				if(nexti>=0 && nexti<100001 && !visited[nexti]) {
					queue.add(nexti);
					visited[nexti] = true;
					map[nexti] = map[now]+1;
				}
			}
		}
		
	}
}