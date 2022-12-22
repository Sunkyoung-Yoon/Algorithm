import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int a=0;
			int b=0;
			
			//i가 n/2에 가까워질수록 i와 n-i의 차는 작아짐
			for(int i=1; i<=n/2; i++) {
				//i와 n-i가 소수라면
				if(check(i) && check(n-i)){
					a=i;
					b=n-i;
				}
			}
			System.out.println(a+" "+b);
		}
		
	}
	//소수 판별하는 메소드
	public static boolean check(int num) {
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) {
				return false;
			}
				
		}
		return true;
	}
}