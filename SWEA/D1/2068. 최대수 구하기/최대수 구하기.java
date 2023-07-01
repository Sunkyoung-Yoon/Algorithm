import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
    {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num;
            int max = 0; // 각 테스트별 최대수를 저장할 변수
            for(int i=0; i<10; i++){
            	num = sc.nextInt();
                //더 큰 수를 max에 저장한다.
                max = Math.max(max, num);
            }
            
            System.out.println("#"+test_case+" "+max);
		}
	}
}