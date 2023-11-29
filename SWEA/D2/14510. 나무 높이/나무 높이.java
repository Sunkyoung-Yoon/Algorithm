import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			int N = Integer.parseInt(br.readLine()); // 나무의 개수
			int[] trees = new int[N];
			int maxTree = 0;
			int minDays = 0;
			
			// 각 나무의 크기 저장 및 큰 나무 크기 체크
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxTree = Math.max(maxTree, trees[i]);
			}
			
			// 최대 크기 나무에서 원래 크기로 빼면 커야 하는 길이
			for(int i=0; i<N; i++) {
				trees[i] = maxTree - trees[i];
			}
			
			// 나무들이 자랴야 할 때 필요한 짝수 일수와 홀수 일수
			int odd = 0;
			int even = 0;
			for(int i=0; i<N; i++) {
				odd += trees[i]%2; // 홀수 일수
				even += trees[i]/2; // 짝수 일수
			}
			
			// 날짜간의 균형을 맞추기 위한 작업
			int temp = Math.max(even-odd, 0)/3;
			odd += temp*2;
			even -= temp;
			
			// 추가적으로 공부 필요한 부분
			int oddEvenMin = Math.min(odd, even);
			minDays = oddEvenMin*2 + Math.max((odd - oddEvenMin)*2 -1, 0) 
			+ (even - oddEvenMin) / 2 * 3 
			+ (even - oddEvenMin) % 2 * 2;
			
			sb.append("#"+tc+" "+minDays).append('\n');
			
		} // 테스트케이스 종료
		
		System.out.println(sb);
	}

}