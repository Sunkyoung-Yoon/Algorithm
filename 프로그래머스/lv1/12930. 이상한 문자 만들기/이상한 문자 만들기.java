class Solution {
    public String solution(String s) {
        String answer = "";
        //글자마다 분리해서 문자열로 배열에 저장
        String[] tokens = s.split("");
        int index = 0;
        
        for(int i=0; i<tokens.length; i++){
            
            //공백이후 나오는 단어의 인덱스는 0부터 세어야 함
            if(tokens[i].equals(" ")) index = 0;
            
            //짝수 인덱스 -> 대문자
            else if(index%2==0){
                tokens[i] = tokens[i].toUpperCase();
                index++;
            } 
            //홀수 인덱스 -> 소문자
            else {
                tokens[i] = tokens[i].toLowerCase();
                index++;
            }
            answer += tokens[i];
        }
        
        return answer;
    }
}