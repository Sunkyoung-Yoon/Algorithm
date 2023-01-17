class Solution {
    public String solution(String phone_number) {
        String str = "";
        char[] ch = phone_number.toCharArray();
        
        for(int i=0; i<ch.length-4; i++){
            ch[i] = '*';
        }
        
        for(int i=0; i<ch.length; i++){
            str += ch[i];
        }
        
        return str;
    }
}