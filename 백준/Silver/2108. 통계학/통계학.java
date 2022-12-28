import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] counting_arr = new int[8001]; //-4000 ~ 4000
		double sum =0.0;
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			counting_arr[n+4000]++;
			sum+=n;
		}
		
		
		
		int max = 0; //최대등장횟수
		boolean max_flag = false; //max 개수가 2개이상인지 판별 
		int mode = 0; //최빈값
		
		int median_count = 0;//중앙값 위치확인할 변수
		int median = 0; //중앙값
		
		int max_range = -4001; //최댓값
		int min_range = 4001; //최솟값
		
		
		for(int i=0; i<8001; i++) {
			if(counting_arr[i]==0)
				continue;
			
			//중앙값에 해당하는 범위가 될 때 마지막으로 median변경
			if(median_count<N/2+1) {
				median_count+=counting_arr[i];
				median=i-4000;
			}
			if(max<counting_arr[i]) {
				max=counting_arr[i];
				mode = i-4000;
				max_flag=true;
			}
			//max와 같은 등장횟수 2번째 등장
			//더 큰 max가 등장하지 않으면 두번째 작은 값이 최빈값에 저장됨
			//2,2 3,3 4,4인 경우 숫자 4일 때 max가 변경되지 않기 때문에 mode=3이다.
			else if(max_flag==true && max==counting_arr[i]) {
				mode = i-4000;
				max_flag=false;
			}
			//범위 확인을 위한 min, max 저장
			max_range=Math.max(max_range, i-4000);
			min_range=Math.min(min_range, i-4000);
		}
		
		sb.append(Math.round(sum/N)+"\n"); //산술평균
		sb.append(median+"\n"); //중앙값
		sb.append(mode+"\n"); //최빈값
		sb.append(max_range - min_range+"\n"); //범위
		
		
		System.out.print(sb);
		
	}
}