import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int num=M; num<=N; num++) {
			boolean flag = true;
            
            if(num==1) //1인 경우는 제외
				continue;
			
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
				System.out.println(num);
		}
		
		
		
	}
}