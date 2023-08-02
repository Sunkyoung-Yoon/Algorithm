import java.io.*;
import java.util.*;

//단어 정렬
public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		
		//단어 저장
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
		}
		
		//Arrays.sort() 정렬조건 재정의
		Arrays.sort(str, (String o1, String o2)->o1.length()==o2.length()?o1.compareTo(o2):o1.length()-o2.length());
		
		//0번째 문자는 무조건 처음 등장한 단어
		sb.append(str[0]).append("\n");
		//중복단어 제거
		for(int i=1; i<N; i++) {
			//직전의 문자와 현재 문자가 다르다면 출력 대상
			if(!str[i].equals(str[i-1]))
				sb.append(str[i]).append("\n");
		}
		
		System.out.print(sb);
		
	}
}