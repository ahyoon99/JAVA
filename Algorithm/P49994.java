package Algorithm;

import java.util.*;

public class P49994 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static public void main(String args[]){
        // tc1
        String dirs = "ULURRDLLU";
        
        // tc2
        // String dirs = "DUD";
        
        int result = solution(dirs);
        System.out.println(result);
    }

    static public int solution(String dirs) {
        int answer = 0;
        
        boolean[][][][] visited = new boolean[11][11][11][11];
        
        int x = 5;
        int y = 5;
        for(int i=0;i<dirs.length();i++){
            int idx=-1;
            if(dirs.charAt(i)=='U'){
                idx = 0;
            }
            else if(dirs.charAt(i)=='R'){
                idx = 1;
            }
            else if(dirs.charAt(i)=='D'){
                idx = 2;
            }
            else if(dirs.charAt(i)=='L'){
                idx = 3;
            }
            int nx = x+dx[idx];
            int ny = y+dy[idx];
            
            if(0<=nx && nx<11 && 0<=ny && ny<11){
                if(visited[x][y][nx][ny]==false){
                    answer++;
                    visited[x][y][nx][ny]=true;
                    visited[nx][ny][x][y]=true;
                }
                x = nx;
                y = ny;
            }
        }
        
        return answer;
    }
}
