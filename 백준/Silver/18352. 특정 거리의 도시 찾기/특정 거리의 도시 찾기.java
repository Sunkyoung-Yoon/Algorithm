import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] list; //인접리스트
	static int visited[]; //X와의 거리
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new int[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
			//거리를 저장할 배열 -1로 초기화
			visited[i] = -1; 
		}
		
		//도로 정보 저장
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		
		//시작 노드 0으로 변경
		visited[X] = 0;
		bfs(X);
		
		boolean flag = false; //X로부터 K거리에 있는 노드있는지
		//오름차순으로 번호 sb에 저장
		for(int i=1; i<=N; i++) {
			if(visited[i]==K) {
				flag = true;
				sb.append(i).append(" ");
			}
		}
		
		if(flag) System.out.println(sb);
		else System.out.println("-1");
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start); //시작노드 큐에 삽입
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			//now와 연결된 노드 탐색
			for(int n: list[now]) {
				//방문한 적 없다면
				if(visited[n]==-1) {
					queue.add(n);
					//X로부터 now노드까지 거리 +1을 저장
					visited[n] = visited[now]+1;
				}
			}
		}
	}
}