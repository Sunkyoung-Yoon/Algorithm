class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] check = new boolean[500501];
        
        //소수가 아닌수 true
        check[0] = true;
        check[1] = true;
        for(int i=2; i<=Math.sqrt(500501); i++){
            for(int j=i+i; j<500501; j+=i){
                check[j] = true;
            }
        }
        //3개의 수 더한 수 소수 체크
        for(int i=0; i<nums.length-2; i++){
            int sum = 0;
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    sum = nums[i]+nums[j]+nums[k];
                    if(!check[sum]) answer++;
                }
            }
        }

        return answer;
    }
}