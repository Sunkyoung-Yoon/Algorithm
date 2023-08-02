import java.io.*;
import java.util.*;

// N과 M (2)
public class Main {
	static int N, M;
	static int[] nums;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N+1];
		visited = new boolean[N+1];
		sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			nums[i] = i;
		}
		
		result(0, 1);
		
		System.out.println(sb);
		
	}
	
	static void result(int cnt, int start) {
		if(cnt == M) {
			// 방문한 숫자들 -> 수열 -> sb에 저장
			for(int i=1; i<=N; i++) {
				if(visited[i] == true)
					sb.append(nums[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		// 수열 만들기
		for(int i=start; i<=N; i++) {
			//이미 방문한 숫자는 패스
			if(visited[i] == false) {
				visited[i] = true;
				result(cnt+1, i+1);
				visited[i] = false;
			}
		}
	}

}