import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		// 미로 저장
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s.substring(j,j+1));
			}
		}
		
		bfs(0,0); // 0,0시작 N-1,M-1도착
		System.out.println(map[N-1][M-1]);
	}
	
	static int[]di = {-1,1,0,0}; // 상하좌우
	static int[]dj = {0,0,-1,1};
	static void bfs(int start_x, int start_y) {
		Queue<int[]> queue = new LinkedList<>();
		visited[start_x][start_y] = true;
		queue.add(new int[] {start_x, start_y});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int now_x = now[0];
			int now_y = now[1];
			
			for(int d=0; d<4; d++) {
				int nextx = now_x + di[d];
				int nexty = now_y + dj[d];
				
				//이동 가능한 좌표인지 체크
				if(nextx>=0 && nexty>=0 && nextx<N && nexty<M) {
					if(map[nextx][nexty]==1 && !visited[nextx][nexty]) {
						visited[nextx][nexty] = true;
						count++;
						queue.add(new int[] {nextx, nexty});
						
						// 이동 전 좌표의 값 +1을 값으로 저장
						map[nextx][nexty] = map[now_x][now_y]+1;
					}
				}
			}
		}
	}
}