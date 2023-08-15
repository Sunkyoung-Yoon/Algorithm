import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int[] parent; //부모노드를 저장할 배열
	static int[] depths; //부모노드의 깊이를 저장할 배열
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); //테스트케이스의 개수
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			tree= new ArrayList[N+1];
			visited = new boolean[N+1];
			parent = new int[N+1];
			depths = new int[N+1];
			for(int n=1; n<=N; n++) {
				tree[n] = new ArrayList<>();
			}
			
			// 트리 정보 저장
			for(int n=0; n<N-1; n++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				tree[A].add(B);
				parent[B] = A; // B의 부모노드는 A
			}
			
			// 부모를 구해야할 노드
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// 깊이를 구하기 위한 탐색
			int root = 0;
			for(int n=1; n<=N; n++) { //부모노드 없으면 0
				if(parent[n]==0)
					root = n;
			}
			dfs(root, 0);
			
			if(LCA(A, B) == 0) sb.append(root).append("\n");
			else sb.append(LCA(A, B)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	// 부모 노드의 깊이 저장
	static void dfs(int now, int depth) {
		visited[now] = true;
		
		for(int n: tree[now]) {
			if(!visited[n]) {
				depths[n] = depth;
				dfs(n, depth+1);
			}
		}
	}
	
	static int LCA(int A, int B) {
		// depths가 같아질때까지 깊이가 더 깊은 쪽의 부모노드 위로 올라가기
		while(depths[A] < depths[B]) {
			B = parent[B];
		}
		while(depths[A] > depths[B]) {
			A = parent[A];
		}
		
		// 한쪽을 올려서 노드가 같아지면 그게 최소공통부모노드
		if(A==B) 
			return A;
		
		// 다르면 둘의 더 위 부모 노드를 비교
		while(A != B) {
			A = parent[A];
			B = parent[B];
		}
		// 둘이 같아지면 부모노드 리턴
		return A;	
	}

}