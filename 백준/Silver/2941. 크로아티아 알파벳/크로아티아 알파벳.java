import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = {"c=", "c-","dz=","d-","lj","nj","s=","z="};
		String s = br.readLine();
		
		for(int i=0; i<str.length; i++) {
			if(s.contains(str[i])) { //s에 str에 있는 문자가 있다면
				s=s.replace(str[i], "1"); //s는 str문자부분은 1로 교체하고 다시 저장
			}
		}
		
		System.out.println(s.length());
	}
	
}