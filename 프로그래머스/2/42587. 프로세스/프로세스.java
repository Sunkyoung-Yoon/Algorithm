import java.util.*;

class Solution {
    private static int[] priArr; // 우선순위별 개수를 저장할 배열
    private static List<Integer> priList; // 우선순위를 저장할 리스트
    private static Queue<int[]> queue; // (위치, 우선순위)
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        priArr = new int[101];
        priList = new ArrayList<>();
        queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            int pri = priorities[i];
            queue.add(new int[]{i, pri});
            priArr[pri]++;
            if(priArr[pri] == 1) {
                priList.add(pri);   
            }
        }
        Collections.sort(priList, Collections.reverseOrder());
        
        // 우선순위 제대로 들어오고 정렬되었는 지 테스트
        for(int i=0; i<priList.size(); i++) {
            System.out.println(priList.get(i));
        }
        
        answer = bfs(location);
        
        return answer;
    }
    
    private static int bfs(int location) {
        int count = 0; // 나간 순서
    
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            // 남아있는 것 중 가장 높은 우선순위와 일치한다면
            if(now[1] == priList.get(0)) {
                priArr[now[1]]--;
                // 0이 되면 해당 우선순위는 이미 다 큐에서 나갔다는 의미
                // 우선순위 리스트에서 제거
                if(priArr[now[1]] == 0) { 
                    priList.remove(0);
                }
                count++;
                
                // 나가는 애 원래 위치가 location과 같다면
                if(now[0] == location) {
                    break;
                }
            }
            // 안 높다면 뒤로 보냄
            else {
                queue.add(now);
            }
        }
        
        return count;
    }
}