class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        boolean[] check = new boolean[46];
        int count = 0;
        int zero_count = 0;
        
        //정답인 경우 true로 변경
        for(int i=0; i<win_nums.length; i++){
            check[win_nums[i]] = true;
        }
        
        for(int i=0; i<lottos.length; i++){
            if(check[lottos[i]]){ //정답 맞춘 경우
                count++;
            }
            //0인 경우
            if(lottos[i]==0) zero_count++;
        }
        
        answer[0] = 7-count-zero_count;
        answer[1] = 7-count;
        
        //7이 되는 경우 6등으로 변경
        if(answer[0]>6) answer[0]=6;
        if(answer[1]>6) answer[1]=6;
        
            
        return answer;
    }
}