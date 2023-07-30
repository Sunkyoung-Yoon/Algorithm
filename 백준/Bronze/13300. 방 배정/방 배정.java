import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] arr = new int[6][2];
		int result = 0;
		
		for(int i=0; i<n; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			
			arr[y-1][s]++;
		}
		
		for(int i=0; i<6; i++) {
			result += arr[i][0]/k + arr[i][1]/k;
			
			if(arr[i][0]%k != 0) result++;
			
			if(arr[i][1]%k != 0) result++;
		}
		
		System.out.println(result);
	}
}