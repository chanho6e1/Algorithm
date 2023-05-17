class Solution {
    
    static int N, M;
    static char[][] map;
    
    public int[] solution(String[] park, String[] routes) {
        
        N = park.length;
        M = park[0].length();
        
        int startX = 0;
        int startY = 0;
        
        map = new char[N][M];
        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                map[i][j] = park[i].charAt(j);
                
                if(map[i][j] == 'S'){
                    startX = i;
                    startY = j;
                }
            }
        }
        
        for(String route : routes){
            String[] str = route.split(" ");
            char op = route.charAt(0);
            int n = Integer.parseInt(str[1]);
            
            int nx = startX;
            int ny = startY;
            
            boolean check = true;
            
            for(int i=0; i<n; i++){
                switch (op){
                    case 'N':
                        nx--;
                        break;
                    case 'S':
                        nx++;
                        break;
                    case 'W':
                        ny--;
                        break;
                    case 'E':
                        ny++;
                        break;
                }
                if (nx >=0 && ny >=0 && nx<N && ny<M) {
                    if(map[nx][ny] == 'X') break;

                    if(i == n-1){
                        startX = nx;
                        startY = ny;
                    }
                }
            }
            
        }
        
        
        return new int[]{startX, startY};
    }
}