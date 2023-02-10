class Solution {
    public int solution(int[] nums) {
        int answer = 0;
       
        //3개의 수 더한 수 소수 체크
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    
                    int sum = nums[i]+nums[j]+nums[k];
                    //소수라면
                    if(isPrime(sum)) answer++;
                }
            }
        }

        return answer;
    }
    
    //소수판별
    public boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            //1과 자기자신외에 나눠지는 수가 있다면 
            if(num%i==0) return false;
        }
        
        return true;
    }
}