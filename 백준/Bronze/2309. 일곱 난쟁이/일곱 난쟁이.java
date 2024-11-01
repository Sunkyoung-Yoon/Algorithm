import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int sum = 0;
		int[] arr = new int[9];
		// 일곱 난쟁이 키 후보 저장
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				result = sum - arr[i] - arr[j];
				
				// arr[i]와 arr[j]는 일곱난쟁이에 포함x
				if(result == 100) {
					num1 = arr[i];
					num2 = arr[j];
					break;
				}
			}
			// 가능한 정답 아무거나 출력 -> 하나 나오면 반복문 종료
			if(result == 100)
				break;
		}
		
		for(int i=0; i<9; i++) {
			if(arr[i] == num1 || arr[i] == num2)
				continue;
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}

}