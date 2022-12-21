import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			int cnt=0;
			
			if(N==0) //입력 마지막
				break;
			
			for(int num=N+1; num<=2*N; num++) {
				boolean flag = true;
				
	            //제곱근을 활용하여 구하기
	            /*
	            ex) 12의 약수 1,2,3,4,6,12 (1-12, 2-6, 3-4)이 짝을 이룬다.
	            12의 제곱근 3.xx 즉, 제곱근까지만 확인해도 약수 존재를 확인할 수 있다.
	            */
				for(int j=2; j<=Math.sqrt(num); j++) {
					if(num%j==0) {
						flag=false;
						break;
					}
				}
				
				if(flag)
					cnt++;
			}
			System.out.println(cnt);
		}
		
	}
}