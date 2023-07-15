import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int s : score){
            
            if (list.size()<k){
                list.add(s);
                Collections.sort(list);
                // result.add(list.get(0));
                // continue;
            }
            
            else if (list.size()==k){
                int min = list.get(0);
                
                if (min < s){
                    list.remove(0);
                    list.add(s);
                    Collections.sort(list);
                }
                
                // result.add(list.get(0));
            }
            
            result.add(list.get(0));
            
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}