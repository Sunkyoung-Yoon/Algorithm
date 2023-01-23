import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count=1; //가짓수 1개는 자기자신을 의미
		
		//예를 들어, 15면 7,8의 조합이 가장 큰 수들의 조합
		//즉, N이 되는 연속된 수의 합은 N/2와 N/2+1 범위 이내가 된다.
		for(int i=1; i<=N/2; i++) {
			int sum=0;
			for(int j=i; j<=(N/2)+1; j++) {
				sum += j;
				//i값이 포함될 때, N보다 커지는 경우가 생기면
				//반복문 종료
				if(sum>N)
					break;
				
				//i값이 포함될 때 N이 되는 합을 찾았으므로 반복문 종료
				if(sum==N) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}