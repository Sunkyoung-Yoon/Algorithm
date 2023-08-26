import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 - 무료로 먹을 수 있는 초밥 번호
		
		int[] sushi = new int[N];
		int[] check = new int[d+1]; //초밥번호 1~d
		int max = 0; //먹을 수 있는 초밥의 가짓수 최댓값
		int cnt = 1; // 먹을 수 있는 초밥의 가짓수 (c에 해당하는 경우 미리 카운트)
		check[c]++; // c에 해당하는 초밥번호 미리 증가
		
		// 회전초밥 정보 저장
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		
		// 처음에 먹을 수 잇는 k개의 초밥 번호 확인
		for(int i=0; i<k; i++) {
			// 처음 먹는 초밥이라면(중복이 아니라면)
			if(check[sushi[i]] == 0)
				cnt++;
			check[sushi[i]]++;
		}
		
		
		for(int start=1; start<N; start++) {
			check[sushi[start-1]]--; // 이전에 먹은 맨 앞 초밥 제거
			
			// 제거한 뒤, 0이라면 이 초밥은 안 먹어본 초밥이 된다
			if(check[sushi[start-1]] == 0) {
				cnt--;
			}
			
			int end = (start+(k-1))%N;
			
			// 다음에 먹을 초밥이 0이라면, 새로 먹어볼 초밥이다
			if(check[sushi[end]]==0) {
				cnt++;
			}
			check[sushi[end]]++;
			
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}

}