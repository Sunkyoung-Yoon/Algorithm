import java.io.*;
import java.util.*;

public class Main {
	static int[] check;
	static HashMap<Character,Integer> map;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //수 개수
		int L = Integer.parseInt(st.nextToken()); //최솟값을 찾을 구간길이 
		int[] arr = new int[N]; 
		Deque<Integer> deque = new ArrayDeque<>();
		
		//N개의 수 배열arr에 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//덱에 수 저장
		for(int i=0; i<N; i++) {
			
			//덱에 맨 뒤에 있는 수가 arr[i]보다 크다면 맨 뒤 데이터 제거
			//정렬한 것과 같은 효과를 위해 최솟값이 될 수 없는 수를 제거
			//덱에는 크기순으로 남게 됨
			while(!deque.isEmpty() && arr[deque.getLast()]>arr[i]) {
				deque.removeLast();
			}
			
			//맨 뒤에 i 삽입 (배열 arr의 인덱스를 삽입)
			deque.addLast(i);
			
			//인덱스가 L크기를 벗어난 범위라면 맨앞 데이터 제거
			if(!deque.isEmpty() && deque.getFirst()<=i-L) {
				deque.removeFirst();
			}
			
			//현재 덱의 첫번째 데이터(최솟값)를 sb에 저장
			sb.append(arr[deque.getFirst()]+" ");
		}
		
		System.out.println(sb);
		
	}
}
