import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count=1;
		int room=2; //방 개수
		
		if(N==1) { //1일 경우 1개의 방
			count=1;
		}
		else {
			while(room<=N) {
				room = room + (count*6);
				count++;
			}
		}
		
		System.out.println(count);
	}
}