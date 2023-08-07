import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int[] nums;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k == 0) break;
			
			nums = new int[k];
			result = new int[6];
			for(int i=0; i<k; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[k];
			lotto(0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	// 중복원소x , 순서의미x -> 조합
	static void lotto(int idx, int cnt) {
		if(cnt == 6) {
			for(int i=0; i<6; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i=idx; i<k; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[cnt] = nums[i];
				lotto(i+1, cnt+1); // 
				visited[i] = false;
			}
		}
	}

}