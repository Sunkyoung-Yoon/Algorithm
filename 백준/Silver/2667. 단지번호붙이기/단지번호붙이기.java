import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1};
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 지도의 크기
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		// 지도 돌면서 단지 찾기
		int num = 0; // 총 단지 수
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					num++;
					count = 0;
					bfs(i, j);
					
					// 단지별 개수 sb에 저장
					list.add(count);
				}
			}
		}
		
		Collections.sort(list); // 각 단지 내 집의 수 오름차순 정렬
		
		sb.append(num).append("\n");
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int starti, int startj) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {starti, startj});
		visited[starti][startj] = true; //방문예정
		count++; //시작집 count에 더해주기
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nexti = now[0]+di[d];
				int nextj = now[1]+dj[d];
				
				// 지도 내에 있고 집이며 방문하지 않은 곳이라면
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<N &&
						map[nexti][nextj]==1 && !visited[nexti][nextj]) {
					queue.add(new int[] {nexti, nextj});
					visited[nexti][nextj] = true; //방문예정
					count++; // 단지 내 집 개수 더하기
				}
			}
		}
	}
}