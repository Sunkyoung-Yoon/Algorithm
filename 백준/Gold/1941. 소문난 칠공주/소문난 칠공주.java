import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static List<Point> selectList; // 선택된 칠공주 좌표를 담을 리스트
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1};
	static int count; // 소문난 칠공주를 결성할 수 있는 경우의 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		for(int i=0; i<5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		
		visited = new boolean[5][5];
		select(0,0);

		System.out.println(count);
	}
	
	// 소문난 칠공주 결성
	// 중복x, 순서x -> 조합
	static void select(int idx, int cnt) {
		if(cnt == 7) {
			selectList = new ArrayList<>();
			int cntS = 0; // 이다솜파의 숫자
			
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(visited[i][j]) {
						selectList.add(new Point(i, j));						
						if(map[i][j] == 'S') {
							cntS++;
						}
					}
				}
			}
			
			// 이다솜파가 4명이상이고 7명이 서로 상하좌우 중 하나에 인접했다면
			if(cntS >= 4 && bfs()) {
				count++;
			}
			
			return;
		}
		
		if(idx == 25) return;
		
		int i = idx/5; // 현재 위치의 행
		int j = idx%5; // 현재 위치의 열
		
		visited[i][j] = true;
		select(idx+1, cnt+1);
		visited[i][j] = false;
		select(idx+1, cnt);
	}
	
	// 소문난 칠공주가 모두 이어져 있는지 확인
	static boolean bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[] visit = new boolean[selectList.size()];
		Point start = selectList.get(0);
		queue.add(new Point(start.i, start.j));
		visit[0] = true;
		
		int cnt = 1; // 모두 이어져있다면 7개 카운트
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			// 고른 칠공주들이 상하좌우중 하나로 이어져있는지 확인
			for(int d=0; d<4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				for(int i=1; i<selectList.size(); i++) {
					Point select = selectList.get(i);
					// 상하좌우에 인접한 좌표이고 방문하지 않은 곳이라면
					if(select.i==nexti && select.j==nextj && !visit[i]) {
						queue.add(new Point(select.i, select.j));
						visit[i] = true;
						cnt++;
					}
				}
			}
		}
		
		if(cnt == 7) return true;
		else return false;
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