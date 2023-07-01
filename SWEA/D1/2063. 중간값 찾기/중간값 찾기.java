import java.util.Scanner;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		int[] arr = new int[T];
        for(int i=0; i<T; i++){
           	arr[i] = sc.nextInt();
        }
            
		Arrays.sort(arr); // 오름차순 정렬
        System.out.println(arr[T/2]); // 정렬된 배열의 가운데 숫자 
	}
}