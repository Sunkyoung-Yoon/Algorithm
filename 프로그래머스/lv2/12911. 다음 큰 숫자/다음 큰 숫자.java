class Solution {
    public int solution(int n) {
        
        int next = n+1;
        //이진변환한 수 1 개수 저장
        int count_n = Integer.bitCount(n);
        int count_next = 0;
        
        
        while(true){
            //이진변환한 수 1 개수 저장
            count_next = Integer.bitCount(next);
            
            //1의 개수가 같은 다음 큰 숫자 발견
            if(count_n==count_next){
                return next;
            }
            next++;
        }
    }
}