import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; //숫자를 저장할 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//중간값 찾기 위해 정렬
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			sb.append(binarySearch(arr, num)+" ");
		}
		
		System.out.println(sb);
		
	}
	//N개의 카드 중에 있는 숫자인지 판별
	public static int binarySearch(int[] A, int m) {
		int start = 0;
		int end = A.length-1;
		int mid = 0;
		
		while(start<=end) {
			mid = (start+end)/2;
			
			if(A[mid]<m) { //중간값보다 m이 크다면
				start = mid+1;
			}
			else if(A[mid]>m) { //중간값보다 m이 작다면
				end = mid-1;
			}
			else //중간값과 m이 같다면
				return 1;
		}
		//m이 없는 경우
		return 0;		
	}
}