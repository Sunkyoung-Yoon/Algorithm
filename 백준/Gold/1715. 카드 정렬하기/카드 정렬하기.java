import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		//카드묶음 개수
		int N = Integer.parseInt(br.readLine()); 
		//우선순위큐 기본정렬기준 오름차순
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			//카드묶음 크기
			int size = Integer.parseInt(br.readLine());
			queue.add(size);
		}
		
		int result = 0; //최소 비교 횟수
		
		//카드묶음이 1개 될 때까지 반복 
		while(queue.size()!=1) {
			//제일 작은 묶음 2개 우선순위큐에서 꺼냄
			int card1 = queue.poll();
			int card2 = queue.poll();
			
			//합친묶음 result에 더하고 우선순위큐에 삽입
			result += card1 + card2;
			queue.add(card1+card2);
		}
		System.out.println(result);
	}	
}