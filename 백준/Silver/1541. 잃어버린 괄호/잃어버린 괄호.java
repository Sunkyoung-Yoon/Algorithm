import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		String s = br.readLine(); 
		//-를 기준으로 문자열 나눠서 배열에 저장
		String[] str = s.split("-");
		
		
		int result = 0;
		//나눈 개수만큼 반복
		for(int i=0; i<str.length; i++) {
			
			//+가 있는 부분 더해서 sum에 저장
			String[] num = str[i].split("[+]");
			int sum = 0;
			//+ 기준으로 문자열 나눠서 sum에 더한다.
			for(int j=0; j<num.length; j++) {
				sum += Integer.parseInt(num[j]);
			}
			
			
			//처음에 나오는 수나 수의 합은 더한다.
			if(i==0){
				result += sum;
			}
			//처음이 아니라면 -빼기 뒤에 괄호로 묶이는 수
			else {
				result -= sum;
			}
		}
		
		System.out.println(result);
		
	}	
}