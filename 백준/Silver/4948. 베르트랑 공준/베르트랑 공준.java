import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 123456;
		boolean check[] = new boolean[n*2+1];
		for(int i=2; i<=2*n; i++)
			check[i]=true;
		
		for(int i=2; i<=Math.sqrt(2*n); i++) {
			for(int j=i+i; j<=2*n; j+=i) {
				check[j]=false;
			}
		}
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			int cnt=0;
			
			if(N==0) //입력 마지막
				break;
			
			for(int num=N+1; num<=2*N; num++) {
				if(check[num])
					cnt++;
			}
			System.out.println(cnt);
		}
		
	}
}