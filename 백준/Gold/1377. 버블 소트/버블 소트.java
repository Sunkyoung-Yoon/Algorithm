import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		NumArray[] arr = new NumArray[N]; //NumArray클래스를 값으로 하는 배열 생성
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			//숫자와 인덱스를 저장
			arr[i] = new NumArray(num, i);
		}
		
		//1차원 배열이 아니므로 정렬기준 새로 작성
		//이전 숫자가 크다면 자리변경(오름차순 정렬)
		//버블정렬도 오름차순으로 정렬되므로 같은 결과를 가지게 됨
		Arrays.sort(arr, (o1,o2)->{
			return o1.num - o2.num;
		});
		
		//정렬 후 처음에 위치한 숫자의 정렬전 인덱스-정렬후 인덱스 저장
		int max = arr[0].index - 0;
		
		//처음은 이미 구했으므로 1부터 시작
		for(int i=1; i<N; i++) {
			//정렬전 인덱스-정렬후 인덱스 중 가장 큰 값 max에 저장
			max = Math.max(max, arr[i].index-i);
		}
		
		//정렬이 완료되었는지 확인하기 위해 한번 더 돌아야 하므로 +1
		System.out.println(max+1);
	}
	
}

class NumArray {
	int num;
	int index;
	
	NumArray(int num, int index){
		this.num = num;
		this.index = index;
	}
}
