import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // n개의 대학
		PriorityQueue<Schedule> pq = new PriorityQueue<>((o1, o2) ->{
			// 페이가 같다면 가야하는 기간이 짧은게 먼저
			if(o1.p == o2.p) return o1.d - o2.d;
			// 패이가 큰쪽이 우선순위
			else return o2.p - o1.p;
		});
		
		// 대학에서 제시한 p: 돈, d: 일
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			
			pq.add(new Schedule(pay, day));
		}
		
		int result = 0; //최대 벌 수 있는 돈
		boolean[] check = new boolean[10001]; // 강연하는 날 체크
		
		// 큐에서 하나씩 꺼내면서 강연가능한지 체크
		while(!pq.isEmpty()) {
			Schedule now = pq.poll();
			
			// d일안에 강연해야하니 d일부터 하나씩 줄여가면 강연 가능한 날 체크
			for(int i=now.d; i>0; i--) {
				// 강연 가능하다면
				if(!check[i]) {
					check[i] = true;
					result += now.p;
					break;
				}
			}
		}
		
		System.out.println(result);
	}

	static class Schedule{
		int p;
		int d;
		public Schedule(int p, int d) {
			super();
			this.p = p;
			this.d = d;
		}
	}
}