import java.io.*;
import java.util.*;

public class Main {
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		//하노이의 탑 이동 횟수 2^n-1
		sb.append((int)(Math.pow(2, N))-1).append("\n");
		
		hanoi(N,1,2,3);
		
		System.out.print(sb);
	}	
	
	
	//from:1번 장대, mid:2번 장대, to:3번 장대
	public static void hanoi(int n, int from, int mid, int to) {
		if(n==1) { //이동할 원판이 1개남은 경우 (최소단위)
			sb.append(from+" "+to+"\n");
			return;
		}
		else { 
			//STEP 1: n-1개를 1->2 이동
			hanoi(n-1,from,to,mid);
			
			
			//n-1개를 B로 옮긴 뒤, 큰 원판 3으로 이동
			//STEP 2: 1->3 이동
			sb.append(from+" "+to+"\n");
			
			
			//큰 원판위로 나머지 원판 올리기
			//STEP 3: n-1개를 2->3 이동
			hanoi(n-1,mid,from,to);
			
		}	
	}	
}