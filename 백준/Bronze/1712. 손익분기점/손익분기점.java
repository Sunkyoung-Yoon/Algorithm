import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//고정지출비용
		int A = Integer.parseInt(st.nextToken());
		//가변비용 
		int B = Integer.parseInt(st.nextToken());
		//노트북 한대가격
		int C = Integer.parseInt(st.nextToken());
		
		//한 대를 만드는 가격이 파는 가격보다 크면 수익이 날 수 없음
		if(C<=B)  {
			System.out.println(-1);
		}
		else{
			System.out.println((A/(C-B)+1));
		}
	
	}
}