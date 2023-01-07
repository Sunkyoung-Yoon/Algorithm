import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int N = Integer.parseInt(br.readLine());
		int num = 666; //종말의 영화
		int count = 0; 
		
		while(true) {
			
			String str=Integer.toString(num);
			
			if(str.contains("666")) { //num에 666이 포함된다면
				count++;
			}
			
			if(count==N) {
				System.out.println(num);
				break;
			}		
			num++;				
		}		
	}
}