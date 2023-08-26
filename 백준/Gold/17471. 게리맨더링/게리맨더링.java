import java.util.*;
import java.io.*;

public class Main {
	static int N; // 구역의 개수
	static LinkedList<Integer>[] graph; // 인접한 구역 정보를 저장할 리스트 - 구역은 1~N
	static boolean[] visited; // 인접한 구역 묶음 계산을 위한 방문 체크 배열
	static int[] people; // 구역별 인구수 - 구역은 1~N
	static int min = Integer.MAX_VALUE; // 두 선거구의 최소 인구 수 차이
	static boolean flag = true; // 실행한 파트의 결과를 판별하기 위한 변수
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 구역의 개수
		
		graph = new LinkedList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new LinkedList<>();
		}
		
		people = new int[N+1];
		// 구역별 인구 수 저장
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) { 
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		// 각 구역별 인접한 지역의 수 와 인접한 지역 정보 저장
		for(int a=1; a<=N; a++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<count; j++) {
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b); 
				graph[b].add(a);
			}
		}
		
		// 구역 나눈것 별로 인구 수 비교 필요
		// 구역을 나눌 때, 조합은 예를들어 N이 6이면 1/5, 2/4, 3,3으로 나뉘는 경우가 존재
		visited = new boolean[N+1];
		for(int result=1; result<=N/2; result++) {
			comb(1,0,result);
		}
		
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	
	// 구역별 뽑기 시작
	static void comb(int idx, int cnt, int result) {
		// 원하는 개수로 나누기 완료했다면
		if(cnt == result) {
			ArrayList<Integer> aList = new ArrayList<>(); // A선거구에 들어갈 구역
			ArrayList<Integer> bList = new ArrayList<>(); // B선거구에 들어갈 구역
			for(int i=1; i<=N; i++) {
				if(visited[i]) { // 뽑은 구역
					aList.add(i);
				}
				else {
					bList.add(i);
				}
			}
			
			// 나눴을 때, 2개의 그래프가 각각 서로 연결되어 있는지 확인 필요
			if(check(aList) && check(bList)) {
				int count1 = 0;
				int count2 = 0;
				for(int i=1;i<=N; i++) {
					if(aList.contains(i)) {
						count1 += people[i];
					}
					else {
						count2 += people[i];
					}
				}
				
				// 인구수의 차이가 이전 min보다 작다면 min 교체
				min = Math.min(min, Math.abs(count1-count2));
			}
			
			return;
		}
		
		if(idx == N+1) return;
		
		visited[idx] = true;
		comb(idx+1, cnt+1, result);
		visited[idx] = false;
		comb(idx+1, cnt, result);
	}
	
	// 각각의 그래프가 모두 연결된 그래프인지 판별
	static boolean check(ArrayList<Integer> list) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N+1]; //큐내에서 사용할 방문배열 초기화
		queue.add(list.get(0)); //리스트에 있는 첫번째 정점
		visit[list.get(0)] = true;
		
		int count = 1; // 인접하면서 방문 가능한 지역 개수
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int n: graph[now]) {
				// 인접한 지역이면서 방문하지 않았고, 리스트에 았는 지역이라면
				if(!visit[n] && list.contains(n)) {
					queue.add(n);
					visit[n] = true;
					count++;
				}
			}
		}
		
		if(count==list.size()) //선거구에 있는 지역이 모두 연결되어 있다면
			return true;
		else 
			return false;
	}
	
}