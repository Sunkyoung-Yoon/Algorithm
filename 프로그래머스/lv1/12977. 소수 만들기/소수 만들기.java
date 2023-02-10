class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        //1000이하 중복없이 3개 최대 1000,999,998
        boolean[] check = new boolean[2998];
        
        check[0] = true;
        check[1] = true;
        //소수가 아닌수 true
        for(int i=2; i<=Math.sqrt(2998); i++){
            for(int j=i+i; j<2998; j+=i){
                check[j] = true;
            }
        }
        //3개의 수 더한 수 소수 체크
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    
                    int sum = nums[i]+nums[j]+nums[k];
                    //소수라면
                    if(!check[sum]) answer++;
                }
            }
        }

        return answer;
    }
}