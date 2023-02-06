import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); //K번째 수
		
		int[] arr = new int[N]; 
		
		//배열에 숫자 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//퀵 정렬
		quick_sort(arr,0,arr.length-1);
		
		//배열인덱스는 0부터이므로 K-1
		System.out.println(arr[K-1]);
	
	}
	
	
	public static void quick_sort(int A[], int start, int end) {
		if(start>=end) return; //start==end가 되면 종료
		
		//부분배열 정렬 종료시 start가 part가 됨
		int part = partition(A, start, end);
		
		quick_sort(A, start, part-1); //왼쪽 영역
		quick_sort(A, part, end); //오른쪽 영역
	}
	
	
	public static int partition(int A[], int start, int end) {
		
		int pivot = A[(start+end)/2]; //기준값 피벗
		
		while(start<=end) { //start==end가 되면 부분 배열 정렬 종료
			while(A[start]<pivot) start++;
			while(pivot<A[end]) end--;
			
			if(start<=end) {
				int temp = A[start];
				A[start] = A[end];
				A[end] = temp;
				start++;
				end--;
			}
		}
		
		return start; //start가 새로운 part가 됨
	}
	
}
