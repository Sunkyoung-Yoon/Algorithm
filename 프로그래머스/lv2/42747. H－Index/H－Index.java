import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        //오름차순 정렬
        Arrays.sort(citations);
        
        /*
        논문인용횟수를 오름차순으로 정렬
        ex) [3,0,6,1,5] -> [0,1,3,5,6]
        최대 논문의 편 수는 citations.length이다.
        citations.length에서 -1씩하면서 (=h)
        citations[i] >= h가 되는 순간을 찾는다.
        */
        for(int i=0; i<citations.length; i++){
            int h = citations.length - i;
            
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        return answer;
    }
}