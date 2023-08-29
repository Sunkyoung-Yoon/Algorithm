import java.util.*;

public class Main {
	static int[] arr;
	static int[] di = {1, 3, 2};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;
		
		arr = new int[1000001];
		bfs(N);
		
		System.out.println(arr[1]);

	}

	static void bfs(int N) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[1000001];
		queue.add(N);
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(now == 1) break;
			
			for(int d=0; d<3; d++) {
				int nexti = 0;
				if(now%di[d] == 0) {
					nexti = now/di[d];
				}
				
				if(d==0) {
					nexti = now-di[0];
				}
				
				if(nexti>=0 && nexti<1000001 && !visited[nexti]) {
					queue.add(nexti);
					visited[nexti] = true;
					arr[nexti] = arr[now]+1;
				}
			}
		}
		
	}
}