class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // number : 기사단원의 수
        // limit : 제한수치
        // power : 제한수치를 초과한 기사가 사용할 무기의 공격력
        
        for(int i=1; i<=number; i++){
            int cnt = divisor(i);
            
            if(limit < cnt) answer += power;
            else answer += cnt;
        }
        
        return answer;
    }
    
    private static int divisor(int num){
        
        int cnt = 0;
        
        for(int i=1; i * i<=num; i++)
            if (i*i == num) cnt++;
            else if(num % i == 0) cnt +=2;
        
        return cnt;
    }
}