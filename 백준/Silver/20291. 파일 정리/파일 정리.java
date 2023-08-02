import java.io.*;
import java.util.Arrays;

// 파일 정리
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] file = new String[N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			// .이후 문자열 저장
			file[i] = s.substring(s.lastIndexOf(".")+1);
		}
		Arrays.sort(file);
		
		sb.append(file[0]+" ");
		int count = 1;
		for(int i=1; i<N; i++) {
			if(file[i].equals(file[i-1])) {
				count++;
			}
			else {
				sb.append(count).append("\n");
				count = 1;
				sb.append(file[i]+" ");
			}
		}
		// 마지막 문자열 개수 저장
		sb.append(count).append("\n");
		
		System.out.println(sb);
	}

}