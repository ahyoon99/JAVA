package Algorithm;

import java.util.*;

public class P1844 {
    // 풀이 1 << 최근
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static class Pair{
        int x;
        int y;
        
        Pair(){};
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static public void main(String args[]){
        int[][] maps = { {1,0,1,1,1},
                         {1,0,1,0,1},
                         {1,0,1,1,1},
                         {1,1,1,0,1},
                         {0,0,0,0,1}};

        int result = solution(maps);
        System.out.println(result);
    }

    static public int solution(int[][] maps) {
        int answer = 0;

        int n = maps.length;
        int m = maps[0].length;
        int[][] result = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(result[i],-1);
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        result[0][0]=1;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<m){
                    if(maps[nx][ny]==1 && result[nx][ny]==-1){
                        q.add(new Pair(nx, ny));
                        result[nx][ny]=result[x][y]+1;
                    }
                }
            }
        }
        answer = result[n-1][m-1];
        return answer;
    }

    // 풀이 2
    // static class Pair{
    //     int x;
    //     int y;
    //     Pair(){}
    //     Pair(int x, int y){
    //         this.x=x;
    //         this.y=y;
    //     }
    // }
    
    // static int[] dx= {-1,0,1,0};
    // static int[] dy= {0,1,0,-1};
    
    // static public void main(String args[]){
    //     int[][] maps = { {1,0,1,1,1},
    //                      {1,0,1,0,1},
    //                      {1,0,1,1,1},
    //                      {1,1,1,0,1},
    //                      {0,0,0,0,1}};

    //     int result = solution(maps);
    //     System.out.println(result);
    // }
    
    // static public int solution(int[][] maps) {
    //     int answer = 0;
        
    //     int n = maps.length;
    //     int m = maps[0].length;
    //     boolean[][] visited = new boolean[n][m];
    //     int[][] root = new int[n][m];
    //     Queue<Pair> q = new LinkedList<>();
        
    //     q.add(new Pair(0,0));
    //     visited[0][0]=true;
    //     root[0][0]=1;
        
    //     while(!q.isEmpty()){
    //         Pair p = q.poll();
    //         int x = p.x;
    //         int y = p.y;
    //         for(int i=0;i<4;i++){
    //             int nx = x+dx[i];
    //             int ny = y+dy[i];
    //             if(0<=nx && nx<n && 0<=ny && ny<m){
    //                 if(maps[nx][ny]==1 && visited[nx][ny]==false){
    //                     q.add(new Pair(nx, ny));
    //                     visited[nx][ny]=true;
    //                     root[nx][ny]=root[x][y]+1;
    //                 }
    //             }
    //         }
    //     }
        
    //     answer = (root[n-1][m-1]==0) ? -1 : root[n-1][m-1];
    //     return answer;
    // }
}
