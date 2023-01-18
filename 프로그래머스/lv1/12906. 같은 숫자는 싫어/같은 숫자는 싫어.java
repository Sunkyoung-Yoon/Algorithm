import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int pre = 0;
        
        pre = arr[0];
        list.add(arr[0]);
        
        //연속등장 제거하고 리스트에 숫자 저장
        for(int i=1; i<arr.length; i++){
            
            if(pre!=arr[i]){ //연속 등장이 아니면
                list.add(arr[i]);
                pre = arr[i];
            }
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).intValue(); //Integer -> int
        }
       

        return answer;
    }
}