import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] company;
	static int[] score; // 칭찬 점수를 저장할 배열
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken()); // 회사의 직원 수
		int m = Integer.parseInt(st.nextToken()); // 최초의 칭찬 횟수
		
		company = new ArrayList[n+1]; // 직원의 번호는 1부터
		score = new int[n+1];
		for(int i=1; i<=n; i++) {
			company[i] = new ArrayList<>();
		}
		
		// 직원 n명의 직속 상사의 번호 저장 - i번 직원의 상사번호
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			
			if(parent == -1) {
				continue;
			}
			company[parent].add(i);
		}
		
		// 직속 상사로부터 칭찬받은 직원번호, 칭찬의 수치 입력
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 부하와 칭찬 점수
			// 같은 부하를 여러번 칭찬할수도 있기 때문에 +=
			score[num] += w;
		}
		
		dfs(1);
		for(int i=1; i<=n; i++) {
			sb.append(score[i]+" ");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int now) {
		
		// now와 인접한 n -> 부하의 부하
		// 칭찬받은 부하의 부하라면 칭찬 점수를 더해준다
		for(int n : company[now]) {
			score[n] += score[now];
			dfs(n);
		}
	}

}