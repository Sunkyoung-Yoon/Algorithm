import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] map;
	static int maxCount;
	static int[] di = {1,1,-1,-1}; // 오른쪽아래 왼쪽아래 왼쪽위 오른쪽위
	static int[] dj = {1,-1,-1,1};
	static boolean[] check;
	static Point start;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스크 케이스 수
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//print();
			
			// 시작 좌표를 주고 최대 디저트 수 탐색
			maxCount = 0;
			// 맨 아래 두행과 맨 왼쪽, 맨 오른쪽은 어차피 사각형 못만드니까 제외!
			for(int i=0; i<N-2; i++) {
				for(int j=1; j<N-1; j++) {
					check = new boolean[101]; // 디저트 종류의 수 체크
					start = new Point(i, j);
					check[map[i][j]] = true;
					eat(new Point(i, j), new Point(i, j), 0, 1);
				}
			}
			if(maxCount==0) maxCount = -1; // 하나의 카페에서 먹는 것도 제외 대상
			sb.append("#"+tc+" "+maxCount).append("\n");

		} // 테스트 케이스 종료
		
		System.out.println(sb);
	}
	
	static void eat(Point now, Point pre, int dir, int cnt) {
		for(int d=dir; d<4; d++) {
			
			int nexti = now.i+di[d];
			int nextj = now.j+dj[d];
			
			// 맵내가 아니라면
			if(nexti<0 || nexti>=N || nextj<0 || nextj>=N) continue;
			
			// 이전 경로 다시가면
			if(pre.i == nexti && pre.j==nextj) continue;
			
			// 시작점으로 다시 돌아왔다면
			if(nexti==start.i && nextj==start.j) {
				maxCount = Math.max(maxCount, cnt);
				return;
			}
			
			// 방문처리 (디저트 개수)
			if(check[map[nexti][nextj]]) continue;
			
			check[map[nexti][nextj]] = true;
			eat(new Point(nexti, nextj), now, d, cnt+1);
			check[map[nexti][nextj]] = false; //다른 루트로 탐색할 경우 대비 false 처리			

		}
	}
	
	static class Point{
		int i, j;
		
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}