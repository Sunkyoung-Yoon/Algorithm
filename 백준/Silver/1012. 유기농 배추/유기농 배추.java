import java.util.*;
import java.io.*;

public class Main {
	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스의 개수
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 밭 가로 길이
			N = Integer.parseInt(st.nextToken()); // 밭 세로 길이
			K = Integer.parseInt(st.nextToken()); // 배추심은 위치 개수
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			// 배추심은 위치 1로 변경
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[y][x] = 1;
			}
			
			
			int count = 0; // 지렁이의 개수
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					// 배추가 심어져있으면서 방문하지 않은 곳이라면 지렁이가 있어야 하는 곳
					if(map[i][j]==1 && !visited[i][j]) {
						count++;
						dfs(i,j);
					}
				}
			}
			
			sb.append(count).append("\n");
		}//테스트 케이스 종료
		
		System.out.println(sb);
	}
	
	
	static void dfs(int nowi, int nowj) {
		visited[nowi][nowj] = true;
		for(int d=0; d<4; d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			// 밭 범위 내에 있고 1이면서 방문하지 않은 곳이라면
			if(nexti>=0 && nexti<N && nextj>=0 && nextj<M &&
					map[nexti][nextj]==1 && !visited[nexti][nextj]) {
				dfs(nexti, nextj);
			}
		}
	}
}