import java.io.*;
import java.util.*;

public class Main {
	static int[][] Gear; // 톱니바퀴 개수가 안 정해져있어서 2차원 배열로
	static int N;
	static int[] dir;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		// 톱니바퀴 정보 저장
		Gear = new int[N+1][8]; // 톱니바퀴 1~N번
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				Gear[i][j] = s.charAt(j) - '0';
			}
		}

		// 톱니바퀴 돌리기
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int turnDir = Integer.parseInt(st.nextToken());
			dir = new int[N+1]; // 이번 회전에서의 톱니바귀 회전 정보
			dir[num] = turnDir;
			
			check(num); // 톱니바퀴 회전 방향 체크
			move(); // 회전
//			for(int d=1; d<5; d++) {
//				System.out.println(dir[d]);
//			}
//			
//			System.out.println((i+1)+"번째 회전 후 결과");
//			print();

		}

		System.out.println(result());

	}

	// 12방향이 S극인 톱니바퀴의 수 
	private static int result() {
		int sum = 0;
		for(int i=1; i<=N; i++) {
			sum += Gear[i][0];
		}

		return sum;
	}

	// num번째 톱니바퀴 회전시 나머지 회전 방향 정보 0:회전x, 1:시계방향, -1:반시계방향
	private static void check(int num) {
		
		// 왼쪽 톱니바퀴 검사
		for (int i = num - 1; i > 0; i--) {
			if (Gear[i][2] != Gear[i+1][6]) { // 회전가능하면 회전방향 dir에 저장
				dir[i] = -dir[i + 1];
			} else { // 회전되지 않으면 다음 것도 어차피 안됨 break
				break;
			}
		}

		// 오른쪽 톱니바퀴 검사
		for (int i = num + 1; i <= N; i++) {
			if (Gear[i-1][2] != Gear[i][6]) { // 회전가능하면 회전방향 dir에 저장
				dir[i] = -dir[i - 1];
			} else { // 회전되지 않으면 다음 것도 어차피 안됨 break
				break;
			}
		}
	}

	// 톱니바퀴 별로 회전 필요하면 회전
	private static void move() {
		
		for(int num=1; num<=N; num++) {
			if(dir[num] != 0) {
				if (dir[num] == 1) { // 시계
					int last = Gear[num][7];
					
					for(int j=7; j>0; j--) {
						Gear[num][j] = Gear[num][j-1];
					}
					Gear[num][0] = last; // 맨뒤에 있는거 맨앞으로
				} 
				else { // 반시계
					int first = Gear[num][0];
					
					for(int j=0; j<7; j++) {
						Gear[num][j] = Gear[num][j+1];
					}
					Gear[num][7] = first; // 맨앞에 있는거 맨뒤로
				}
			}
		}
		
	}

	private static void print() { // 톱니바퀴 상태 출력
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(Gear[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
}