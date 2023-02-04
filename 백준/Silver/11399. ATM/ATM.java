import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N]; //사람마다 인출하는데 필요한 시간
		int[] S = new int[N]; //각 차례별로 인출하는데 걸리는 시간
		
		
		//배열에 숫자 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//삽입정렬
		for(int i=1; i<N; i++) { //두번째 값부터 위치찾기
			int temp = arr[i]; //위치찾을 값 저장
			int prev = i-1; //바로 이전 인덱스
			
			//prev가 0이 되거나 temp가 크기 전까지 반복
			while(prev>=0 && arr[prev]>temp) {
				arr[prev+1] = arr[prev];//한칸씩 뒤로 이동
				prev--;
			}
			
			//temp가 크다면 arr[prev] < temp가 되므로
			//prev다음인 arr[prev+1] -> temp의 위치
			arr[prev+1] = temp; //삽입 위치에 삽입값 저장
		}
		
		S[0] = arr[0];
		int sum = S[0]; //모두 인출하는데 걸리는 시간
		//자기 차례에 인출할 때까지 걸리는 시간 = 이전 사람들이 소요한 시간+자기가 인출하는 시간
		for(int i=1; i<N; i++) {
			S[i] = S[i-1] + arr[i];
			sum += S[i];
		}
		
		System.out.println(sum);
	}
	
}
