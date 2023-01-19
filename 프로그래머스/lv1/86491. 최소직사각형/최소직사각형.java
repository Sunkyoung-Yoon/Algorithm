class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_w = 0; //지갑 가로길이
        int max_h = 0; //지갑 세로길이
        
        for(int i=0; i<sizes.length; i++){
            //명함의 긴 부분을 가로, 짧은 부분을 세로
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            
            max_w = Math.max(max_w, w); //가장 큰 명함 가로길이
            max_h = Math.max(max_h, h); //가장 큰 명함 세로길이
            
        }
        answer = max_w*max_h;
        
        return answer;
    }
}