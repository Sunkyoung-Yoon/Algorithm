import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] score = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		//오름차순 정렬
		Arrays.sort(score);
		
		System.out.println(score[score.length-k]); //커트라인
	}
}