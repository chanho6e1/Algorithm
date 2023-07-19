import java.util.*;

class Solution {
    public long solution(long n) {
        
        Double temp = Math.sqrt(n);
        
        if (temp == temp.intValue()){
            return (long) Math.pow(temp + 1, 2);
      } else return -1;
    }
}