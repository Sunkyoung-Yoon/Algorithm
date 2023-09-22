import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // 출전순서를 안다 -> 정렬해서 비교 가능
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx1 = 0;
        int idx2 = 0;
        while(true){
            if(idx1 == A.length || idx2 == B.length)
                break;
            // B가 이겼다면 A,B 모두 다음 수로
            if(A[idx1] < B[idx2]){
                idx1++;
                idx2++;
                answer++;
            }
            // B가 졌거나 비겼다면 B만 다음 수로
            else{
                idx2++;
            }
        }
        
        return answer;
    }
}