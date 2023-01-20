import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        
        //두 개의 수 더한 값 리스트에 저장
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                int sum = numbers[i] + numbers[j];
                //중복되지 않은 수만 리스트에 저장
                if(!list.contains(sum)) list.add(sum);
            }
        }
        //오름차순 정렬
        Collections.sort(list);
        answer = new int[list.size()];
        //리스트 값 배열에 저장
        for(int i=0; i<list.size(); i++){
            //Integer -> int 타입으로 변경후 저장
            answer[i] = (list.get(i)).intValue();
        }
        return answer;
    }
}