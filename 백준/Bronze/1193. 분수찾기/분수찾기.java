import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		int row = 1; //몇번째 행인지 저장할 변수
		//행에 따른 분수 개수 ex) 행이 3일 때, 분수의 개수는 1+2+3=6개가 된다.
		int cnt = 0; 
		
		//cnt보다 X가 커지면 반복문 탈출
		//커지면 n-1번째 행에 위치 ex)X=4일 때, cnt=6,row=4일 때 반복문 탈출
		while(cnt<X) {
			cnt+=row;
			row++;
		}
		
		//행에서 -1을 해준 값이 X가 위치한 행
		row=row-1;
		
		//분모와 분자의 합이 홀수인 행 - 분모감소, 분자증가
		if(row%2==0) { 
			System.out.println((row-(cnt-X))+"/"+(cnt-X+1));
		}
		else { //분모와 분자의 합이 짝수인 행 - 분모증가, 분자감소
			System.out.println((cnt-X+1)+"/"+(row-(cnt-X)));
		}
		
		
	}
}