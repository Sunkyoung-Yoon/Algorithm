class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i=0; i<babbling.length; i++){
            //babbling[i]에  "aya", "ye", "woo", "ma" 연속으로 있는 단어는 발음 불가
            if(babbling[i].contains("ayaaya")||babbling[i].contains("yeye") 
               ||babbling[i].contains("woowoo") || babbling[i].contains("mama"))
                continue;
            
            // "aya", "ye", "woo", "ma"이 있다면 " "으로 대체
            //""으로 할경우 yayae가 aya->""이 되면 ye가 되버리기 때문
            babbling[i] = babbling[i].replace("aya"," ");
            babbling[i] = babbling[i].replace("ye"," ");
            babbling[i] = babbling[i].replace("woo"," ");
            babbling[i] = babbling[i].replace("ma"," ");
            
            //공백 제거
            babbling[i] = babbling[i].replace(" ","");
            
            if(babbling[i].equals("")) answer++;
        }
        
        return answer;
    }
}