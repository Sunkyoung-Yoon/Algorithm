import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		int sum=0;
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//색종이가 차지하는 부분인 곳에 배열값을 1로 변경
			for(int i=a; i<a+10; i++) {
				for(int j=b; j<b+10; j++) {
					//이미 1인 경우 다음으로 넘어감
					if(paper[i][j]==1)
						continue;
					paper[i][j]=1;
					//새로 1이 되는 부분 생길때마다 sum +1
					sum+=1;
				}
			}
		}
		
		System.out.println(sum);
		
	}
}