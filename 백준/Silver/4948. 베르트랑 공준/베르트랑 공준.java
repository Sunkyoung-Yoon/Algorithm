import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 123456;
		boolean check[] = new boolean[n*2+1];
		
		check[0] = true; //0은 소수아님
		check[1] = true; //1은 소수아님
		
		for(int i=2; i<=Math.sqrt(2*n); i++) {
			for(int j=i+i; j<=2*n; j+=i) { //소수가 아닌수 true로 변경
				check[j]=true;
			}
		}
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			int cnt=0;
			
			if(N==0) //입력 마지막
				break;
			
			for(int num=N+1; num<=2*N; num++) {
				if(!check[num]) //false면 소수
					cnt++;
			}
			System.out.println(cnt);
		}
		
	}
}