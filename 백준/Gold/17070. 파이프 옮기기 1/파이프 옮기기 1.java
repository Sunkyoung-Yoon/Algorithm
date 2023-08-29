import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] house;
	static boolean[][] visited;
	static int[] di = {0, 1, 1}; // 오른쪽, 오른쪽대각선, 아래
	static int[] dj = {1, 1, 0};
	static int count; // (N, N)에 도달하는 방법의 수
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		// 정보 저장
		house = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N+1][N+1];
		if(house[N][N]!=1) // (N,N)이 벽일 경우는 볼 필요없이 불가능
			bfs(new Point(1,1,1,2));
		
		// 이동할 수 없는 경우에는 0 출력
		System.out.println(count);
	}
	
	static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(start.i1,start.j1,start.i2,start.j2));
		visited[start.i1][start.j1] = true;
		visited[start.i2][start.j2] = true;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			// (N, N)에 도달했다면 방법 수 증가
			if(now.i2==N && now.j2==N) count++;
			
			for(int d=0; d<3; d++) {
				// 가로 - 오른쪽 대각선 이동 불가능
				if(now.i1 == now.i2) {
					if(d==2) continue;
				}
				
				// 세로 - 오른쪽 이동 불가능
				if(now.j1 == now.j2) {
					if(d==0) continue;
				}
				
				int nexti = now.i2+di[d];
				int nextj = now.j2+dj[d];
				
				
				// 대각선이라면 3칸이 빈칸이어야 함
				if(d==1) {
					// 범위 내에 있고 방문한 적이 없고 빈칸(오른쪽, 오른쪽대각선, 아래)이라면
					if(nexti>0 && nexti<=N && nextj>0 && nextj<=N
							 && !visited[nexti][nextj] && house[nexti][nextj]==0
							 && house[now.i2+di[0]][now.j2+dj[0]]==0 && house[now.i2+di[2]][now.j2+dj[2]]==0) {
						queue.add(new Point(now.i2, now.j2, nexti, nextj));
					}
				}
				else {
					// 범위 내에 있고 방문한 적이 없고 빈칸(오른쪽 또는 아래)이라면
					if(nexti>0 && nexti<=N && nextj>0 && nextj<=N
							&& !visited[nexti][nextj] && house[nexti][nextj]==0) {
						queue.add(new Point(now.i2, now.j2, nexti, nextj));
					}
				}
				
				
			}
		}
	}
	
	static class Point{
		int i1,j1,i2,j2;

		public Point(int i1, int j1, int i2, int j2) {
			super();
			this.i1 = i1;
			this.j1 = j1;
			this.i2 = i2;
			this.j2 = j2;
		}
	}
	
	static void print() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(house[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}