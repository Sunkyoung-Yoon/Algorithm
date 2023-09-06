import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pqASC = new PriorityQueue<>(); //최소힙 - 오름차순
        PriorityQueue<Integer> pqDESC = new PriorityQueue<>(Collections.reverseOrder()); //최대힙 - 내림차순
        
        
        for(int i=0; i<operations.length; i++){
            char ch = operations[i].charAt(0);
            switch(ch){
                // 삽입
                case 'I':
                    pqASC.add(Integer.parseInt(operations[i].substring(2)));
                    pqDESC.add(Integer.parseInt(operations[i].substring(2)));
                    break;
                case 'D':
                    // 최솟값 삭제
                    // 최소힙에서 값을 꺼내고 그 값을 최대힙에서도 제거
                    // 힙에 요소가 있다면 제거
                    if(operations[i].charAt(2)=='-' && !pqASC.isEmpty()){
                        pqDESC.remove(pqASC.poll());
                    }
                    // 최댓값 삭제
                    else if(operations[i].charAt(2)!='-' && !pqDESC.isEmpty()){
                        pqASC.remove(pqDESC.poll());
                    }
                    break;
            } 
        }
        
        // 2개 큐 모두 비어있지 않다면
        if(!pqASC.isEmpty() && !pqDESC.isEmpty()){
            answer[0] = pqDESC.poll();
            answer[1] = pqASC.poll();
        }
        
        return answer;
    }
}