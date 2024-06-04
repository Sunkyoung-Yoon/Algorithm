import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        
        Map<String, Integer> map = new HashMap<>();
        ArrayList<Integer> playList = new ArrayList<>();
        
        // 장르별 재생 수 구하기
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        // 재생 수 내림차순으로 장르 정렬
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });
            
        // for(String s : keyList) {
        //     System.out.println(s);
        //     System.out.println(map.get(s));
        // }
        
        
        // 장르별로 노래 고유 리스트 저장
        for(int i=0; i<keyList.size(); i++){
            List<int[]> genrePlayList = new ArrayList<>();
            
            // 해당 장르를 가진 곡리스트 저장 -> 정렬
            for(int j=0; j<genres.length; j++){
                String genre = genres[j];
                int play = plays[j];
                int num = j;
                // 해당 장르라면 genrePlayList에 저장
                if(keyList.get(i).equals(genre)) {
                    genrePlayList.add(new int[]{num, play});
                }
                
                Collections.sort(genrePlayList,(o1,o2) -> {
                    if(o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }
                    else
                        return o2[1] -o1[1];
                });
            }
            
            // 정렬된 순서대로 담기, 개수가 1개이하라면 1개만
            if(genrePlayList.size() >= 2) {
                playList.add(genrePlayList.get(0)[0]);
                playList.add(genrePlayList.get(1)[0]);
            }
            else if(genrePlayList.size() == 1){
                playList.add(genrePlayList.get(0)[0]);
            }
                
        }
        // 리스트를 배열로 변환
        answer = playList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}