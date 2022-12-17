import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken()); //낮에 올라갈 수 있는 거리 A
		int B = Integer.parseInt(st.nextToken()); //밤에 자는동안 미끄러지는 거리 B
		int V = Integer.parseInt(st.nextToken()); //나무의 높이 V
		
		int day=0; //올라가는데 걸리는 일수
		
		day = (V-B)/(A-B);
		
		//나머지가 0으로 안떨어지면 하루를 더해준다. 3.2라면 3일이 아니라 4일이 되기 때문
		if((V-B)%(A-B)!=0)
			day++;
		
		System.out.println(day);
	}
}