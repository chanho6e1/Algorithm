class Solution {
    
    static int res;
    
    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);
        
        return res;
    }
    
    public void dfs(int[] numbers, int target, int sum, int idx){
        if(idx == numbers.length){
            if(sum == target){
                res += 1;
            }
            return;
        }
        
        dfs(numbers, target, sum - numbers[idx], idx+1);
        dfs(numbers, target, sum + numbers[idx], idx+1);
    }
}