import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] map;
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1};
	static ArrayList<Point> list;
	static int ansCnt;
	static int ansLen; // 최대한 core를 연결한다고 할 때 전선의 최소 길이 합
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine()); // 가로, 세로 크기
			
			// 맥시노스 초기 정보 저장
			map = new int[N][N]; // 배열 초기화
			list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// core인 경우(가장자리인 경우는 바로 연결 가능하니 제외) 그 좌표 list에 삽입
					if(map[i][j]==1 && !(i==0 || i==N-1 || j==0 || j==N-1)) {
						list.add(new Point(i, j));
					}
				}
			}
			ansCnt = 0;
            ansLen = Integer.MAX_VALUE;
			dfs(0, map, 0); // list.get(0)부터 전선 만들어보기
			
			if(ansCnt == 0) // 전선을 연결해야 하는 코어가 없었다면
				sb.append("#"+tc+" "+0).append("\n");
			else sb.append("#"+tc+" "+ansLen).append("\n");
			
		} // 테스트 케이스 모두 종료
		
		System.out.println(sb);
	}
	
	
	// coreIdx: 코어가 있는 좌표(list.ger(coreIdx)), map: 코어를 연결하고 나면 그 map을 전달
	static void dfs(int coreIdx, int[][] origin, int coreSuccess) {
		// core별로 전선 연결이 완료되면
		if(coreIdx==list.size()) {
			int len = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 전선이 있는 칸 더하기
					if(origin[i][j]==2) len++;
				}
			}

			// 더 많은 코어에 전원을 연결했다면 ansLen 변경
			if(ansCnt < coreSuccess) {
				ansCnt = coreSuccess;
				ansLen = len;
				return;
			}
			
			// 연결한 코어의 갯수가 동일하다면 길이가 더 짫은 경우를 ansLen에 저장
			if(ansCnt == coreSuccess) {
				ansLen = Math.min(ansLen, len);
				return;
			}
			
			return;
		}
		
		// 코어 상하좌우 탐색, 하나의 탐색방향 결정하면 다음 코어의 방향 탐색 시도
		for(int d=0; d<4; d++) {
			boolean success = false;
			int[][] copy = copyMap(origin); // 원본 복사(바로 이전 코어까지 탐색한 결과)해서 전선그리기
			
			Point now = list.get(coreIdx);
			
			success = makeElectricWire(now.i, now.j, d, copy);
			
			// 하나의 전선을 만들기 시도 후 다음 전선 선택하러
			// 전선 연결에 성공했다면 coreSuccess+1과 변경된 copy를 전달
			if(success) {
				dfs(coreIdx+1, copy, coreSuccess+1);
			}
		}
        // 이번 코어는 연결 실패 -> 다음 코어로 넘어가기
		dfs(coreIdx+1, origin, coreSuccess);
	}
	
	// 현재위치에서 선택한 방향으로 전선 만들기
	// 연결 성공이라면 true, 실패라면 false 리턴
	static boolean makeElectricWire(int nowi, int nowj, int dir, int[][] origin) {
		
		int nexti = nowi+di[dir];
		int nextj = nowj+dj[dir];
		
		while(true) {
			
			// 다음 칸이 map 밖이면 while문 종료 - 전선 연결 완료 true
			if(nexti<0 || nexti>=N || nextj<0 || nextj>=N) { 
				return true;
			}
			
			// 다음 칸에 core가 있거나 이미 전선이 있다면 가장자리에 연결 불가 false
			if(origin[nexti][nextj]!=0) {
				return false;
			}

			
			origin[nexti][nextj] = 2; // 전선 표시
			nexti += di[dir];
			nextj += dj[dir];
		}
	}
	
	static class Point{
		int i,j;
		
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	// 배열 복사
	static int[][] copyMap(int[][] copyMap) {
		int[][] tmp = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				tmp[i][j] = copyMap[i][j];
			}
		}
		
		return tmp;
	}
}