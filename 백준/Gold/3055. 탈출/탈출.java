import java.io.*;
import java.util.*;

public class Main {
	static int R,C;
	static char[][] map; //지도
	static Point end;
	static List<Point> list = new ArrayList<>(); //물이 차있는 지역 초기 위치 리스트
	static Queue<Point> startQueue = new LinkedList<>(); //고슴도치가 이동시작할 때 현재 위치가 될 수 있는 얘들
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1};
	static boolean[][] visited;
	static int time;
	static boolean flag; // 비버의 굴 도착 여부
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		
		// 지도 정보 저장
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
				
				// 물 위치 저장
				if(map[i][j] == '*') {
					list.add(new Point(i,j));
				}
				
				// 시작 위치 저장
				if(map[i][j] == 'S')
					startQueue.add(new Point(i,j));
				
				// 비버의 굴 위치 저장
				if(map[i][j] == 'D')
					end = new Point(i,j);
			}
		}
		
		
		visited = new boolean[R][C];
		bfs();
		
		if(!flag) System.out.println("KAKTUS");
		else System.out.println(time);
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		
		// 물이 차있는 지역 저장
		for(int i=0; i<list.size(); i++) {
			Point water = list.get(i);
			queue.add(new Point(water.i, water.j));
			visited[water.i][water.j] = true;
		}
		
		while(!startQueue.isEmpty()){
			
			int size = queue.size(); // 초기 사이즈 저장
			// 물 차는 지역 먼저 물 다 채우기
			for(int s=0; s<size; s++) {
				Point now = queue.poll();
				
				// 물 퍼뜨리기
				for(int d=0; d<4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];
					
					// 지도 내에 있고 돌이 아니고 물이 차지 않은 지역이며 비버의 굴이 아니라면 물 채우기
					if(nexti >=0 && nexti<R && nextj>=0 && nextj<C
							&& map[nexti][nextj] != 'X' && map[nexti][nextj] != '*'
							&& map[nexti][nextj] != 'D') {
						queue.add(new Point(nexti, nextj));
						map[nexti][nextj] = '*';
					}
				}
			}
			
			time++; // 걸린시간 증가
			
			int startSize = startQueue.size();
			// 고슴도치가 현재 이동가능한 좌표들 기준으로 상하좌우 탐색
			for(int i=0; i<startSize; i++) {
				Point start = startQueue.poll();
				// 고슴도치 이동
				for(int d=0; d<4; d++) {
					int nexti = start.i + di[d];
					int nextj = start.j + dj[d];
					
					// 지도 내에 있고 돌이 아니고 방문하지 않은 지역이며 물이 차있지 않은 곳이라면 이동
					if(nexti >=0 && nexti<R && nextj>=0 && nextj<C
							&& map[nexti][nextj] != 'X' && !visited[nexti][nextj] 
							&& map[nexti][nextj] != '*') {
						startQueue.add(new Point(nexti, nextj));
						visited[nexti][nextj] = true;
						map[nexti][nextj] = 'S';
						
						if(nexti == end.i && nextj == end.j) {
							flag = true;
							return;
						}
					}
				}
			}
		}
		
	}
	
	
	static void print() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static class Point{
		int i;
		int j;
		
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
}