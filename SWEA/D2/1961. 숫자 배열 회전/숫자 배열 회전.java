import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int[][] arr = new int[N][N];
            
            // 배열 숫자 입력
            for(int i=0; i<N; i++){
            	for(int j=0; j<N; j++){
                	arr[i][j] = sc.nextInt();
                }
            }
            
            int[][] rotation_90 = Rotation(arr); // 90도 회전
            int[][] rotation_180 = Rotation(rotation_90); //180도 회전
            int[][] rotation_270 = Rotation(rotation_180); // 270도 회전
            
           System.out.println("#"+test_case);
            for(int i=0; i<N; i++){
            	for(int j=0; j<N; j++){
                	System.out.print(rotation_90[i][j]);
                }
                System.out.print(" ");
                for(int j=0; j<N; j++){
                	System.out.print(rotation_180[i][j]);
                }
                System.out.print(" ");
                for(int j=0; j<N; j++){
                	System.out.print(rotation_270[i][j]);
                }
                System.out.println();
            }
        }
            
}
            //90도씩 회전
        public static int[][] Rotation(int[][] arr){
        	int[][] temp_arr = new int[arr.length][arr.length];
            
            for(int i=0; i<arr.length; i++){
            	for(int j=0; j<arr.length; j++){
                	temp_arr[i][j]=arr[arr.length-1-j][i];
                }
            }
            return temp_arr;
        }
}