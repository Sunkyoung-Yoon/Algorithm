import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int w, h;
	static int count;
	static int[] di = {-1,1,0,0,-1,-1,1,1}; //상하좌우 대각선4방향
	static int[] dj = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			// 0 0 입력받으면 while문 종료
			if(w==0 && h==0) break;
				
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			count = 0;
			visited = new boolean[h][w];
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					// 섬이고 방문하지 않았다면
					if(map[i][j]==1 && !visited[i][j]) {
						count++;
						dfs(i,j);
					}
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static void dfs(int nowi, int nowj) {
		visited[nowi][nowj]=true;
		
		// 상하좌우 대각선 모두 이동가능한지 체크
		for(int d=0; d<8; d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			// 지도내에 있고 섬이면서 방문하지 않은 곳이라면
			if(nexti>=0 && nexti<h && nextj>=0 && nextj<w && 
					map[nexti][nextj]==1 && !visited[nexti][nextj]) {
				dfs(nexti, nextj);
			}
		}
	}

}