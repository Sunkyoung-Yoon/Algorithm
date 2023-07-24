import java.util.Scanner;

public class Main {
	private static int N, S;
	private static int count;
	private static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		dfs(0, 0);
		// S가 0이라면 더하지 않고 가는 dfs에서 0이 하나 생기기 때문에 조합으로 생기는 0이 아닌 0이 카운트 된다
		if(S == 0) {
			count--;
		}
		System.out.println(count);
		
		sc.close();
	}
	
	public static void dfs(int depth, int sum) {
		// depth이 N이 되면 탐색 종료
		if(depth == N) {
			// S가 되는 부분수열을 찾으면 count++
			if(sum == S) {
				count++;
			}
			return;
		}
		
		dfs(depth+1, sum); //새로운 값을 더하지 않고 현재 값을 넘기기
		dfs(depth+1, sum+arr[depth]); // 값을 더하고 넘기기 
	}

}