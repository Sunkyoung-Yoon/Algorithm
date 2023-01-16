class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int count1 = 0;
        int count2 = 0;
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='p' || ch=='P') count1++;
            if(ch=='y' || ch=='Y') count2++;
        }
        
        if(count1!=count2) answer=false;
        
        return answer;
    }
}