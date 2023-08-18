import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static int[][] maze; //미로 저장
	static boolean[][] visited; //방문체크
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M]; //미로 초기화
		// 미로 저장
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = s.charAt(j)-'0';
			}
		}
		
		visited = new boolean[N][M]; //방문체크배열 초기화
		bfs(0,0);
		
		System.out.println(maze[N-1][M-1]);
	}
	
	static void bfs(int starti, int startj) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {starti, startj});
		visited[starti][startj] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nexti = now[0]+di[d];
				int nextj = now[1]+dj[d];
				
				// 미로내 범위이고 방문하지 않은 곳이면서 1이라면
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<M &&
						!visited[nexti][nextj] && maze[nexti][nextj]==1) {
					queue.add(new int[] {nexti, nextj});
					visited[nexti][nextj] = true;
					maze[nexti][nextj] += maze[now[0]][now[1]]; // 이동시간을 더해가면서 이동
				}
			}
		}
	}
}