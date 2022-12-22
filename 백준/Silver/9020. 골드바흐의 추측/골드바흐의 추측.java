import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int N = 10000;
		boolean[] check = new boolean[N+1];
		check[0]=true; //0은 소수아님
		check[1]=true; //1은 소수아님
		
		for(int i=2; i<=Math.sqrt(N); i++) {
			//이미 소수가 아니라고 판정된 수는 바로 다음 i로 넘어감
			if(check[i]==true)
				continue;
			//false라면 그 수의 배수는 소수가 아님 ex) i=2, j=4,6,8..
			for(int j=i+i; j<=N; j+=i) {
				check[j]=true;
			}
		}
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int a=0;
			int b=0;
			
			//i가 n/2에 가까워질수록 i와 n-i의 차는 작아짐
			for(int i=2; i<=n/2; i++) {
				//i와 n-i가 소수라면
				if(!check[i] && !check[n-i]){
					a=i;
					b=n-i;
				}
			}
			System.out.println(a+" "+b);
		}
		
	}
}