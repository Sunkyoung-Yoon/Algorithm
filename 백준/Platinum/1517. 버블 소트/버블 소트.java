import java.io.*;
import java.util.*;

public class Main {
	public static long[] tmp; //합병한 결과를 담을 배열
	public static long count; //swap 횟수
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long[] arr = new long[N]; 
		tmp = new long[N];
		
		//배열에 숫자 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(arr,0,arr.length-1);
		System.out.println(count);
	}
	
	
	//길이가 1이 될 때까지 분할
	public static void merge_sort(long A[], int start, int end) {
		
		if(start < end) { //start==end가 되면 종료
			//start와 end의 중간지점
			int mid = (start + end)/2;
			
			merge_sort(A,start, mid); //mid를 기준으로 왼쪽 분할(mid 포함)
			merge_sort(A,mid+1,end); //mid를 기준으로 오른쪽 분할
			merge(A, start, mid, end); //정렬 및 합병
		}

	}
	
	//A[start..mid]와 A[mid+1..end] 합병
	public static void merge(long A[], int start, int mid, int end) {
		
		int i = start;
		int j = mid+1;
		int t = 0; 
		
		//배열 A에서 비교하고 작은 쪽 tmp에 저장
		while(i<=mid && j<=end) {
			
			//i번째 인덱스 값을 tmp에 저장하고 다음 t,i로 넘어감
			if(A[i] <= A[j]) tmp[t++] = A[i++];
			
			//j번째 인덱스 값을 tmp에 저장하고 다음 t,j로 넘어감
			//왼쪽이 오른쪽보다 큰 경우의 수는 버블정렬 swap 횟수
			/*
			예를 들어 왼쪽영역 3,4 오른쪽영역 1,2라면
			1이 들어갈 때, 왼쪽 남아있는 큰 수의 개수는 2개 
			버블정렬로 생각해보면 1이 앞으로 가기 위해서는 교환이 2번 이루어진다.
			즉, 왼쪽이 클 때, 왼쪽에 남아있는 큰 수의 개수가 버블정렬 교환횟수가 된다.
			*/
			else {
				tmp[t++] = A[j++];
				count+= mid-i+1;
			}
		}
		
		//왼쪽 배열에 값이 남은 경우
		while(i<=mid) tmp[t++] = A[i++];
		//오른쪽 배열에 값이 남은 경우
		while(j<=end) tmp[t++] = A[j++];
		
		//tmp에 저장한 결과 A[start..end]에 저장
		i=start; 
		t=0;
		while(i<=end) A[i++] = tmp[t++];
		
	}
	
}
