import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int i = 2;
		
		while(N>1) { //N이 1보다 작아지면 반복문 탈출
			if(N%i==0) {
				System.out.println(i);
				N=N/i; //나눈 몫을 N에 저장
			}
			else { //안나눠진다면 i값 증가
				i++;
			}	
		}
		
	}
}