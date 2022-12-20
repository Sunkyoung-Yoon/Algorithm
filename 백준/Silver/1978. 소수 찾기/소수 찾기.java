import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			int num = Integer.parseInt(st.nextToken());
			boolean flag = true;
			
			if(num<=1) //1과 같거나 작은 경우는 소수가 아니기 때문에 다음 n으로 넘어간다.
				continue;
			
			//소수일 경우 약수가 없기 때문에 num/2까지만 확인한다.
			for(int i=2; i<=num/2; i++) {
				if(num%i==0) {
					flag=false;
					break;
				}
			}
			
			if(flag==true) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}