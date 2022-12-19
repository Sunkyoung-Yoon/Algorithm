import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0 ; //봉지 개수
		
		if(N%5==0) { //5킬로그램 봉지로만 담아도 가능한 경우
			cnt=N/5;
		}
		//5킬로그램 봉지와 3킬로그램 봉지로 담거나 3킬로그램 봉지만 담는 경우
		else { 
			while(N>0) {
				N-=3;
				cnt++;
				if(N%5==0) {
					cnt+=N/5;
					N=0;
					break;
				}
					
			}
			if(N!=0) //0이 아니라면 정확하게 N킬로그램담기가 안되는 경우
				cnt=-1;
		}
		
		
		System.out.println(cnt);
		
	}
}