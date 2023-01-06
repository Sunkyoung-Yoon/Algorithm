import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); 
		char[][] board = new char[N][M];
		String str = null;
		
		
		//보드 색깔 배열에 저장
		for(int i=0; i<N; i++) {
			str=br.readLine(); //한 줄 저장 
			for(int j=0; j<M; j++) {
				board[i][j] = str.charAt(j); //한글자씩 끊어서 저장
			}
		}
		
		System.out.println(chess(board, N, M));
		
	}
	
	//다시 칠할 정사각형의 수 최솟값 구하는 함수
	public static int chess(char[][] chess, int n, int m) {
		
		int result = 0;
		int min = 64;
		
		//8x8으로 나누기
		for(int i=0; i<n-8+1; i++) {
			for(int j=0; j<m-8+1; j++) {
				
				//8x8 체스판 확인
				int count = 0;
				char check = chess[i][j]; //첫 시작 색깔
				
				for(int k=0; k<8; k++) {
					for(int p=0; p<8; p++) {
						
						//check와 다르면 색변경 필요 
						if(chess[i+k][j+p]!=check) {
							count++;
						}
						
						//check 변경, 다음에는 다른 색이 와야함
						if(check=='W')
							check='B';
						else
							check='W';
							
					}
					//check 변경, 다음줄 처음에는 현재줄 맨끝과 같은색이 와야함
					if(check=='W')
						check='B';
					else
						check='W';
				}
			
				count = Math.min(count, 64-count); //8x8 체스판 시작색에 맞춰서 구한 값과 시작색을 바꿔서 칠할 때 값 비교
				min = Math.min(min, count); //다시 칠할 정사각형의 수 최솟값 확인
				result = min; //최솟값 저장
				
			}
		}
		
		return result;
	}

}