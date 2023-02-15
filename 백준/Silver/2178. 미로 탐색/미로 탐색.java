import java.io.*;
import java.util.*;

public class Main {
	static int[][] maze; //미로
	static boolean[][] visited; //방문체크할 배열
	static int[] dx = {-1,1,0,0}; //x 상하  
	static int[] dy = {0,0,-1,1}; //y 좌우
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //N개의 줄
		M = Integer.parseInt(st.nextToken()); //M개의 정수

		
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		
		//미로 정보 저장
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			
			for(int j=0; j<M; j++) {
				maze[i][j] = Integer.parseInt(s.substring(j,j+1));
			}
		}
		
		
		bfs(0,0); //(1,1)지점이 배열에서 [0,0]과 같음
		System.out.println(maze[N-1][M-1]);
	}
	
	
    //너비우선탐색
	public static void bfs(int start_x, int start_y) {
		Queue<int[]> queue = new LinkedList<>();
		visited[start_x][start_y] = true; //방문표시
		queue.add(new int[] {start_x,start_y}); //시작좌표(0,0) 큐에 삽입
		
		//큐가 빌 때까지
		while(!queue.isEmpty()) {

			int[] now = queue.poll(); //현재 위치 
			int x = now[0];
			int y = now[1];
			
			//상하좌우에 갈 수 있는 다음 칸 확인
			for(int i=0; i<4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				//(x,y)가 미로 범위내인지 확인
				if(nextX>=0 && nextY>=0 && nextX<N && nextY<M) {
					
					//인접한 위치가 1이고 방문한 적 없는 곳이라면
					if(maze[nextX][nextY]==1 && !visited[nextX][nextY]) {
						queue.add(new int[] {nextX, nextY});
						visited[nextX][nextY]=true;
						
						//한칸 이동 -> 현재 이동한 위치의 값을 이전에 이동한 칸 수 +1로 변경
						maze[nextX][nextY] = maze[x][y]+1; 
					}
				}
			}
		}
	}
}