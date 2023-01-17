class Solution {
    public int solution(int num) {
        int count = 0; //작업 횟수
        long n = (long)num;
        
        if(n==1)
            return 0;
        
        while(true){
            
            if(count==500){
                return -1;
            }
            
            if(n==1)
                break;
            
            if(n%2==0) n=n/2;
            else n=n*3+1;
            
            count++;
        }
        
        return count;
    }
}