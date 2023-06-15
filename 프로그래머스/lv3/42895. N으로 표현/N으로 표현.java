class Solution {
    
    static int answer;
    
    public int solution(int N, int number) {
        answer = -1;
        
        dfs(N, number, 0, 0);
        
        return answer;
    }
    
    private void dfs(int N, int number, int sum, int idx){
        if (idx > 8) return;
        
        if (sum == number){
            if(idx < answer || answer == -1) answer = idx;
            return;
        }
        
        int temp = 0;
        for (int i=1; i<9; i++){
            temp = temp * 10 + N;
            dfs(N, number, sum + temp, idx+i);
            dfs(N, number, sum - temp, idx+i);
            dfs(N, number, sum * temp, idx+i);
            dfs(N, number, sum / temp, idx+i);
        }
    }
}