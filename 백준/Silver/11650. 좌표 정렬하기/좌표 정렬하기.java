import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		//x,y 저장
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//정렬
		//return 값이 양수면 자리변경 음수면 그대로
		Arrays.sort(arr, (arr1, arr2) ->{
			if(arr1[0] == arr2[0]) {
				//arr1[1]- arr2[1]이 양수라면(=arr1[1]이 크다면) 자리 바꾸기
				return arr1[1]- arr2[1];
			}
			else {
				//e1[0]이 크다면 자리 바꾸기
				return arr1[0] - arr2[0];
			}
		});
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i][0]+" "+arr[i][1]).append("\n");
		}
		
		System.out.print(sb);
		
	}
}