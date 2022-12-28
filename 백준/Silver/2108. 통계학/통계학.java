import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] counting_arr = new int[8001]; //-4000 ~ 4000
		double sum =0.0;
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			counting_arr[n+4000]++;
			arr[i]=n;
			sum+=n;
		}
		Arrays.sort(arr);
		
		int max = 0; //최대등장횟수
		int count = 0; //max 개수 
		int mode = 0; //최빈값
		for(int i=0; i<8001; i++) {
			if(counting_arr[i]!=0) {
				max = Math.max(max, counting_arr[i]);
			}
		}
		
		for(int i=0; i<8001; i++) {
			//max만큼 등장항 i 최빈값에 저장
			if(max==counting_arr[i]) {
				mode = i-4000;
				count++;
			}
			//같은 횟수가 2번이상 나오면 두번째로
			if(count==2) { 
				//크기순으로 돌기 때문에 두번째로 나온 i가 두번째로 작은 값
				// 2,2 3,3 ->최빈값 3
				// -5,-5 -1,-1 0,0 ->최빈값 -1
				mode = i-4000;
				break;
			}
			
		}
		
		sb.append(Math.round(sum/N)+"\n"); //산술평균
		sb.append(arr[N/2]+"\n"); //중앙값
		sb.append(mode+"\n"); //최빈값
		sb.append(arr[arr.length-1]-arr[0]+"\n"); //범위
		
		
		System.out.print(sb);
		
	}
}