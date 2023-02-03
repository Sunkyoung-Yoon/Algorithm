import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A); //오름차순 정렬
        Arrays.sort(B); //오름차순 정렬
        
        //배열 A의 최솟값과 배열 B의 최댓값을 곱합
        for(int i=0; i<A.length; i++){
            answer += A[i]*B[B.length-1-i];
        }
        

        return answer;
    }
}