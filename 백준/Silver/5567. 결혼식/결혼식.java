import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] arrayList;
	static boolean[] visited;
	static int[] visitedCheck;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		arrayList = new ArrayList[n+1];
		visited = new boolean[n+1];
		visitedCheck = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arrayList[i] = new ArrayList<>();
		}
		
		
		// 친구 관계 저장
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arrayList[a].add(b);
			arrayList[b].add(a);
		}
		
		dfs(1, 0);
		
		
		int count = 0;
		for(int i=2; i<=n; i++) { 
			if(visited[i]) {
				count++;
			}
		}
		
		System.out.println(count);

	}
	
	// 친구와 친구의친구까지 초대 대상
	// 친구, depth 1
	// 친구의 친구, depth 2 -> 3이상이 되면 친구의 친구의 친구이므로 return
	static void dfs(int now, int depth) {
		if(depth == 2) return;
		
		for(int n: arrayList[now]) {
			visited[n] = true;
			dfs(n, depth+1);
		}
	}
}