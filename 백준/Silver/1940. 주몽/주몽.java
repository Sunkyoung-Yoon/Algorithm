import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		//재료들 고유 번호 저장
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int start = 0; //시작포인터 - 작은 값 인덱스
		int end = N-1; //종료포인터 - 큰 값 인덱스
		int count = 0;
		
		while(start<end) { //양쪽 포인터가 좁혀지다가 같아지기전까지 반복
			int sum = arr[start]+arr[end];
			if(sum>M) { //sum이 크다면 종료포인터를 왼쪽으로 이동
				end--;
			}
			else if(sum<M) { //sum이 작다면 시작포인터를 오른쪽으로 이동
				start++;
			}
			else { //sum==M이면 count증가 시작포인터와 종료포인터 모두 이동
				count++;
				end--;
				start++;
			}
		}
		
		System.out.println(count);
	}
}