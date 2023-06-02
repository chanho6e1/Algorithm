import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 장르별 총 횟수
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>(); // 장르별 <고유번호, 횟수>
        for(int i=0; i<genres.length; i++){
            
            if(map.containsKey(genres[i])){
                music.get(genres[i]).put(i, plays[i]);
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            }else{
                HashMap<Integer, Integer> temp = new HashMap<>();
                temp.put(i, plays[i]);
                music.put(genres[i], temp);
                map.put(genres[i], plays[i]);
            }
        }
        
        // System.out.println(map);
        // System.out.println(music);
        
        ArrayList<String> keySet = new ArrayList(map.keySet());
        Collections.sort(keySet, (o1, o2)->(map.get(o2) - map.get(o1)));
        
        // System.out.println(keySet);
        
        for(String key : keySet){
            HashMap<Integer, Integer> res = music.get(key);
            ArrayList<Integer> genre_key = new ArrayList(res.keySet());
            
            Collections.sort(genre_key, (o1, o2) -> res.get(o2) - res.get(o1));
            
            answer.add(genre_key.get(0));
            if(genre_key.size()>1){
                answer.add(genre_key.get(1));
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}