import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4]; // x1, y1, x2, y2
        
        int N = wallpaper.length;
        int M = wallpaper[0].length();
        
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if (wallpaper[i].charAt(j) == '#'){
                    list.add(new int[]{i, j});
                }
            }
        }
        
        Collections.sort(list, (o1, o2) -> (o1[0] - o2[0]));
        answer[0] = list.get(0)[0];
        answer[2] = list.get(list.size()-1)[0]+1;
        
        Collections.sort(list, (o1, o2) -> (o1[1] - o2[1]));
        answer[1] = list.get(0)[1];
        answer[3] = list.get(list.size()-1)[1] + 1;
        
        return answer;
    }
}