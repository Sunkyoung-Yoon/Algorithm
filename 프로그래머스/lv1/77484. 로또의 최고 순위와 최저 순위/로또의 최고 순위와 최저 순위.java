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
        
        //1개이하로 맞춘 경우는 최소6등, 최대1등
        if(count<=1){
            answer[1] = 6;
            if(zero_count==0) answer[0] = 6;
            else answer[0] = 7-count-zero_count;
        } 
        else { //2개이상 맞춘 경우는 7에서 count, zero_count 빼기
            answer[1] = 7-count;
            answer[0] = 7-count-zero_count;
        }
            
        return answer;
    }
}