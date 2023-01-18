class Solution {
    public boolean solution(String s) {
        boolean answer = true;
     
        String str = s.replaceAll("[0-9]","0"); //숫자로만 이루어졌다면 모두 0으로 변경
        
        if(!(str.length()==4 || str.length()==6)){
            return false;
        }
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)!='0'){
                answer = false;
                break;
            }
        }
        return answer;
    }
}