class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            //공백인 경우
            if(ch==' '){
                answer += " ";
                continue;            
            } 
            //소문자 밀기
            if(Character.isLowerCase(ch)) {
                if(ch+n>'z')
                    answer += ((char)(ch+n-26));
                else
                     answer += ((char)(ch+n));
               
            }
            //대문자 밀기
            else if(Character.isUpperCase(ch)){
                if(ch+n>'Z')
                     answer += ((char)(ch+n-26));
                else
                     answer += ((char)(ch+n));
            }
        }
    
        return answer;
    }
}