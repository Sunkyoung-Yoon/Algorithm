import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int count = nums.length/2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //중복되지 않는 키값 저장
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], 0);
        }
        
        if(count<=map.size()) //최대 선택할 수 있는 포켓몬은 N/2마리
            answer = count;
        else
            answer = map.size();
        
        return answer;
    }
}