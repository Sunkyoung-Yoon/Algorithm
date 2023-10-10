import java.util.*;
import java.io.*;

public class Main {
	static int R,C,T; // R:행 C:열 T:시간(초)
	static int[][] map;
	static Queue<Point> queue;
	static ArrayList<Point> airList;
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1};
	static int time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		T = Integer.parseInt(st.nextToken()); // 초
		
		// map 정보 저장
		map = new int[R][C];
		queue = new LinkedList<>();
		airList = new ArrayList<>();
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == -1) { // 공기청정기 위아래 좌표
					airList.add(new Point(i,j, 0));
				}
				
			}
		}
		
		// T초 동안 실행
		for(int t=0; t<T; t++) {
			check(); //미세먼지 위치 큐에 넣기
			bfs(); // 미세먼지 
			clean(); // 공기청정기
		}
		
		System.out.println(count());
		
	}
	
	private static void check() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {				
				if(map[i][j] > 0) { // 미세먼지가 있는 곳 좌표
					queue.add(new Point(i,j,map[i][j]));
				}
			}
		}
	}
	
	// 미세먼지 퍼뜨리기
	private static void bfs() {
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int cnt = 0;
			
			for(int d=0; d<4; d++) {
				int nextr = now.i + di[d];
				int nextc = now.j + dj[d];
				
				// map 내에 있고 공기청정기가 아니라면
				if(nextr>=0 && nextr<R && nextc>=0 && nextc<C
						&& map[nextr][nextc]!=-1) {
					map[nextr][nextc] += now.n/5; // 원래 있다면 있는 미세먼지 + 새로 확산된 양 저장					
					cnt++;
				}
			}
			
			// 처음 유포 위치에 확산된 칸 개수 포함 계산해서 미세먼지 양 변경
			map[now.i][now.j] = map[now.i][now.j]-(now.n/5)*cnt;
			
		}
	}
	
	// 공기 청정기
	private static void clean() {
		int up = airList.get(0).i; // 공기 정청기 위
		int down = airList.get(1).i; // 공기 청정기 아래
		
		// 반시계 공기청정기
		for(int i=up-1; i>0; i--) { // 아래로 이동
			map[i][0] = map[i-1][0];
		}
		for(int j=0; j<C-1; j++) { // 왼쪽으로 이동
			map[0][j] = map[0][j+1];
		}
		for(int i=0; i<up; i++) { // 위로 이동
			map[i][C-1] = map[i+1][C-1];
		}
		for(int j=C-1; j>1; j--) { // 오른쪽으로 이동, 1인 이유: 공기청정기 자리에 잇는 -1을 오른똑으로 이동할 필요x
			map[up][j] = map[up][j-1];
		}
		map[up][1] = 0; // 공기청정기에서 한칸이동한 건 0 
		
		// 시계
		for(int i=down+1; i<R-1; i++) { // 위로 이동
			map[i][0] = map[i+1][0];
		}
		for(int j=0; j<C-1; j++) { // 왼쪽으로 이동
			map[R-1][j] = map[R-1][j+1];
		}
		for(int i=R-1; i>down; i--) { // 아래로 이동
			map[i][C-1] = map[i-1][C-1];
		}
		for(int j=C-1; j>1; j--) { // 오른쪽으로 이동, 1인 이유: 공기청정기 자리에 잇는 -1을 오른똑으로 이동할 필요x
			map[down][j] = map[down][j-1];
		}
		map[down][1] = 0; // 공기청정기에서 한칸이동한 건 0 
	}
	
	// 미세먼지 세기
	private static int count() {
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) {
					sum += map[i][j];
				}
			}
		}
		return sum;
	}
	
	private static void print() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static class Point{
		int i;
		int j;
		int n;
		public Point(int i, int j, int n) {
			super();
			this.i = i;
			this.j = j;
			this.n = n;
		}
	}
}