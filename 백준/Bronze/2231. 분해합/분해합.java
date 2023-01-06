import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int N = Integer.parseInt(br.readLine()); 
		boolean flag = false;
		int result = 0;
		
		//1부터 N-1까지 돌며 생성자 찾기
		for(int i = 1; i<N; i++) {
			int sum = i;
			int num = i; //각 자릿수를 저장할 변수
			//자릿수 더하기
			while(num>0) {
				sum+=num%10;
				num=num/10;
			}
			
			//생성자가 나오면
			if(N==sum) {
				flag=true;
				result=i; //생성자 저장
				break;
			}
		}
		
		if(flag==false) //생성자 없는 경우
			System.out.println(0);
		else
			System.out.println(result);
	}	
}