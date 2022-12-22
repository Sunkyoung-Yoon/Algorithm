import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] A = new int[9][9];
		int max=0;
		int a=0;
		int b=0;
		
		//행렬 A 2차원배열에 저장
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
				//max보다 크거나 같다면
                //최댓값이 2개이상일 경우 그 중에 하나의 행,열만 알아도 되기 때문
				if(max<=A[i][j]) {
					max=A[i][j];
					//행과 열이 1부터 시작하기 때문에 +1
					a=i+1;
					b=j+1;
				}
				
			}
		}
		
		System.out.println(max);
		System.out.println(a+" "+b);
		
	}
}