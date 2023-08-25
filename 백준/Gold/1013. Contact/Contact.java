import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		
		// 입력받은 전파기록이 가져야 하는 패턴(정규식)
		String check = "(100+1+|01)+"; 
		
		for(int tc=0; tc<T; tc++) {
			String str = br.readLine();
			// check에 해당하는 패턴이라면
			if(str.matches(check)) 
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		
		System.out.println(sb);

	}

}