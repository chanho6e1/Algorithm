import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4]; // x1, y1, x2, y2
        
        int N = wallpaper.length;
        int M = wallpaper[0].length();
        
        ArrayList<int[]> list = new ArrayList<>();
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if (wallpaper[i].charAt(j) == '#'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        return new int[]{minX, minY, maxX+1, maxY+1};
    }
}