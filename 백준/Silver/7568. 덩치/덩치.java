import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //사람의 수
		int[][] person = new int[N][2];
		
		StringTokenizer st;
		//몸무게와 키 배열에 저장
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); //몸무게
			int y = Integer.parseInt(st.nextToken()); //키
			person[i][0] = x;
			person[i][1] = y;
		}
		
		for(int i=0; i<N; i++) {
			sb.append(rankSearch(person, i)+" ");
		}
		System.out.println(sb);
		
	}
	
	public static int rankSearch(int[][] person, int x) {
		int rank = 0; //등수
		
		for(int i=0; i<person.length; i++) {
			if(i==x) //자신의 덩치는 비교x
				continue;
			//자신보다 덩치가 큰 사람이 있다면
			if(person[i][0]>person[x][0] && person[i][1]>person[x][1])
				rank++;
			
		}
		
		return rank+1;
	}

}