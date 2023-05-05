import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            int size = tangerine[i];
            map.put(size, map.getOrDefault(size,0)+1);
        }
        
        /*
        Collections.sort()를 사용해서 정렬하기 위해서
        Map.entrySet()을 이용해서 Map의 Entry Set을 List 형태로 저장한다.
        내림차순으로 정렬
        */
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) { 
	            return o2.getValue() - o1.getValue();
            }
        });
        
        //귤의 크기별 수가 가장 큰 것부터 상자에 담기
        // ex) k=6 [1,3,2,5,4,5,2,3] -> 2-2, 3-2, 5-2, 4-1, 1-1로 2,3,5 크기 종류가 추가
        for(Map.Entry<Integer, Integer> entry : entryList){
            if(k<=0) break;
            
            k -= entry.getValue();
            answer++;
        }
        return answer;
    }
}