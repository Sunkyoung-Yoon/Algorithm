class Solution {
    public int solution(String s) {
        int answer = 0;
        String str[] = {"zero", "one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i=0; i<str.length; i++){
            s = s.replace(str[i],String.valueOf(i));
        }
        
        answer = Integer.valueOf(s);
        return answer;
    }
}