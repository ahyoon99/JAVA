package Algorithm;

import java.util.*;
import java.io.*;

public class H231159 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static class Pair{
        int x;
        int y;
        Pair(){};
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        };
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] ground = new int[n][n];
        for(int i=0;i<n;i++){
            String com = sc.next();
            for(int j=0;j<n;j++){
                ground[i][j]=com.charAt(j)-'0';
            }
        }

        int[][] visited = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i],-1);
        }

        int num=1;
        ArrayList<Integer> result = new ArrayList<>(); 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(ground[i][j]==1 && visited[i][j]==-1){
                    result.add(BFS(ground, visited, n, i, j, num));
                    num++;
                }
            }
        }

        Collections.sort(result);
        System.out.println(num-1);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
        
    }

    static public int BFS(int[][] ground, int[][] visited, int n, int x, int y, int num){
        int cnt=0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        visited[x][y]=num;
        cnt++;

        while(!q.isEmpty()){
            Pair p =q.poll();
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<n){
                    if(ground[nx][ny]==1 && visited[nx][ny]==-1){
                        q.add(new Pair(nx, ny));
                        visited[nx][ny]=num;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
