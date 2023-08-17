import java.io.*;

public class Main {
	static int N;
	static char[][] color;
	static boolean[][] visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		color = new char[N][N];
		visited = new boolean[N][N];
		
		// 컬러 정보 저장
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			color[i] = s.toCharArray();
		}
		
		// 구역 탐색 - 적록색약이 아닌 사람
		int count1 = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					char ch = color[i][j];
					dfs(i, j, ch);
					count1++;
				}
			}
		} //구역 탐색 종료
		
		
		// G를 R로 변경
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(color[i][j]=='G')
					color[i][j]='R';
			}
		}
		
		visited = new boolean[N][N]; //새로운 탐색을 위해 방문 초기화
		// 구역 탐색 - 적록색약인 사람
		int count2 = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					char ch = color[i][j];
					dfs(i, j, ch);
					count2++;
				}
			}
		} //구역 탐색 종료
		
		System.out.println(count1+" "+count2);
	}
	
	// ch: 같은 구역이 될 색깔 
	static void dfs(int nowi, int nowj, char ch) {
		visited[nowi][nowj] = true;
		
		for(int d=0; d<4; d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti>=0 && nexti<N && nextj>=0 && nextj<N &&
					color[nexti][nextj]==ch && !visited[nexti][nextj]) {
				dfs(nexti, nextj, ch);
			}
		}
	}
}