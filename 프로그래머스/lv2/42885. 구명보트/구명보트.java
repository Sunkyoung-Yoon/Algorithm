import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int index = 0;
        //i와 index가 같아질 때까지 반복
        for(int i=people.length-1; i>=index; i--){
            int sum = people[i]+people[index];
            
            //보트에 두 사람이 탈 수 있다면 index++ 다음 최솟값으로 넘어감
            if(sum <= limit){
                index++;
                answer++;
            }
            else answer++;
        }
        
        return answer;
    }
}