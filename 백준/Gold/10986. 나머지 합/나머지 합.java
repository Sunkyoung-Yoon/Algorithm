import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] S = new long[N+1]; //합배열
		long[] count = new long[M]; //나머지별 등장 횟수  
		long result = 0; //M으로 나누어 떨어지는 합 구간
		
		
		//합 배열 저장
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			S[i] = S[i-1]+Long.parseLong(st.nextToken());
			
			//배열 S1 값을 M으로 나눈 나머지 확인
			if(S[i]%M==0) //나누어 떨어지는 구간
				result++;
			
			count[(int)(S[i]%M)]++; //나머지별 등장 횟수 카운트
		}

		
		//(S[j]-S[i])%M==0이 되는 구간(i,j) 찾기
		//같은 나머지가 나오는 구간들 중 2개 뽑는 경우의 수
		for(int i=0; i<M; i++) { 
			if(count[i]>1)
				result += count[i]*(count[i]-1)/2;
		}
		
		System.out.println(result);
		
	}
}