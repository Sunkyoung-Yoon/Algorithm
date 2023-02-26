import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine()); //4의 배수
		int count = N/4;
		
		for(int i=0; i<count; i++) {
			sb.append("long ");
		}
		
		System.out.println(sb+"int");

	}	
}