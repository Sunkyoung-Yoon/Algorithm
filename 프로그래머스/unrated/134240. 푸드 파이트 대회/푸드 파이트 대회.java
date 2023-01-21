class Solution {
    public String solution(int[] food) {
        String answer = "";
        String str = "";
        
        for(int i=1; i<food.length; i++){
            //1인 경우는 경기에 쓸 수 없음
            if(food[i]==1) continue;
            
            while(food[i]>1){
                answer += String.valueOf(i);
                str = String.valueOf(i) + str;
                food[i] -=2;
            }
        }
        
        answer = answer+"0"+str;
        return answer;
    }
}