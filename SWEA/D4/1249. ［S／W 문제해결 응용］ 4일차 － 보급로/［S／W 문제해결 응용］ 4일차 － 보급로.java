import java.util.*;
import java.io.*;


public class Solution {
	static int N; 
	static int[][] map;
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1};
	static int minCost; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			N = Integer.parseInt(br.readLine()); //지도크기 NxN
			map = new int[N][N];
			minCost = Integer.MAX_VALUE;
			
			String s = "";
			for(int i=0; i<N; i++) {
				s = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}
			// print();
			
			bfs(0,0,0);
			
			sb.append("#"+tc+" "+minCost).append("\n");
			
			
		} // 테스트케이스 종료
		
		System.out.println(sb);
		
	}
	
	static void bfs(int starti, int startj, int startCost) {
		PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) ->{
			// 비용(시간)이 작은 게 먼저
			return o1.cost - o2.cost;
		});
		boolean[][] visited = new boolean[N][N];
		pq.add(new Point(starti, startj, startCost));
		visited[starti][startj] = true;
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			//System.out.println("now방문:"+now.i+","+now.j+" "+now.cost);
			
			// 도착지 도착
			if(now.i==N-1 && now.j==N-1) {
				// 비용이 더 작은 경우발견했다면 업데이트
				minCost = Math.min(minCost, now.cost);
			}
			
			// 도착지에 도달 전에 이미 이전에 도달햇을 때 경우보다 비용이 크다면 더 탐색할 필요x
			if(now.cost > minCost) {
				continue;
			}
			
			for(int d=0; d<4; d++) {
				int nexti = now.i+di[d];
				int nextj = now.j+dj[d];
				
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<N
						&& !visited[nexti][nextj]) {
					int time = now.cost + map[nexti][nextj]; // 도달한 시간 저장
					pq.add(new Point(nexti, nextj, time));
					visited[nexti][nextj] = true;
				}
			}
		}
		
		
	}
	
	static class Point{
		int i,j,cost;
		
		public Point(int i, int j, int cost) {
			this.i = i;
			this.j = j;
			this.cost = cost;
		}
	}
	
	static void print(){
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}