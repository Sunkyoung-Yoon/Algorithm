import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		//배열의 크기
		int N = Integer.parseInt(br.readLine()); 
		//구할 B의 인덱스
		int k = Integer.parseInt(br.readLine());
		
		long start = 1;
		//k번째 수는 k보다 클 수 없다. (중복된 값이 존재하기 때문)
		long end = k;
		long answer = 0;
		
		while(start<=end) {
			long mid = (start+end)/2;
			long count=0; //새로운 탐색시 개수 초기화
			
			//작거나 같은 수의 개수 구하기
			for(int i=1; i<=N; i++) {
				//개수가 N보다 클경우 N으로 변경
				count += Math.min(mid/i, N);
			}
			
			//count가 k보다 크다면 mid와 같거나 작은 범위에 정답 존재
			if(count>=k) {
				end = mid-1;
				answer = mid;
			}
			//count가 k보다 작다면 mid보다 큰 범위에 정답 존재
			else {
				start = mid+1;
			}
		}
		System.out.println(answer);
	}	
}