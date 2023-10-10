import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> Gear1, Gear2, Gear3, Gear4;
	static int[] dir; // 각 톱니바귀 회전 정보 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Gear1 = new ArrayList<>(); // 첫번째 톱니바퀴
		Gear2 = new ArrayList<>(); // 두번째 톱니바퀴
		Gear3 = new ArrayList<>(); // 세번째 톱니바퀴
		Gear4 = new ArrayList<>(); // 네번째 톱니바퀴
		for(int i=0; i<4; i++) {
			String s = br.readLine();
			for(int j=0; j< s.length(); j++) {
				if(i==0)
					Gear1.add(s.charAt(j)-'0');
				else if(i==1)
					Gear2.add(s.charAt(j)-'0');
				else if(i==2)
					Gear3.add(s.charAt(j)-'0');
				else if(i==3)
					Gear4.add(s.charAt(j)-'0');
			}
		}
		
		// 톱니바퀴 돌리기
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int turnDir = Integer.parseInt(st.nextToken());
			dir = new int[5]; // 이번 회전에서의 톱니바귀 회전 정보 
			dir[num] = turnDir;
			
			check(num); // 톱니바퀴 회전 방향 체크
			move(); // 회전
					
		}
		
		System.out.println(result());

	}
	
	// 점수의 합
	private static int result() {
		int sum = 0;
		sum += Gear1.get(0)*1;
		sum += Gear2.get(0)*2;
		sum += Gear3.get(0)*4;
		sum += Gear4.get(0)*8;
		
		return sum;
	}
	
	// num번째 톱니바퀴 회전시 나머지 회전 방향 정보 0:회전x, 1:시계방향, -1:반시계방향
	private static void check(int num) {
		// 왼쪽 톱니바퀴 검사
		for(int i=num-1; i>0; i--) {
			if(i==1) {
				
				if(Gear1.get(2) != Gear2.get(6)) { // 회전가능하면 회전방향 dir에 저장
					dir[i] = -dir[i+1];
				}else { // 회전되지 않으면 다음 것도 어차피 안됨 break
					break;
				}
			}
			else if(i==2) {
				if(Gear2.get(2) != Gear3.get(6)) { // 회전가능하면 회전방향 dir에 저장
					dir[i] = -dir[i+1];
				}else { // 회전되지 않으면 다음 것도 어차피 안됨 break
					break;
				}
			}
			else if(i==3) {
				if(Gear3.get(2) != Gear4.get(6)) { // 회전가능하면 회전방향 dir에 저장
					dir[i] = -dir[i+1];
				}else { // 회전되지 않으면 다음 것도 어차피 안됨 break
					break;
				}
			}
		}
		
		// 오른쪽 톱니바퀴 검사
		for(int i=num+1; i<5; i++) {
			if(i==2) {
				if(Gear1.get(2) != Gear2.get(6)) { // 회전가능하면 회전방향 dir에 저장
					dir[i] = -dir[i-1];
				}else { // 회전되지 않으면 다음 것도 어차피 안됨 break
					break;
				}
			}
			else if(i==3) {
				if(Gear2.get(2) != Gear3.get(6)) { // 회전가능하면 회전방향 dir에 저장
					dir[i] = -dir[i-1];
				}else { // 회전되지 않으면 다음 것도 어차피 안됨 break
					break;
				}
			}
			else if(i==4) {
				if(Gear3.get(2) != Gear4.get(6)) { // 회전가능하면 회전방향 dir에 저장
					dir[i] = -dir[i-1];
				}else { // 회전되지 않으면 다음 것도 어차피 안됨 break
					break;
				}
			}
		}
	}
	
	// 톱니바퀴 별로 회전 필요하면 회전
	private static void move() {
		
		if(dir[1] != 0) {
			if(dir[1] == 1) { // 시계
				Gear1.add(0, Gear1.remove(Gear1.size()-1)); // 맨뒤에 있는거 맨앞으로
			}
			else { // 반시계
				Gear1.add(Gear1.size()-1, Gear1.remove(0)); // 맨앞에 있는거 맨뒤로
			}
		}
		if (dir[2] != 0) {
			if(dir[2] == 1) { // 시계
				Gear2.add(0, Gear2.remove(Gear2.size()-1)); // 맨뒤에 있는거 맨앞으로
			}
			else { // 반시계
				Gear2.add(Gear2.size()-1, Gear2.remove(0)); // 맨앞에 있는거 맨뒤로
			}
		}
		if (dir[3] != 0) {
			if(dir[3] == 1) { // 시계
				Gear3.add(0, Gear3.remove(Gear3.size()-1)); // 맨뒤에 있는거 맨앞으로
			}
			else { // 반시계
				Gear3.add(Gear3.size()-1, Gear3.remove(0)); // 맨앞에 있는거 맨뒤로
			}
		}
		if (dir[4] != 0) {
			if(dir[4] == 1) { // 시계
				Gear4.add(0, Gear4.remove(Gear4.size()-1)); // 맨뒤에 있는거 맨앞으로
			}
			else { // 반시계
				Gear4.add(Gear4.size()-1, Gear4.remove(0)); // 맨앞에 있는거 맨뒤로
			}
		}
	}
	
	private static void print() { // 톱니바퀴 상태 출력
		for(int i=0; i<8; i++) {
			System.out.print(Gear1.get(i));
		}
		System.out.println();
		for(int i=0; i<8; i++) {
			System.out.print(Gear2.get(i));
		}
		System.out.println();
		for(int i=0; i<8; i++) {
			System.out.print(Gear3.get(i));
		}
		System.out.println();
		for(int i=0; i<8; i++) {
			System.out.print(Gear4.get(i));
		}
		System.out.println();
	}
}