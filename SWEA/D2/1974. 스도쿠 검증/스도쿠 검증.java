import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		for(int test_case = 1; test_case <=T; test_case++)
		{
           	int [][] arr = new int[9][9];
            int flag=1;
			for(int i=0; i<9; i++){
            	for(int j=0; j<9; j++){
                	arr[i][j]=sc.nextInt();
                }
            }
            //행 검사
            for(int i=0; i<9; i++){
                int[] arr_check = new int[9]; //처음 생성시 0으로 이루어진 배열 생성됨
            	for(int j=0; j<9; j++){
                    //arr의 값-1에 해당되는 위치 1증가
                	arr_check[(arr[i][j])-1]++; 
                }
                // 1~9다 존재시 arr_check배열은 모두 1이 됨
                for(int k=0; k<9; k++){
                	if(arr_check[k]==0){
                        flag=0;
                        break;
                    }
                }
            }
            
            //열 검사
            for(int j=0; j<9; j++){
                int[] arr_check = new int[9]; //처음 생성시 0으로 이루어진 배열 생성됨
            	for(int i=0; i<9; i++){
                    //arr의 값-1에 해당되는 위치 1증가
                	arr_check[(arr[i][j])-1]++; 
                }
                // 1~9다 존재시 arr_check배열은 모두 1이 됨
                for(int k=0; k<9; k++){
                	if(arr_check[k]==0){
                        flag=0;
                        break;
                    }
                }
            }
            
            //3x3 격자 검사
            //(0,0)(0,3)(0,9)등 3x3의 왼쪽 맨윗부분을 반복문 시작점으로 잡는다
            for(int i=0; i<=6; i+=3){
            	for(int j=0; j<=6; j+=3){
                   int[] arr_check = new int[9]; //처음 생성시 0으로 이루어진 배열 생성됨
                    //3x3에 해당하는 부분 검사
                    for(int r=0; r<3; r++){
                    	for(int p=0; p<3; p++){
                        	arr_check[(arr[i+r][j+p])-1]++;
                        }
                    }
                     // 1~9다 존재시 arr_check배열은 모두 1이 됨
                    for(int k=0; k<9; k++){
                        if(arr_check[k]==0){
                            flag=0;
                        	break;
                        }
                    }
                }
            }
            
                   System.out.println("#"+test_case+" "+flag);
            }
            
		}
	}