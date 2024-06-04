import java.util.*;

class Solution {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        
        graph = new LinkedList[n+1];
        for(int i=0; i<=n; i++) {
            graph[i] = new LinkedList<>();
        }
        
        // 그래프(전력망) 간선 정보 저장
        for(int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        // 간선 하나를 골라 제거하면서 송전탑 개수의 차이 최솟값 찾기
        // 트리 구조로 간선 하나 제거하면 2개로 나뉘어짐
        int min = Integer.MAX_VALUE;
        for(int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            visited = new boolean[n+1];
            int count = bfs();
            int sub = Math.abs(count - (n-count));
            
            min = Math.min(min, sub);
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return min;
    }
    
    // 그래프의 개수 탐색
    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        
        int count = 1;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int n : graph[now]) {
                if(!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                    count++;
                }
            }
        }
        return count;
    }
}