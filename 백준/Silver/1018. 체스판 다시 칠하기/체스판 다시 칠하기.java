import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];
		
		//MxN 크기 보드 저장
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		System.out.println(chess(board, N, M));
	}
	
	//8x8크기 체스판 중 다시 칠하는 횟수가 최소인 경우 찾는 함수
	public static int chess(char[][] chess, int n, int m) {
		int min = 64; //칠하는 횟수는 최대 64
		
		//8x8로 나누기
		for(int i=0; i<n-8+1; i++) {
			for(int j=0; j<m-8+1; j++) {
				
				int count = 0; //나눈 체스판의 칠할 횟수
				char check = chess[i][j]; //시작 색깔
				
				//체스판 시작점으로부터 8x8 크기 탐색
				for(int k=0; k<8; k++) {
					for(int p=0; p<8; p++) {
						//check와 다르다면 바꿔야하는 색이므로 count증가
						if(chess[i+k][j+p]!=check) {
							count++;
						}
						
						//check 색 변경 W->B B->W
						if(check=='W') {
							check='B';
						}
						else {
							check='W';
						}
					}
					
					//다음줄이 될 때는 이전 줄의 끝과 다음 줄의 시작이 같아야함
					if(check=='W') {
						check='B';
					}
					else {
						check='W';
					}
				}
				
				//8x8 체크판 변경횟수가 최솟값이라면 min 변경
				//체스판의 맨 처음 시작 색이 반대일 경우도 고려해서 최소 count 저장
				count = Math.min(count, 64-count);
				min = Math.min(min, count);
				
			}
		}
		
		return min;
	}
}