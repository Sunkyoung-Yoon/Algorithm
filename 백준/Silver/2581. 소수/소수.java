import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int min_flag=0;
		int min = 0;
		int sum=0;
		
		for(int n=M; n<=N; n++) {
			boolean flag = true;
			
			if(n<=1) //1과 같거나 작은 경우는 소수가 아니기 때문에 다음 n으로 넘어간다.
				continue;
			
			//소수일 경우 약수가 없기 때문에 num/2까지만 확인한다.
			for(int i=2; i<=n/2; i++) {
				if(n%i==0) {
					flag=false;
					break;
				}
			}
			
			if(flag==true) {
				min_flag++; //처음 증가시킨 n이 최솟값 소수
				if(min_flag==1)
					min=n;
				sum+=n;
			}
		}
		
		if(min_flag==0) //소수가 하나도 없는 경우
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
		
	}
}