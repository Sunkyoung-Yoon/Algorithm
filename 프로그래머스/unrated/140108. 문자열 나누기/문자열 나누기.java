class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int count_x = 1; //x인 글자 개수
        int count_o = 0; //x가 아닌 글자 개수
        int start = 0; //부분 문자열 시작 부분
        int end = 0; //부분 문자열 끝 부분
        
        //길이가 1인 경우
        if(s.length()==1) answer++;
        
        char x = s.charAt(start); //맨처음 글자
        for(int i=1; i<s.length(); i++){
            char ch = s.charAt(i); //현재 글자
            
            if(x==ch) count_x++; //x와 글자 같다면 x개수 증가
            else count_o++; //x가 아닌 수 개수 증가
            
           
            if(count_x==count_o){//x인 글자와 아닌 글자 수 동일
                end = i;
                //end가 문자열의 끝이 아닌 경우 start 변경
                if(end<s.length()-1) start = end+1;
                count_x = 0;
                count_o = 0;
                answer++;
               
            }
            
            x = s.charAt(start); //새로운 첫글자 x
        }
        

        
        //end가 s의 끝이 아니라면 남은 문자열 존재 -> 문자열 개수 추가
        if(end < s.length()-1) answer++;
        
        return answer;
    }
}