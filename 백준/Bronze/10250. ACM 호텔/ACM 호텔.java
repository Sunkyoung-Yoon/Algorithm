import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트 개수
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); //호텔의 층수
			int W = Integer.parseInt(st.nextToken()); //층별 방 수
			int N = Integer.parseInt(st.nextToken()); //N번째 손님
			
			int Y = 0; //층
			int X = 0; //방 호수
			
			Y = N%H;
			X = N/H;
			
		
			if(Y==0) //나머지가 없는 경우 -> H와 N이 일치하는 경우
				System.out.println((H*100+X));
			else
				System.out.println((Y*100+X+1));
			
		}	
		
	}
}