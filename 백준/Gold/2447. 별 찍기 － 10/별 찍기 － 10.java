import java.io.*;
import java.util.*;
public class Main {
	static String[][] arr;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		arr = new String[N][N];
		
		star(0,0,N);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//*인 부분은 배열의 값 저장
				if(arr[i][j]!=null)
					sb.append(arr[i][j]);
				//빈 부분은 공백으로 저장
				else
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}	
	
	public static void star(int x, int y, int n) {
		//최소단위(1)로 분할
		if(n==1) {
			arr[x][y] = "*";
			return;
		}
		
		//n/3을 size로 변경
		int size = n/3;
		//최소단위가 될 때까지 3x3크기로 계속해서 분할
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(!(i==1 && j==1)){ //공백칸(1,1)이 아닌 경우
					star(x+i*size, y+j*size, size);
				}
			}
		}
		
	}
	
}