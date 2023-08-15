import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1};
	static int N;
	static int M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			// 밭 정보 저장
			map = new int[M][N];
			visited = new boolean[M][N];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				map[X][Y]++;
			}
		
			
			int count = 0; //지렁이의 개수
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]!=0 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int nowi, int nowj) {
		visited[nowi][nowj] = true;
		
		for(int d=0; d<4; d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			// 밭 범위 내이면서 배추있는 곳이라면
			if(nexti>=0 && nexti<M && nextj>=0 && nextj<N
					&& map[nexti][nextj]==1 && !visited[nexti][nextj]) {
				dfs(nexti, nextj);
			}
		}
	}

}