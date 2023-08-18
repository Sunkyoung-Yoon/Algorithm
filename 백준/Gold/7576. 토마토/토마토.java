import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static int[][] box;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int max; //모든 토마토가 익을떄까지 걸리는 일수
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸수
		N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸수
		ArrayList<int[]> list = new ArrayList<>(); // 토마토가 있는 자리를 저장할 리스트
		
		box = new int[N][M];
		// 박스에 토마토 정보 저장
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				// 토미토가 있는 자리 기억
				if(box[i][j] == 1) {
					list.add(new int[] {i, j});
				}
			}
		}
		
		max = 0;
		bfs(list);
		
		if(!check()) System.out.println(-1);
		// 처음 토마토가 1인 상태에서 하나씩 더해서 갔기 때문에 -1해줘야 한다
		else System.out.println(max-1);

	}
	
	
	static void bfs(ArrayList<int[]> list) {
		Queue<int[]> queue = new LinkedList<>();
		// 토마토가 있는 좌표 큐에 넣기
		for(int i=0; i<list.size(); i++) {
			queue.add(list.get(i));
		}
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nexti = now[0]+di[d];
				int nextj = now[1]+dj[d];

				// 박스 범위내에 있고 0이라면(익지 않은 토마토가 있다면)
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<M 
						&& box[nexti][nextj]==0) {
					queue.add(new int[] {nexti, nextj});
					box[nexti][nextj] = box[now[0]][now[1]]+1;
					max = Math.max(max, box[nexti][nextj]);
				}
			}
		}
		
	}
	
	
	// 토마토 전체가 다익었는지 체크 & 최대일수 확인
	static boolean check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				// 0인 토마토가 있으면 전체 익히기 불가능
				if(box[i][j]==0) {
					return false;
				}
				// 최대 일수 max에 저장
				else max = Math.max(max, box[i][j]);
			}
		}
		
		return true;
	}
}