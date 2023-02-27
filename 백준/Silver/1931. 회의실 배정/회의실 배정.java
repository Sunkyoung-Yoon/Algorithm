import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		
		int N = Integer.parseInt(br.readLine());//회의의 수
		int count = 0; //회의의 최대 수
		//회의 시작시간과 종료시간을 저장할 배열
		int[][] arr = new int[N][2];
		
		//회의 시작시간과 종료시간 저장
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//종료시간이 같다면 시작시간이 더 빠른 쪽이 먼저, 다르다면 종료시간이 빠른쪽이 먼저
		Arrays.sort(arr, (int[] a1, int[] a2) -> a1[1]==a2[1]?a1[0]-a2[0]:a1[1]-a2[1]);
		
		int end = 0; //처음종료시간 0으로 초기화
		for(int i=0; i<N; i++) {
			//이전 회의 끝나는 시간 이후에 회의 시작시간이 있는 경우
			if(arr[i][0] >= end) {
				end = arr[i][1];
				count++;
			}
			
		}
		
		System.out.println(count);
		
	}	
}