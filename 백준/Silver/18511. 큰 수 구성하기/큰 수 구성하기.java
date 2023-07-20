import java.util.Scanner;
import java.util.Arrays;

public class Main {
	static int n;
	static int k;
	static int[] arr;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[k];
		
		for(int i=0; i<k; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		bigNum(0);
		System.out.println(result);
		
		sc.close();
	}
	
	public static void bigNum(int now) {
		// n보다 작은 수 중에 큰 수를 구하는 것이므로 재귀 종료
		if(now > n) return;
		
		// 재귀호출하면서 이전 결과값보다 크면서 n보다 작은 수라면 result에 저장
		if(result < now) {
			result = now;
		}
		
		// 입력받은 수를 큰 수부터 골라서 재귀호출
		for(int i=k-1; i>=0; i--) {
			bigNum(now*10 + arr[i]);
		}
	}
}