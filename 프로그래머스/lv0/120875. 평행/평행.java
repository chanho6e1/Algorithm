class Solution {
    public int solution(int[][] dots) {
        
        if (slope(dots[0], dots[1]) == slope(dots[2], dots[3]))
            return 1;
        if (slope(dots[0], dots[2]) == slope(dots[1], dots[3]))
            return 1;
        if (slope(dots[0], dots[3]) == slope(dots[2], dots[1]))
            return 1;
        
        return 0;
    }
    
    private double slope(int[] a, int[] b){
        return (double) (a[1]-b[1])/(a[0]-b[0]);
    }
}