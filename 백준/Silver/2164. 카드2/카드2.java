import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //카드 개수
		int[] arr = new int[N];
		Queue<Integer> queue = new LinkedList<>();
		
		//큐에 카드 저장
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		while(queue.size()>1) {
			queue.poll(); //제일 앞에 있는 카드 제거
			//현재 맨앞에 있는 카드를 제거하고 그 카드를 맨뒤에 추가
			queue.add(queue.remove()); 
		}
		
		System.out.println(queue.peek());
		
	}
}
