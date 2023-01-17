class Solution {
    public String solution(String phone_number) {
        String answer = phone_number.substring(0,phone_number.length()-4);
        answer = answer.replaceAll("[0-9]","*"); //뒷 4자리 제외 모두 *로 변경
        
        answer = answer+phone_number.substring(phone_number.length()-4, phone_number.length());
        
        return answer;
    }
}