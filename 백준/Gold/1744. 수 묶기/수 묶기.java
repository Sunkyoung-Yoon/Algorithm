import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		//수열의 크기
		int N = Integer.parseInt(br.readLine()); 
		//우선순위큐 plus는 내림차순, minus는 오름차순
		PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minus = new PriorityQueue<>();
		int one_count =0;
		int zero_count = 0;
		int sum = 0; //최대 합
		
		//수열 우선순위 큐에 저장 - 양수,음수,1,0구분
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num>1) plus.add(num);
			else if(num==1) one_count++;
			else if(num==0) zero_count++;
			else minus.add(num);
		}
		
		
		//1개이하로 남을 때까지 반복
		while(plus.size()>1) {
			//우선순위큐에서 가장 큰 수 2개 꺼낸다.
			int num1 = plus.poll();
			int num2 = plus.poll();
			
			//두 수의 곱 sum에 더한다.
			sum += num1 * num2;
		}
		
		//하나남았다면 다른 수와 곱하지 않고 더한다.
		if(plus.size()==1) sum += plus.poll();
		
		//1개수 만큼 더한다. 
		sum += one_count;
		
		
		//1개이하로 남을 때까지 반복
		while(minus.size()>1) {
			//우선순위큐에서 가장 작은 수 2개 꺼낸다.
			int num1 = minus.poll();
			int num2 = minus.poll();
					
			//두 수의 곱 sum에 더한다.
			sum += num1 * num2;
		}
		
		//0이 없는데, minus에 음수값이 존재한다면 음수를 더한다.
		//0이 있다면 0을 곱해서 0으로 바꿀수 있음
		if(minus.size()==1 && zero_count==0) {
			sum += minus.poll();
		}
		
	
		System.out.println(sum);
	}	
}
