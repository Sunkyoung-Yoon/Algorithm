import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] A; //인접리스트
	static boolean visited[]; //방문 체크
	static int[] result; //방문 횟수 체크 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = 0; //방문 횟수 최댓값
		
		A = new ArrayList[N+1];
		result = new int[N+1];
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<Integer>(); 
		}
		
		//신뢰 정보 저장
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
		}
		
		
		//모든 노드 bfs, 방문 횟수 세기
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			bfs(i);
		}
		
		//방문 횟수 최댓값 max에 저장
		for(int i=1; i<=N; i++) {
			max = Math.max(max, result[i]);
		}
		
		for(int i=1; i<=N; i++) {
			//max와 result[i]가 같다면 가장 많이 신뢰받는 노드
			if(result[i]==max)
				System.out.print(i+" ");
		}
		
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start]=true;
		queue.add(start); //시작노드 큐에 삽입
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			//now와 연결된 노드 탐색
			for(int n: A[now]) {
				//방문한 적 없다면
				if(!visited[n]) {
					queue.add(n);
					visited[n]=true;
					//방문횟수 result증가
					result[n]++;
				}
			}
		}
	}
}