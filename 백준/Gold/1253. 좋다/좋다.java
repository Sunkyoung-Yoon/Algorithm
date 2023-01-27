import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		int count = 0; //좋다에 해당하는 수 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N개의 수 입력받아 저장
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		//투 포인터 사용을 위해 오름차순 정렬
		Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			int left = 0; //왼쪽포인터 - 작은 값 인덱스
			int right = N-1; //오른쪽포인터 - 큰 값 인덱스
			
			while(left<right) { //양쪽 포인터가 좁혀지다가 같아지기전까지 반복
				long num = arr[left]+arr[right];
				
				
				//num이 크다면 right포인터를 왼쪽으로 이동
				if(num>arr[i]) right--;
				
				//num이 작다면 left포인터 오른쪽으로 이동
				else if(num<arr[i]) left++;

				else { //num==arr[i]이면
					if(left==i) left++; // left와 같다면 오른쪽으로 이동
					else if(right==i) right--; //right과 같다면 왼쪽으로 이동 
					
					//자기자신을 제외하고 다른 두수의 합일 때, 좋다(GOOD)인 수로 판정 - 반복문 종료
					else{
						count++;
						break;
					}
				}
				
			}
		}
		
		
		System.out.println(count);
	}
}