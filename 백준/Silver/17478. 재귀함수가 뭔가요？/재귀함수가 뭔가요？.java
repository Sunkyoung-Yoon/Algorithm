import java.util.Scanner;

public class Main {
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sb = new StringBuilder();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		
		func(0);
		System.out.println(sb.toString());
	}
	
	static void func(int num) {
		print(num, "\"재귀함수가 뭔가요?\"\n");
		
		// 꼰대들 잘 들어보게 부터시작하는 문장
		if(num < N) {
			print(num, "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			print(num, "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			print(num, "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
			func(num+1);
		}else {
            // 꼰대 아닌 사람 등장, 답변하기
			print(num, "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			
		}
        // 답변하는 게 완료되면 그 횟수만큼 라고 답변하였지 출력
		print(num, "라고 답변하였지.\n");
	}
	
	static void print(int cnt, String msg) {
        // cnt번 ____ 붙여서 sb에 삽입, 0번째는 ____이 없음
		for(int c=0; c<cnt; c++) {
			sb.append("____");
		}
		sb.append(msg);
	}

}