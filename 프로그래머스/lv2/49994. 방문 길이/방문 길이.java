class Solution {
    //U,D,R,L
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    //방문 체크
    //양방향으로 체크해줘야함
    static boolean[][][][] visited = new boolean[11][11][11][11]; 
    public int solution(String dirs) {
        int answer = 0;
        
        //현재위치
        int x = 5;
        int y = 5;
        
        //다음위치
        int nextx = 5; 
        int nexty = 5;
        int index = 0;
        
        for(int i=0; i<dirs.length(); i++){
            x = nextx;
            y = nexty;
            char ch = dirs.charAt(i);
            if(ch=='U') index=0;
            else if(ch=='D') index=1;
            else if(ch=='R') index=2;
            else index=3;
            
            //명령어에 따라 캐릭터 이동
            nextx += dx[index];
            nexty += dy[index];
            
            //캐릭터가 좌표평면의 경계를 벗어났다면
            if(nextx <0 || nexty<0 || nextx>10 || nexty>10){
                //이동하기전으로 돌아감
                nextx -= dx[index];
                nexty -= dy[index];
                //새로운 길인지 체크할 필요없으므로 바로 다음으로
                continue;
            }
            
            
            //캐릭터가 새로운 길을 걸었다면
            if(!visited[nextx][nexty][x][y] && !visited[x][y][nextx][nexty]){
                visited[nextx][nexty][x][y] = true;
                visited[x][y][nextx][nexty] = true;
                answer++;
            }
        }
        return answer;
    }
}