import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트 개수
		
		int[][] arr = new int[15][15];
		
		for(int i=1; i<15; i++) { //0층 1호부터
			arr[0][i] = i;
		}
		
		for(int i=1; i<15; i++) {
			for(int j=1; j<15; j++) { //해당 칸의 왼쪽과 아래의 합을 저장
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		
		for(int t=0; t<T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(arr[k][n]);
		}
		
	}
}