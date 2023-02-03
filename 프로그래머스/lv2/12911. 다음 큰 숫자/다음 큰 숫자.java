class Solution {
    public int solution(int n) {
        
        int next = n+1;
        //이진변환한 수 문자열로 저장
        String s1 = Integer.toBinaryString(n);
        String s2 = "";
        //이진변환한 수 1 개수 저장
        int count_s1 = Integer.bitCount(n);
        int count_s2 = 0;
        
        
        while(true){
            //이진변환한 수 문자열로 저장
            s2 = Integer.toBinaryString(next);
            //이진변환한 수 1 개수 저장
            count_s2 = Integer.bitCount(next);
            
            //1의 개수가 같은 다음 큰 숫자 발견
            if(count_s1==count_s2){
                return next;
            }
            next++;
        }
    }
}