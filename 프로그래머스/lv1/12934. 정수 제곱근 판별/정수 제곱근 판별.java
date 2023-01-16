class Solution {
    public long solution(long n) {
        long answer = 0;
        int num = (int)Math.sqrt(n);
        
        if(Math.pow(num,2) == n){
            answer = (long)Math.pow(num+1,2);
            return answer;
        }
        
        return -1;
    }
}