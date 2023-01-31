import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //수열의 개수
		int[] arr = new int[N];
		Stack<Integer> stack = new Stack<>();
		
		//수열 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<N; i++) { 			
			/*
			스택이 비어있지 않고
			arr[현재 스택 top에 있는 수] < arr[push할 수]라면
			*/
			while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
				//arr[stack.peek()]의 오큰수는 arr[i]
				arr[stack.pop()] = arr[i];
			}
			
			stack.push(i);
			
		}
		
		//현재 스택에 있는 수들은 모두 오큰수가 없는 수
		//스택에 있는 배열인덱스 값에 -1 저장
		while(!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i]+" ");
		}
		
		System.out.println(sb);
		
	}
}
