import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //N개의 수
		int[] arr = new int[N];
		
		//N개의 정수 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine()); //M개의 수
		//M개의 수 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			//num이 배열에 있다면 1, 없다면 0 저장
			sb.append(binarySearch(arr,num)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	
    //너비우선탐색
	public static int binarySearch(int[] A, int find) {
		int start = 0;
		int end = A.length-1;
		int mid;
		
		while(start<=end) {
			mid = (start+end)/2;
			
			if(A[mid]<find) { //중간값보다 find가 크다면
				start = mid+1;
			}
			else if(A[mid]>find) { //중간값보다 find가 작다면
				end = mid-1;
			}
			//중간값==find라면
			else return 1;
		}
		
		//찾는 수가 없는 경우
		return 0;
	}
}