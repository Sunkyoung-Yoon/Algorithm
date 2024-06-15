class Solution {
    static boolean[] visited;
    static int min;
    public int solution(String begin, String target, String[] words) {
        min = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        dfs(0,begin, target, words);
        
        if(min == Integer.MAX_VALUE) return 0;
        else return min;
    }
    
    static void dfs(int step, String result, String target, String[] words){
        // 최소 횟수 저장
        if(result.equals(target)){
            min = Math.min(min, step);
            return;
        }

        //if(step == words.length) return;

        for(int i=0; i<words.length; i++){
            int cnt = 0;
            // 다른 알파벳 수 확인 (이미 바꾼 단어로 돌아가지 않고)
            for(int j=0; j<words[i].length(); j++){
                if(result.charAt(j) != words[i].charAt(j) && !visited[i])
                    cnt++;
            }

            if(cnt == 1){
                // 이 단어로 바꿨음을 표시
                visited[i] = true;
                dfs(step+1, words[i], target, words);
                // 다른 순서로도 단어 변경해보기 위해 false
                visited[i] = false;
            }
        }
    }
}