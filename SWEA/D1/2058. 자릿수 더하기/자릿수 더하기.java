import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int sum = 0; // 각 자릿수의 합을 저장할 변수
        String num;
		num=sc.next();
		
        // 각 자릿수별로 끊어서 int형으로 전환하여 sum에 저장한다.
        for(int i=0; i<4; i++){
        	sum += Integer.parseInt(num.substring(i, i+1));
        }
        
        System.out.println(sum);
	}
}