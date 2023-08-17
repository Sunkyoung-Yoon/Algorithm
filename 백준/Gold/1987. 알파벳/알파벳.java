import java.util.*;
import java.io.*;

public class Main {
	static int R, C; // 보드의 가로 세로
	static char[][] board; // 보드
	static boolean[] alpha; // 알파벳 방문체크배열
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1}; 
	static int max; // 최대의 칸 수
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		alpha = new boolean[26];
		
		// 알파벳 입력받아 board에 저장
		for(int i=0; i<R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		dfs(0, 0, 1);
		
		System.out.println(max);
	}
	
	static void dfs(int nowi, int nowj, int count) {
		alpha[board[nowi][nowj]-'A'] = true;
		
		for(int d=0; d<4; d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			// 보드 내에 있고 방문하지 않은 칸이고, 새로운 알파벳이라면
			if(nexti>=0 && nexti<R && nextj>=0 && nextj<C &&
					 !alpha[board[nexti][nextj]-'A']) {
				dfs(nexti, nextj, count+1);
			}
		}
		
		// 다시 최대 칸 탐색할 경우를 위해 현재 값 false 처리
		alpha[board[nowi][nowj]-'A'] = false;

		max = Math.max(max, count);
	}
}