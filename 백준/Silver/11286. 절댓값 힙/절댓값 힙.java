import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine()); //연산의 개수
		
		//우선순위 큐 생성 및 정렬기준 재정의
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> {
			
			//절댓값이 같다면 더 작은 수가 앞으로
			if(Math.abs(o1)==Math.abs(o2)) return o1>o2?1:-1;
			
			//다르다면 절댓값 기준으로 오름차순 정렬
			else return Math.abs(o1)-Math.abs(o2);
		});
		
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				//큐가 비어있다면 맨 앞 제거
				if(!queue.isEmpty()) sb.append(queue.poll()+"\n");
				else sb.append("0\n");
			}
            //큐에 x삽입
			else queue.offer(x);
		}
		
		System.out.println(sb);
		
	}
}
