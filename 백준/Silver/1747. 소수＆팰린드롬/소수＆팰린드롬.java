import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int N = Integer.parseInt(br.readLine());
		
        //N의 최대값인 1,000,000일 때, 소수이면서 팰린드롬인 수는 1,003,001
		boolean[] check = new boolean[1003002];
		int result = 0;
		
		//소수가 아닌 수 true
		check[0]=check[1]=true;
		for(int i=2; i<=Math.sqrt(check.length-1); i++) {
			//이미 소수가 아닌 수로 판정됐다면 continue
			if(check[i]) continue;
			
			for(int j=i*i; j<=check.length-1; j+=i) {
				check[j]=true;
			}
		}
		
		
		//N보다 크거나 같고 팰린드롬인 수
		for(int i=N; i<=check.length-1; i++) {
			
			//i가 소수라면
			if(!check[i]) {
				String s = String.valueOf(i);
				StringBuilder sb = new StringBuilder(s);
				
				//i를 뒤집은 수와 s 비교, 같다면 팰린드롬
				if(s.equals(sb.reverse().toString())) {
					result=i;
					break;
				}
			
			}
		}
		
		System.out.println(result);	
	}
}