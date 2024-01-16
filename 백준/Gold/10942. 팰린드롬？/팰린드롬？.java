import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 수열의 크기
		
		
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N+1]; // 칠판에 적은 수들을 저장할 배열
		for(int i=1; i<=N; i++) {
			nums[i]  = Integer.parseInt(st.nextToken());
		}
			
		int M = Integer.parseInt(br.readLine()); // 홍준이가 한 질문의 개수
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			boolean flag = true; //팰린드롬인지 판별 결과
			while(S <= E) {
				if(nums[S] == nums[E]) { // 칠판의 적은 수 처음과 끝을 비교
					S++;
					E--;
				}
				else { // 좁혀가면서 비교하다가 다른 순간이 오면 팰린드롬이 아님
					flag = false;
					break;
				}
			}
			
			
			if(flag) { // 팰린드롬이라면
				sb.append("1").append("\n");
			}
			else {
				sb.append("0").append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}

}