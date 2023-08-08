import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			list.add(i, i+1);
		}
				
		sb.append("<");
		int plus = K;
		for(int i=0; i<N; i++) {
			// 사이즈를 넘어가면 범위 내로 다시 설정
			if(plus > list.size()) {
				plus %= list.size();
			}
			
			if(i == N-1) {
				sb.append(list.get(list.size()-1)+">");
				break;
			}
			
			// 리스트에서 하나를 제거했으므로 K-1 한다
			if(plus-1 < 0) {
				// 음수라면 한 바퀴 도는 거기 때문에 뒤에서부터 계산
				plus = list.size()+(plus-1);
			}
			else {
				plus = plus-1;
			}
			
			sb.append(list.get(plus)+", ");
			list.remove(plus);
			// 다음 k번째
			plus += K; 
						
		}	
		System.out.println(sb);	
	}
}