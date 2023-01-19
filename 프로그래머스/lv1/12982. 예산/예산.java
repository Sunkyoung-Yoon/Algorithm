import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int sum = 0;
        
        for(int i=0; i<d.length; i++){
            sum+=d[i];
            
            if(sum>budget) break; //예산초과시 반복문 종료
            else answer++; //예산 범위내이면 지원가능 부서 수 증가
        }
        return answer;
    }
}