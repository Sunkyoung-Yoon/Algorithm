import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dj = {-2, -1, 1, 2, -2, -1, 1, 2};
	static int endi, endj;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		
		for(int tc=0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
			map = new int[N][N];
			
			st = new StringTokenizer(br.readLine());
			int starti = Integer.parseInt(st.nextToken());
			int startj = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			endi = Integer.parseInt(st.nextToken());
			endj = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N][N];
			bfs(starti, startj);
			
			sb.append(map[endi][endj]).append("\n"); // 최소 이동 칸 수 저장
			
		} // 테스트 케이스 종료
		
		System.out.println(sb);
	}
	
	// 너비우선탐색
	static void bfs(int starti, int startj) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {starti, startj});
		visited[starti][startj] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			// 나이트가 원하는 위치에 도달했다면 더이상 탐색필요x -> 종료
			if(now[0]==endi && now[1]==endj) break;
			
			for(int d=0; d<8; d++) {
				int nexti = now[0]+di[d];
				int nextj = now[1]+dj[d];
				
				// 체스판 위에 있고 방문하지 않은 곳이라면
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<N &&
						!visited[nexti][nextj]) {
					queue.add(new int[] {nexti, nextj});
					visited[nexti][nextj] = true;
					// 새로 큐에 넣을 때 이전 위치 값 +1을 값으로 저장
					map[nexti][nextj] = (map[now[0]][now[1]]+1); 
				}
			}
		}
	}
	
}