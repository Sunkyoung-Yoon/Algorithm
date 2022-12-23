import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[5];
		int sum=0;
		
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//오름차순 정렬
		Arrays.sort(arr);
		
		//모든 자연수의 합 구하기
		for(int i=0; i<5; i++) {
			sum+=arr[i];
		}
		
		System.out.println(sum/5); //평균
		System.out.println(arr[2]); //중앙값
	}
}