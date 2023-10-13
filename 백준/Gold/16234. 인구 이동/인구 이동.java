import java.util.*;
import java.io.*;

public class Main {
	static int N, L, R;
	static int[][] map; // map[i][j]: 나라의 인구수
	static int[][] check; // 각 나라 번호를 저장 - 연합이 되면 연합하게 된 나라의 번호로 교체
	static boolean[][] visited; // 이미 연합여부 확인했다는 다시 방문x 
	static int team; //연합번호
	static int[] di = {-1,1,0,0}; // 상하좌우
	static int[] dj = {0,0,-1,1};
	static boolean flag; // 인구 이동 필요한 지 여부
	static int day; // 인구이동이 발생한 일 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 땅의 크기 NxN
		L = Integer.parseInt(st.nextToken()); // L명 이상
		R = Integer.parseInt(st.nextToken()); // R명 이하
		
		// 땅 정보 저장
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//printMap();
		
		day = 0;
		while(true) {
			//System.out.println(day+"일 째 연합 시도");
			flag = false; // 인구 이동 필요 여부
			
			// 연합 정보 저장
			check = new int[N][N];
			team = 1;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						bfs(i, j); // 국경선 열어야 한다면 연합국 번호로 바꿈
						team++;
					}
				}
			}
			
			// 연합이 없다면 바로 종료
			if(!flag) {
				break;
			}
			
			//System.out.println("연합 정보");
			//printCheck();
			
			// 연합에 따른 인구 이동
			move();
			//System.out.println("인구 이동 후");
			//printMap();
			day++;
			
		}
		
		System.out.println(day);
		
	}
	
	
	// 연합에 따른 인구 이동
	private static void move() {
		// 연합번호별 나라 개수
		int[] teamCount = new int[team+1];
		int[] teamSum = new int[team+1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				teamCount[check[i][j]]++;
			}
		}
		
		// 연합번호별 총 인구수
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				teamSum[check[i][j]] += map[i][j];
			}
		}
		
		// 인구 이동 결과 저장
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = teamSum[check[i][j]]/teamCount[check[i][j]];
			}
		}
	}
	
	// 두 나라 연합이 될 수 있는 지 확인
	// 인구 수의 차이 L이상 R이하
	private static boolean checkTeam(int nowCount, int nextCount) {
		//System.out.println("연합 가능 여부: "+nowCount+" "+nextCount);
		int result = Math.abs(nowCount - nextCount);
		
		if(L<=result && result<=R) {
			//System.out.println("연합 가능");
			flag = true;
			return true;
		}
		
		return false;
	}
	
	// 연합번호 저장
	private static void bfs(int starti, int startj) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(starti,startj,map[starti][startj]));
		visited[starti][startj] = true;
		check[starti][startj] = team;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				
				// map내에 있고 아직 연합을 이미했는지, 새로 할 수 있는 지 확인 안 한 상태라면
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<N
						&& !visited[nexti][nextj]) {
					// 연합이 가능하다면
					if(checkTeam(now.count, map[nexti][nextj])) {
						// 0이라면 지금 team번호로 새로운 연합에게 번호 부여
						if(check[nexti][nextj]==0) {
							check[nexti][nextj] = team;
							visited[nexti][nextj] = true;
							queue.add(new Point(nexti, nextj, map[nexti][nextj]));
						}
						// 0이 아니라면 기존 연합이 이미 있다는 의미 - 그 연합에다가 나를 추가
						else {
							check[now.i][now.j] = check[nexti][nextj];
							visited[nexti][nextj] = true;
							queue.add(new Point(nexti, nextj, map[nexti][nextj]));
						}
					}
				}
			}
		}
	}
	
	private static class Point{
		int i;
		int j;
		int count;
		public Point(int i, int j, int count) {
			this.i = i;
			this.j = j;
			this.count = count;
		}
	}
	
	// 연합 정보 확인
	private static void printCheck() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(check[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
		
	// 땅별 인구수 확인
	private static void printMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");	
			}
			System.out.println();
		}
		System.out.println();
	}
}