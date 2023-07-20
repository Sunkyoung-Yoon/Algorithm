import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<60; j++) {
				for(int p=0; p<60; p++) {
					if(check(k, i) || check(k, j) || check(k, p)) {
						result++;
					}
				}
			}
		}
		
		System.out.println(result);
		
		sc.close();
	}
	
	public static boolean check(int k, int num) {
		int num1 = num/10;
		int num2 = num%10;
		
		if(num1 == k || num2 == k) {
			return true;
		}
		
		return false;
	}

}