class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        //부분 문자열 숫자와 s 문자열 숫자 비교
        for(int i=0; i<t.length()-p.length()+1; i++){
            
            Long s = Long.parseLong(t.substring(i,p.length()+i));
            if(s<=Long.parseLong(p)) answer++;
        }
       
        return answer;
    }
}