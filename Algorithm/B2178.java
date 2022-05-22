package Algorithm;

import java.util.*;

public class B2178 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static public void BFS(int[][] map, int[][] distance, int x, int y){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        distance[x][y]=1;
        while(!q.isEmpty()){
            x = q.peek().x;
            y = q.peek().y;
            q.poll();
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<map.length && 0<=ny && ny<map[0].length){
                    if(map[nx][ny]==1 && distance[nx][ny]==0){
                        q.add(new Pair(nx, ny));
                        distance[nx][ny]=distance[x][y]+1;
                    }
                }
            }
        }
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        int[][] distance = new int[n][m];
        for(int i=0;i<n;i++){
            String med = sc.next();
            for(int j=0;j<m;j++){
                char num = med.charAt(j);
                map[i][j]=num-'0';
            }
        }
        BFS(map, distance, 0, 0);
        System.out.println(distance[n-1][m-1]);
    }
    
}
