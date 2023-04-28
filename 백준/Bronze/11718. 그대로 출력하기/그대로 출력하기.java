import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		while(true) {
			String s = br.readLine();
			
			if(s==null) break;
			
			System.out.println(s);
		}
	}
}