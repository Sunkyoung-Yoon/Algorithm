import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        for(int i=0; i<d.length; i++){
            budget = budget-d[i];
            
            //예산 초과되면 지원 종료
            if(budget<0) break;
            //초과안되면 부서 수 증가
            else answer++;
        }
        return answer;
    }
}