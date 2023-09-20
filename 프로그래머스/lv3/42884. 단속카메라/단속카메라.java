import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 오름차순 정렬 - 진출시점 기준으로
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] route1, int[] route2){
                return route1[1] - route2[1];
            }
        });
        
        int pre = -30001;
        for(int i=0; i<routes.length; i++){
            // 이전 차량의 진출 시점이 이번 차량의 진입 시점보다 크거나 갘다면
            // 하나의 감시카메라로 두 차량 모두 확인 가능
            if(pre >= routes[i][0]){
                continue;
            }
            
            pre = routes[i][1];
            answer++;
        }
        
        return answer;
    }
}