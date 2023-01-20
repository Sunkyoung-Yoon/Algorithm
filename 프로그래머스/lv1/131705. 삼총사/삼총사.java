class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        for(int i=0; i<number.length-2; i++){
            int sum = 0;
            for(int j=i+1; j<number.length-1; j++){
                for(int k=j+1; k<number.length; k++){
                    sum = number[i]+number[j]+number[k];
                    if(sum==0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}