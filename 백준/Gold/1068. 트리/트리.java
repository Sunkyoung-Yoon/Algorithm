import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int num; // 삭제할 노드번호
	static int count; //리프노드의 개수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 트리의 노드의 개수
		
		tree = new ArrayList[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		int root = 0;
		for(int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			
			if(parent == -1) {
				root = i;
				continue; // 루트 노드
			}
			
			tree[parent].add(i);
		}
		
		num = Integer.parseInt(br.readLine());  // 지울 노드의 번호
		
		if(root != num) { // 루트노드가 삭제대상이 아니라면
			dfs(root);
		}
		
		
		System.out.println(count);
	}
	
	static void dfs(int now) {
		visited[now] = true;
		
		int child = 0; //새로운 now방문할때 자식노드 초기화
		for(int n: tree[now]) {
			// 방문x이고 삭제할 노드가 아니라면
			if(!visited[n] && n != num) {
				child++;
				dfs(n);
			}
		}
		
		if(child == 0) //자식노드가 0이라면 리프노드
			count++;
		
	}
}