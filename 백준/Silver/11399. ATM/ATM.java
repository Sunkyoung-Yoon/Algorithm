import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N]; //사람마다 인출하는데 필요한 시간
		
		//배열에 숫자 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//오름차순 정렬
		Arrays.sort(arr);
		
		
		//각 사람이 인출할 때까지 걸리는 시간 = 이전 사람들이 소요한 시간+자기가 인출하는 시간
		int arr_sum = 0; 
		int sum = 0; //인출하는 데 걸리는 시간 합
		for(int i=0; i<N; i++) {
			arr_sum += arr[i];
			sum += arr_sum;
		}
		
		System.out.println(sum);
	
	}
	
}
