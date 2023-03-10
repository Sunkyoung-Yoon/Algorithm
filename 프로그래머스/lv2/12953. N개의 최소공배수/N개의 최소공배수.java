import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        Arrays.sort(arr);
        for(int i=1; i<arr.length; i++){
            int a = answer;
            int b = arr[i];
            
            //최소공배수
            answer = a*b/GCD(a,b);
            
        }
        
        return answer;
    }
    
    public int GCD(int a, int b){
        if(a%b==0)
            return b;
        else
            return GCD(b,a%b);
    }

}