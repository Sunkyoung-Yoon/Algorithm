import java.util.*;
import java.io.*;

public class Main {
	static int[][] sudoku;
	static ArrayList<Point> zeroList;
	static StringBuilder sb;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		sudoku = new int[9][9];
		zeroList = new ArrayList<>();
		for(int i=0; i<9; i++) {
			String s = br.readLine();
			for(int j=0; j<9; j++) {
				sudoku[i][j] = s.charAt(j)-'0';
				
				if(sudoku[i][j] == 0) {
					zeroList.add(new Point(i, j));
				}
			}
		}
		
		flag = false;
		sudoku(0);
		
		System.out.println(sb);
	}
	
	// 스도쿠 채우기
	static void sudoku(int idx) {
		// 0인 곳을 모두 돌아봤다면
		if(idx == zeroList.size()) {
			// 한번 다 채웠으면 다른 경우는 안봐도 됨
			// 1부터 채우기 때문에 가장 처음에 완료된게 사전순으로 앞에 있음
			flag = true; 
			print();
			return;
		}
		
		Point now = zeroList.get(idx); // 현재 채워넣을 칸
		for(int i=1; i<=9; i++) { // 스도쿠 채워 넣을 값은 1~9
			sudoku[now.i][now.j] = i; // 칸 채우기
			
			// 넣기 가능인지 체크
			if(checkRow(now.i, now.j) && checkCol(now.i, now.j)
					&& checkGrid(now.i, now.j)) {
				sudoku(idx+1); // 가능하다면 다음 칸 채우기 진행
			}
			
			// 위에서 스도쿠를 다 채우고 결과가 한번  true되면 이후는 모두 종료
			if(flag) return;
			
			sudoku[now.i][now.j] = 0; // 불가능하다면 0으로 다시 변경하고 다음 i로 채우기 진행
			
		}
	}

	// 행 검사
	static boolean checkRow(int r, int c) {
		
		for(int j=0; j<9; j++) {
			if(j == c) continue;
			
			// 뽑은 수가 이미 채워넣은 수라면
			if(sudoku[r][j] == sudoku[r][c]) {
				return false;
			}
		}
		
		return true;
	}
	
	// 열 검사
	static boolean checkCol(int r, int c) {
		for(int i=0; i<9; i++) {
			if(i == r) continue;
			
			// 뽑은 수가 이미 채워넣은 수라면
			if(sudoku[i][c] == sudoku[r][c]) {
				return false;
			}
		}
		
		return true;
	}

	// 3x3 격자 검사
	static boolean checkGrid(int r, int c) {
		int startr = r/3*3; // 인덱스는 0부터
		int startc = c/3*3;
		
		
		for(int i=startr; i<startr+3; i++) {
			for(int j=startc; j<startc+3; j++) {
				if(i == r && j == c) continue;
				
				// 뽑은 수가 이미 채워넣은 수라면
				if(sudoku[i][j] == sudoku[r][c]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void print() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}
	
	static class Point{
		int i;
		int j;
		
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
}