import java.io.*;
import java.util.*;

// 화살표 그리기
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (a1, a2)-> {
			// 색깔이 같으면
			if(a1[1] == a2[1])
				// 점의 위치 오름차순 정렬
				return a1[0] - a2[0];
			else
				return a1[1] - a2[1];
		});
		
		sum += arr[1][0] - arr[0][0]; // 왼 -> 오 첫번째 화살표
		sum += arr[N-1][0] - arr[N-2][0]; // 오 -> 왼 첫번째 화살표
		for(int i=1; i<N-1; i++) {
			
			// 왼쪽 오른쪽 현재와 모두 색이 같다면
			if(arr[i][1] == arr[i-1][1] && arr[i][1] == arr[i+1][1]) {
				sum += Math.min(arr[i][0]-arr[i-1][0], arr[i+1][0]-arr[i][0]);
			}
			// 왼쪽만 색이 같다면
			else if(arr[i][1] == arr[i-1][1]) {
				sum += arr[i][0]-arr[i-1][0];
			}
			// 오른쪽만 색이 같다면
			else if(arr[i][1] == arr[i+1][1]) {
				sum += arr[i+1][0]-arr[i][0];
			}
		}
		
		System.out.println(sum);

	}

}