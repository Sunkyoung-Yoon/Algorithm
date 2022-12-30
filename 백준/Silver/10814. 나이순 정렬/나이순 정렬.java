import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[][] str = new String[N][2];
		
		//회원 저장
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			str[i][0] = st.nextToken();
			str[i][1] = st.nextToken();
		}
		
		//Arrays.sort() 정렬조건 재정의
		Arrays.sort(str, new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {
				if(o1[0]==o2[0]) //나이가 같다면 입력순대로 (=가입한 순서대로)
					return 0;
				else //나이가 다르다면 나이순대로
					return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
			}
		});
				
		
		for(int i=0; i<N; i++) {
			sb.append(str[i][0]+" "+str[i][1]).append("\n");
		}
		
		System.out.print(sb);
		
	}
}