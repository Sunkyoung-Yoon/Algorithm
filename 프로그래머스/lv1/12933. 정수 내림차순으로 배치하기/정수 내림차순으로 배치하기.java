import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        int[] arr = new int[str.length()];
        
        for(int i=0; i<str.length(); i++){
            arr[i] = str.charAt(i)-'0';
        }
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++){
            answer += arr[arr.length-1-i]*Math.pow(10, arr.length-1-i);
        }
        
        return answer;
    }
}