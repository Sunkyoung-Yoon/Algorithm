import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int[] arr = new int[9];
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		
		
		int num1 = 0;
		int num2 = 0;
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				int result = sum - arr[i] - arr[j];
				
				if(result == 100) {
					num1 = arr[i];
					num2 = arr[j];
				}
			}
		}
		
		// 진짜 일곱 난쟁이만 출력
		for(int i=0; i<9; i++) {
			if(arr[i] == num1 || arr[i] == num2) continue;
			System.out.println(arr[i]);
		}
		
		sc.close();
	}

}