import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int[][] arr = new int[L][2];
		int sum = 0;
		
		for(int i=0; i<L; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		// x좌표 기준으로 오름차순 정렬
		Arrays.sort(arr, (arr1, arr2) ->{
			if(arr1[0] > arr2[0]){
				return 1;
			}
			else
				return -1;
				
		});
		
		// 정렬된 배열 기준으로 최고높이와 이에 해당하는 인덱스 위치
		int idx_x = 0;
		int max_y = 0;
		for(int i=0; i<L; i++) {
			if(max_y < arr[i][1]) {
				max_y = arr[i][1];
				idx_x = i;
			}
		}

		
		int start_x = arr[0][0];
		int start_y = arr[0][1];
		//왼쪽 -> 최고높이
		for(int i=0; i<=idx_x; i++) {
			if(start_y <= arr[i][1]) {
				sum += start_y * (arr[i][0] - start_x);
				start_x = arr[i][0];
				start_y = arr[i][1];
			}
		}
		
		start_x = arr[L-1][0];
		start_y = arr[L-1][1];
		//오른쪽 -> 최고높이
		for(int i=L-1; i>=idx_x; i--) {
			if(start_y <= arr[i][1]) {
				sum += start_y * (start_x - arr[i][0]);
				start_x = arr[i][0];
				start_y = arr[i][1];
			}
			
		}
		
		System.out.println(sum+max_y);
		
		sc.close();
	}

}