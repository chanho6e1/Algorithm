class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int n = p.length();
        long numP = Long.parseLong(p);
        
        for (int i=0; i<t.length() - n + 1; i++){
            long temp = Long.parseLong(t.substring(i, i+n));
            // System.out.println(temp);
            if (temp <= numP) answer++;
        }
        
        return answer;
    }
}