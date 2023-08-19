import java.util.*;
import java.io.*;

public class Main {
	static int N,r,c;
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken()); //방문할 행
		c = Integer.parseInt(st.nextToken()); //방문할 열

		dfs(0,0,(int)Math.pow(2, N), (int)Math.pow(2, N));
	}
	
	static void dfs(int si, int sj, int ei, int ej) {
		// 구역 칸 수 count에 더하기
		if(!(si<=r && r<ei && sj<=c && c<ej)) {
			count += (ei-si)*(ej-sj);
			return;
		}
		
		// 사이즈가 1이 되면 종료 -> 찾는 행,열이라면 출력 후 종료
		if(ei-si == 1) {
			if(si==r && sj==c)
				System.out.println(count);
			return;
		}
		
		int mi = (si+ei)/2;
		int mj = (sj+ej)/2;
		
		dfs(si, sj, mi, mj); // 1번 구역
		dfs(si, mj, mi, ej); // 2번 구역
		dfs(mi, sj, ei, mj); // 3번 구역
		dfs(mi, mj, ei, ej); // 4번 구역
	}
}