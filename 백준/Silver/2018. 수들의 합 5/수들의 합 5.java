import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count=1; //가짓수 1개는 자기자신을 의미
		
		//투포인터 풀이
		int start = 0; //시작 포인터
		int end = 0; //종료 포인터
		int sum=0;
		
		while(end<N) {
			//sum이 더 크다면 시작포인터 증가
			if(sum>N) {
				//합의 시작 부분이 바뀌었기 때문에 원래 시작한 수는 빼줌
				sum-=start;
				start++;
			}
			//sum이 작다면 종료포인터 증가
			else if(sum<N){
				end++;
				//연속된 합의 마지막 수 새로 더함
				sum+=end;
			}
			else { //sum==N이라면
				count++;
				end++;
				sum+=end;
			}
		}
		System.out.println(count);
	}
}