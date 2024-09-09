import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] tmp = s.split(" ");
        
        // 문자열 끊어서 숫자로 변환
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<tmp.length; i++) {
            int num = Integer.parseInt(tmp[i]);
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        
        answer = String.valueOf(min+" "+max);
        
        return answer;
    }
}