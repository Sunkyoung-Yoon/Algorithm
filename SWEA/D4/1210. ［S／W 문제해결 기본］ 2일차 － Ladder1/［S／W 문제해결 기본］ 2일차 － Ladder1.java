
import java.util.*;
import java.io.FileInputStream;
import java.io.*;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution {
	static int[][] board = new int[100][100]; // 사다리를 저장할 배열
	static boolean[][] visited; //방문을 체크할 배열
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=0; t<10; t++) {
			int tc = Integer.parseInt(br.readLine()); // 테스트케이스 번호
			
			// 사다리 저장
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[100][100];
			for(int i=0; i<100; i++) {
				if(board[99][i] == 2) {
					System.out.println("#"+tc+" "+result(99,i));
				}
			}			
		}
	}
	
	// 2에 도달하는 사다리 찾기
	static int result(int r, int c) {
		if(r == 0) {
			return c;
		}
		
		// 오른쪽으로 갈 수 있는 경우
		if((c+1 <= 99) && board[r][c+1] == 1 && visited[r][c+1] == false) {
			visited[r][c+1] = true;
			return result(r, c+1);
			
		}
		else if((c-1 >= 0) && board[r][c-1] == 1 && visited[r][c-1] == false) { //왼쪽으로 갈 수 있는 경우
			visited[r][c-1] = true;

			return result(r, c-1);
		}
		
		visited[r-1][c] = true;
		return result(r-1, c);
		
	}

}