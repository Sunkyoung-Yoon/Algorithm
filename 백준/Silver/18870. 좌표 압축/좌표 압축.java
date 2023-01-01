import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; //원래 숫자
		int[] arr_sort = new int[N]; //정렬된 숫자
		
		
		//숫자 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr_sort[i] = Integer.parseInt(st.nextToken());
			arr[i] = arr_sort[i];
		}

		Arrays.sort(arr_sort); //오름차순
		
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int rank = 0;
		for(int i : arr_sort) { //arr_sort를 순회한다
			if(!map.containsKey(i)) { //map에 이미 존재하는 좌표가 아니라면
				//해당 좌표에 대한 value인 rank증가시키고 저장
				map.put(i, rank++);
			}
		}
		
		//등수 출력
		for(int i : arr) { //arr 원래 배열을 순회한다.
			//원래 배열 인덱스 i에 대한 value값 sb에 저장
			sb.append(map.get(i)+" "); 
		}
		System.out.print(sb);
		
	}
}