import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map; // 연구소
	static int[][] copy; 
	static int maxCount; // 최대 안전구역 수
	static int[] di = {-1,1,0,0}; // 상하좌우
	static int[] dj = {0,0,-1,1};
	static List<Point> selectList = new ArrayList<>(); // 고른 벽의 위치 리스트
	static List<Point> selectCheckList = new ArrayList<>(); // 벽 위치 후보 리스트
	static List<Point> virusList = new ArrayList<>(); // 바이러스가 있는 좌표
	static boolean[][] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[N][M]; 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) { // 바이러스 위치 리스트에 삽입
					virusList.add(new Point(i,j));
				}
				
				if(map[i][j] == 0) { //벽을 세울 수 있는 칸들 리스트에 삽입
					selectCheckList.add(new Point(i,j));
				}
			}
		}
		
		
		selected = new boolean[N][M];
		select(0, 0);
		
		System.out.println(maxCount);

	}
	
	public static void select(int idx, int cnt) { // r:다음 행, c:다음 열, cnt: 고른 벽 위치 개수
		if(cnt == 3) { // 벽을 놓을 위치를 골랐다면
			copy = copy(map);
			
			// 벽인 곳 1로 변경
			for(int i=0; i<selectCheckList.size(); i++) {
				Point select = selectCheckList.get(i);
				
				if(selected[select.i][select.j]) { // 방문체크된 곳이 벽을 세울곳
					copy[select.i][select.j] = 1;
					selectList.add(new Point(select.i, select.j));
				}
			}
			
			
			// 바이러스 퍼뜨리기
			bfs(copy);
			
			// 안전구역 카운트
			int result = zeroCount(copy);
			maxCount = Math.max(maxCount, result);
			
			selectList = new ArrayList<>();
			return;
		}
		
		if(idx == selectCheckList.size()) return;
		
		for(int i=idx; i<selectCheckList.size(); i++) {
			Point sPoint = selectCheckList.get(i);
			selected[sPoint.i][sPoint.j] = true;
			select(i+1,cnt+1);
			selected[sPoint.i][sPoint.j] = false;
		}
	}
	
	
	public static void bfs(int[][] tmp) { // 바이러스 퍼뜨리기
		Queue<Point> queue = new LinkedList<>();
		for(int i=0; i<virusList.size(); i++) {
			Point virus = virusList.get(i);
			queue.add(new Point(virus.i, virus.j));
		}
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int d=0; d<4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if(nexti >= 0 && nexti<N && nextj >=0 && nextj<M &&
						tmp[nexti][nextj] == 0) { // 연구소 내에 있고 벽이거나 바이러스가 아닌 안전구역이라면 
					tmp[nexti][nextj] = 2; // 바이러스 퍼뜨리기
					queue.add(new Point(nexti, nextj));
				}
			}
		}
		
	}
	
	
	public static int zeroCount(int[][] tmp) {
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {				
				if(tmp[i][j] == 0) { // 안전구역이라면
					count++;
				}
			}
		}
		return count;
	}
	
	public static int[][] copy(int[][] copyMap) {
		int[][] tmp = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {				
				tmp[i][j] = copyMap[i][j];
			}
		}
		
		return tmp;
	}
	
	public static class Point {
		int i;
		int j;
		
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
}