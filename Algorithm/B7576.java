package Algorithm;

import java.util.*;

public class B7576 {
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] tomato = new int[m][n];
        int[][] dist = new int [m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                tomato[i][j]=sc.nextInt();
                dist[i][j]=-1;
                if(tomato[i][j]==1){
                    q.add(new Pair(i,j));
                    dist[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<tomato.length && 0<=ny && ny<tomato[0].length){
                    if(tomato[nx][ny]==0 && dist[nx][ny]==-1){
                        q.add(new Pair(nx, ny));
                        dist[nx][ny]=dist[x][y]+1;
                    }
                }
            }
        }
        int max = -10;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(max<dist[i][j]){
                    max=dist[i][j];
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(tomato[i][j]==0 && dist[i][j]==-1){
                    max=-1;
                }
            }
        }
        System.out.println(max);
    }
    
}
