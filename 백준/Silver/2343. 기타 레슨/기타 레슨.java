import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //강의의 수
		int M = Integer.parseInt(st.nextToken()); //블루레이 개수
		int[] arr = new int[N];
		
		//강의 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		for(int i=0; i<N; i++) {
			//강의 중 제일 큰 길이 - 하나일때, 가장 큰 값
			start = Math.max(start, arr[i]);
			//모든 강의 시간의 합
			end += arr[i];
		}
		
		while(start <= end) {
			int mid = (start+end)/2;
			int sum = 0;
			int count = 0; //사용된 블루레이 개수
			
			//강의 sum에 더하기
			for(int i=0; i<N; i++) {
				//강의의 길이 합이 mid보다 커지면
				if(sum+arr[i]>mid) {
					//새로운 블루레이 저장하기 위해 sum 0으로 초기화
					sum = 0;
					//블루레이 개수 ++
					count++;
				}
				//새로 담을 블루레이에 arr[i] 강의 추가
				sum += arr[i];
			}
			
			//0이 아니라면 남은 강의가 존재하므로 count증가
			if(sum!=0) count++;
			
			//블루레이 개수가 M보다 작거나 같다면 mid 줄이기
			//M 개수내로 가능한 블루레이의 크기 중 최소를 구하기 위해
			if(count<=M) end = mid-1;
			
			//블루레이 개수가 M보다 크다면 mid 늘리기
			//M 개수로 강의를 다 담을 수 없기 때문
			else start = mid+1;
		}
		
		//while문 종료후 start가 가능한 블루레이의 최소 크기가 된다.
		System.out.println(start);
	}
}