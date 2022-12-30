import java.io.*;
import java.util.*;
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
		
		//Arrays.sort() 정렬조건 정의
		Arrays.sort(str, (String o1, String o2)->o1.length()==o2.length()?o1.compareTo(o2):o1.length()-o2.length());
		
		sb.append(str[0]).append("\n"); //0번째 문자는 무조건 처음 등장한 단어
		//중복단어 제거
		for(int i=1; i<N; i++) {
			//현재 인덱스 위치 문자와 바로전 인덱스 위치의 문자가 같다면
			if(str[i].equals(str[i-1]))
				continue;
			//같지 않다
			else
				sb.append(str[i]).append("\n");
		}
		
		System.out.print(sb);
		
	}
}