import java.util.*;

class Solution {
    static LinkedList<Integer>[] list;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        list = new LinkedList[computers[0].length]; // 컴퓨터 0~n-1
        for(int i=0; i<list.length; i++){
            list[i] = new LinkedList<>();
        }
        
        // 연결 정보 저장
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[i].length; j++){
                if(computers[i][j] == 1){
                    list[i].add(j);
                }
            }
        }
        
        visited = new boolean[computers[0].length];
        for(int i=0; i<computers[0].length; i++){
            if(!visited[i]){
                answer++;
                dfs(i);
            }    
        }
        
        return answer;
    }
    
    static void dfs(int now){
        visited[now]= true;
        
        for(int n: list[now]){
            if(!visited[n]){
                dfs(n);
            }
        }
    }
}