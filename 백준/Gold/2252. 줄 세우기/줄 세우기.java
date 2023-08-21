import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static LinkedList<Integer>[] list;
	static int[] degree; // 차수를 저장할 배열
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     
	     N = Integer.parseInt(st.nextToken()); // 학생의 수
	     M = Integer.parseInt(st.nextToken()); // 비교 횟수
	     
	     degree = new int[N+1]; // 번호는 1~n까지
	     list = new LinkedList[N+1]; // 번호는 1~n까지
	     for(int i=1; i<=N; i++) {
	    	 list[i] = new LinkedList<>();
	     }
	     
	     for(int i=0; i<M; i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 
	    	 int A = Integer.parseInt(st.nextToken());
	    	 int B = Integer.parseInt(st.nextToken());
	    	 
	    	 list[A].add(B); // A다음에 B
	    	 degree[B]++; // B이전에 A가 수행되어야 한다는 의미 -> B의 차수 +1
	     }
	     
	     Sort();
	     System.out.println(sb); //줄 세운 결과 출력

	}
	
	static void Sort() {
		Queue<Integer> queue = new LinkedList<>();
		
		
		for(int i=1; i<=N; i++) {
			// 차수가 0인 노드라면(= 먼저 수행되어야 할 노드가 없다면)
			if(degree[i] == 0)
				queue.add(i); //if문에 해당하는 노드 큐에 다 넣기
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			sb.append(now).append(" ");
			for(int n: list[now]) {
				degree[n]--; //now와 인접한 노드의 차수-1
				if(degree[n] == 0) //차수가 0이 되었다면
					queue.add(n);
			}
		}
	}
}