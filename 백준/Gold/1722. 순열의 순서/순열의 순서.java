import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long k; // 입력받은 찾아야 할 순열의 순번
	static int[] arr; // 입력받은 임의의 순열
	static long[] factorial; // 1!~n!까지 값 저장
	static boolean[] visited; // 중복 방지
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 수의 개수
		
		factorial = new long[N+1]; // 1!~n! 값 저장
		factorial[0] = 1;
		for(int i=1; i<=N; i++) {
			factorial[i] = factorial[i-1]*i; // ex) 2! -> 1!*2
		}
		
		st = new StringTokenizer(br.readLine());
		int problem = Integer.parseInt(st.nextToken()); // 소문제 번호 
		visited = new boolean[N+1];
		arr = new int[N+1];
		if(problem == 1) { // k번째 순열 구하기
			k = Long.parseLong(st.nextToken()); // k는 최대 20!
			one();
		}
		else if(problem == 2){ // 임의의 수열이 몇번째인지 구하기
			for(int i=1; i<=N; i++) { // 임의의 순열 입력
				arr[i] = Integer.parseInt(st.nextToken());
			}
			two();
		}
		
		System.out.println(sb);
	}
	
	// k번째 수열 구하기
	private static void one() {
		//System.out.println("1번 입장");

		for(int i=1; i<=N; i++) {
			//System.out.println(i+"번째 위치");
			for(int j=1; j<=N; j++) {
				//System.out.println("i: "+i+" j: "+j+"K: "+k);
				if(visited[j]) continue; // 이미 자리 배정이 끝난 숫자는 패스
				
				// 첫번째를 고를 때는 경우의수 n! , 두번째를 고를 때는 나머지 자리를 조합하는 경우의 수는 (n-1)!
				// -> i개 골랐다면 나머지 자리를 조합하는 경우의 수는 (n-i)!
				// 경우의 수보다 k가 크다면 k번째는 그 경우의 수를 지나고 나오는 애라는 뜻
				if(factorial[N-i]<k) {
					//System.out.println(factorial[N-i]+"빼기");
					k = k-factorial[N-i];
				}
				else {
					arr[i] = j; // i자리에 놓을 j 결정
					visited[j] = true; // j는 골랐으니 다시 선택안하도록 true
					break;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(arr[i]+" ");
		}
	}
	
	// 임의의 수열이 몇번째인지 구하기
	private static void two() {
		//System.out.println("2번 입장");

		k = 1; // 1번째부터 맞는지 확인
		for(int i=1; i<=N; i++) {
			// arr[i]에 있는 수를 가기전까지 가는 경우의 수를 더해줌 (arr[i]와 일치하는 수가 오기전까지의 경우의 수 더하는 과정)
			for(int j=1; j<arr[i]; j++) {
				if(visited[j]) continue; // 이미 자리 배정이 끝난 숫자는 패스
				
				k += factorial[N-i];
			}
			visited[arr[i]] = true;
		}
		sb.append(k);
	}
	
}