import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] counting = new int[10001]; //배열은 0부터 시작하므로 +1
		
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		//입력받은 수 등장횟수 카운트
		for(int i=0; i<N; i++) {
			counting[arr[i]]++;
		}
		
		for(int i=0; i<10001; i++) {
			if(counting[i]!=0) {
				sb.append(i).append("\n");
				counting[i]--; //출력후 등장횟수 -1
				i--; //2번이상 등장한 경우 등장만큼 출력하기 위해 -1함
			}
		}
		
		System.out.print(sb);
		
	}
}