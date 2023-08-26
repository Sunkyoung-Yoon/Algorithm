import java.util.*;
import java.io.*;

public class Main {
	static int N, M; // 지도의 세로,가로길이
	static int[][] map; // 지도 정보를 저장할 배열
	static boolean[][] visited; // 방문배열
	
	static int[] di = {-1,1,0,0}; // 상하좌우
	static int[] dj = {0,0,-1,1}; 
	
	static int[] parents; // 크루스칼
	static PriorityQueue<Edge> pq; // 다리(간선)가 만들어지는 경우를 모두 저장할 우선순위 큐
	
	static class Edge implements Comparable<Edge>{
		int n1, n2, weight;

		public Edge(int n1, int n2, int weight) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.weight = weight;
		}
		
		// 정렬 기준 정의 : 가중치가 작은 쪽을 앞으로
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
		M = Integer.parseInt(st.nextToken()); // 지도의 가로 크기
		
		// 지도 정보 저장
		map = new int[N][M]; // 배열 초기화
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 섬마다 번호 붙여서 바꿔주기
		visited = new boolean[N][M]; // 방문배열 초기화
		int landNum = 0; //섬번호
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					landNum++;
					dfs(i, j, landNum);
				}
			}
		}
				
		pq = new PriorityQueue<>();
		makeEdge(); // 다리 만들기
		
		
		// 모든 섬이 연결되었을 때 최소 길이 구하기
		int ans = 0; // 모든 섬이 연결되었을 때 최소 길이
		int edgeCnt = 0; // 연결된 다리의 갯수
		parents = new int[landNum+1]; // 섬번호 1~landNum, 각 parents는 연결된 섬 번호
		for(int i=1; i<=landNum; i++) { // 자기자신을 도착점으로 갖도록 초기화
			parents[i] = i;
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll(); //가장 짧은 길이부터 꺼내기 - 넣을때 정렬해뒀기 때문
			
			if(union(edge.n1, edge.n2)) {
				edgeCnt++; // true라면 다리 연결 성공이므로 연결된 다리 갯수 증가
				ans += edge.weight;
			}
		}
		System.out.println(edgeCnt == landNum-1? ans:-1); //섬번호-1만큰 개수가 나오지 않았다면 불가능하므로 -1 출력
	}
	
	
	static void makeEdge() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]>0) { //0보다 크다면 -> 섬이 있다면
					
					for(int d=0; d<4; d++) {
						int len = 0; // 다리의 길이
						int nowi = i; // 현재 좌표를 nowi, nowj에 저장
						int nowj = j;
						
						while(true) {
							int nexti = nowi+di[d]; // 다음 칸
							int nextj = nowj+dj[d];

							// 다리를 놓을 때 생기는 경우의 수
							// 1. 지도 밖인 경우
							// 2. 지도 내이면서 땅인 경우 (같은 섬 땅, 다른 섬 땅)
							// 3. 지도 내이면서 물인 경우
							
							// 지도 밖이거나 같은 섬 땅인 경우에는 다리 놓기 중지
							// 방향 전환이 필요! -> while문 탈출 후 d 증가 필요
							if(nexti<0 || nexti>=N || nextj<0 || nextj>=M ||
									map[nexti][nextj]==map[i][j]) {
								break;
							}
							
							// 다리 놓기
							if(map[nexti][nextj]==0) {
								len++; // 다리길이+1
								nowi = nexti; // 다음 칸으로 이동
								nowj = nextj;
							}
							
							// 섬이면서 다른 섬에 도달했다면 -> 다리 완성
							if(map[nexti][nextj]>0 && map[nexti][nextj]!=map[i][j]) {
								// 다리가 1인 경우는 제외
								if(len>=2) {
									// 완성한 다리 정보 저장 - 시작섬, 도달섬, 다리길이
									pq.add(new Edge(map[i][j], map[nexti][nextj], len));
								}
								break; // 지금 방향으로 직진 이어서 진행
							}
						}
					}
				}
			}
		}
	}
	
	static boolean union(int n1, int n2) {
		int n1Root = find(n1);
		int n2Root = find(n2);
		
		// 루트가 같다면 같은 집합 -> union 불가능
		if(n1Root==n2Root) return false;
		
		parents[n2Root] = n1Root; // n2를 n1에 붙이기
		return true;
	}
	
	static int find(int n) {
		if(parents[n] == n) return n;
		else return parents[n] = find(parents[n]);
	}
	
	static void dfs(int nowi, int nowj, int landNum) {
		map[nowi][nowj] = landNum;
		visited[nowi][nowj] = true;
		
		for(int d=0; d<4; d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			// 지도 내 범위이고 값이 1이면서 아직 방문하지 않은 곳이라면
			if(nexti>=0 && nexti<N && nextj>=0 && nextj<M
					&& map[nexti][nextj]==1 && !visited[nexti][nextj]) {
				map[nexti][nextj] = landNum;
				dfs(nexti, nextj, landNum);
			}
		}
	}
	
//	static void print() {
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}