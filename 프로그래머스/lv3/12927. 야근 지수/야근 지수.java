import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // Arrays.sort()로 정렬하면 효율성에서 아웃
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        // n시간 동안 가장 작업량이 큰 일의 작업량 -1
        // -1 한 작업량을 우선순위 큐에 넣어주기
        for(int i=0; i<n; i++){
            pq.add(pq.poll()-1);
        }
        
        // 피로도 구하기
        while(!pq.isEmpty()){
            int work = pq.poll();
            // 남는 작업량이 없는 경우 패스
            if(work <= 0) 
                continue;
            answer += Math.pow(work,2);
        }
        
        return answer;
    }
}