class Solution {
    public String solution(String s) {
        String answer = "";
        int mid = s.length()/2;
        
        if(s.length()%2!=0) //단어의 길이 홀수
            answer = s.substring(mid,mid+1);
        else //단어의 길이 짝수
            answer = s.substring(mid-1,mid+1);
        
        return answer;
    }
}